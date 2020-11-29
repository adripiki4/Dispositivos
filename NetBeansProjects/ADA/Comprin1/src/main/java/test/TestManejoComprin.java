/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import datos.CompraDAO;
import datos.Conexion;
import datos.DevolucionDAO;
import datos.EwalletDAO;
import datos.ProductoDAO;
import domain.Compra;
import domain.Devolucion;
import domain.Ewallet;
import domain.Producto;
import java.text.ParseException;
import java.sql.*;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author adrip
 */
public class TestManejoComprin {

    public static void main(String[] args) throws ParseException, SQLException {

        boolean exit = false;
        int opcion;
        Scanner sc = new Scanner(System.in);

        do {
            Menu();
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    InsertarEwallet();
                    break;

                case 2:
                    ListarEwallets();
                    RecargarWallet();
                    break;

                case 3:
                    CrearProductos();
                    break;

                case 4:
                    ComprarProducto();
                    break;

                case 5:
                    DevolverProducto();
                    break;

                case 6:
                    CanjearProductos();
                    break;

                case 7:
                    ListarProductos();
                    break;

                case 8:
                    ConsultarMovimientos();
                    break;

                case 9:
                    ModificarProducto();
                    break;

                case 10:
                    exit = true;
                    break;
            }

        } while (exit == false);

    }

    public static void Menu() {
        System.out.println("\n"
                + "-----------------MENU-----------------\n"
                + "1.-Fidelizar cliente\n"
                + "2.-Recargar saldo.\n"
                + "3.-Dar de alta nuevos productos.\n"
                + "4.-Comprar productos.\n"
                + "5.-Devolucion de productos.\n"
                + "6.-Canjear puntos de E-Wallet.\n"
                + "7.-Ver catalogo de productos.\n"
                + "8.-Consultar movimientos de E-Wallet.\n"
                + "9.-Modificar precios y puntos.\n"
                + "10.-Salir.\n"
                + "--------------------------------------");
    }

    public static void InsertarEwallet() throws ParseException {
        Connection conexion = null;
        Scanner sc = new Scanner(System.in);
        String nombre = "";
        String apellidos = "";
        String dni = "";
        String email = "";
        String fechaNacimiento = "";

        try {
            Ewallet nueva = new Ewallet();
            conexion = Conexion.getConnection();

            if (conexion.getAutoCommit()) {
                conexion.setAutoCommit(false);
            }

            EwalletDAO ewalletdao = new EwalletDAO(conexion);
            System.out.println("Introduce el nombre del cliente: ");
            nombre = sc.nextLine();
            System.out.println("Introduce los apellidos del cliente: ");
            apellidos = sc.nextLine();
            System.out.println("Introduce el DNI del cliente: ");
            dni = sc.nextLine();
            System.out.println("Introduce la fecha de nacimiento del cliente(yyyy-MM-dd): ");
            fechaNacimiento = sc.nextLine();
            System.out.println("Introduce el email del cliente: ");
            email = sc.nextLine();

            //Parseamos la fecha para comparla con la fecha actual y comprobar si es mayor de edad
            DateTimeFormatter dtm = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate nacimiento = LocalDate.parse(fechaNacimiento, dtm);
            LocalDate now = LocalDate.now();
            Period per = Period.between(nacimiento, now);
            System.out.println("Tiene una de edad de " + per.getYears());
            if (per.getYears() < 18) {
                System.out.println("Es menor de edad, no puede ser cliente.");
                conexion.rollback();

            } else {
                System.out.println("Es mayor de edad");

                //Formato de fecha
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                java.util.Date fecha = sdf.parse(fechaNacimiento);
                //Formato de fecha para SQL
                java.sql.Date fechabuena = new java.sql.Date(fecha.getTime());

                //Creamos la nueva e-Wallet
                nueva = new Ewallet(nombre, apellidos, dni, fechabuena, email);
                ewalletdao.Insertar(nueva);
                System.out.println("Se ha registrado correctamente");
            }
            conexion.commit();

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
            System.out.println("Algo ha fallado, Entramos al rollback");
            try {
                conexion.rollback();
            } catch (SQLException ex1) {
                ex1.printStackTrace(System.out);
            }
        }
    }

    public static void ListarEwallets() throws SQLException, ParseException {
        Connection conexion = null;
        try {
            conexion = Conexion.getConnection();
            if (conexion.getAutoCommit()) {
                conexion.setAutoCommit(false);
            }

            EwalletDAO ewalletdao = new EwalletDAO(conexion);
            List<Ewallet> listawallet = ewalletdao.Seleccionar();
            for (Ewallet w : listawallet) {
                System.out.println(w);
                System.out.println("\n");
            }

            conexion.commit();

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
            System.out.println("Algo ha fallado, Entramos al rollback");
            try {
                conexion.rollback();
            } catch (SQLException ex1) {
                ex1.printStackTrace(System.out);
            }
        }
    }

    public static void RecargarWallet() {
        Scanner sc = new Scanner(System.in);
        int id_wallet;
        int recarga;
        int saldo;
        boolean encontrado = false;
        Connection conexion = null;

        try {
            Ewallet busca = new Ewallet();
            conexion = Conexion.getConnection();

            if (conexion.getAutoCommit()) {
                conexion.setAutoCommit(false);
            }
            EwalletDAO ewalletdao = new EwalletDAO(conexion);
            //Pedimos un id por teclado y lo buscamos en la base de datos.
            System.out.println("Introduzca un Id_wallet para su recarga: ");
            id_wallet = sc.nextInt();
            busca = ewalletdao.BuscarWallet(id_wallet);
            //Comprobamos si ha encontrado una Ewallet valida.
            if (busca.getId_wallet() == 0) {
                System.out.println("No se ha encontrado ninguna E-wallet.");
                return;
            } else {
                System.out.println("Se ha encontrado una E-wallet.");
                System.out.println(busca + "€ saldo actual.");
                System.out.println(busca.getSaldoEuros());
                System.out.println("Introduzca la cantidad que desea recargar: ");
                recarga = sc.nextInt();
                saldo = busca.getSaldoEuros();
                saldo = saldo + recarga;
                busca.setSaldoEuros(saldo);
                ewalletdao.Actualizar(busca);

                //Para recargar entre el dia 1 y 5 de cada mes
                java.util.Date fecha = new java.util.Date();
                SimpleDateFormat sdf = new SimpleDateFormat("dd");
                String dia = sdf.format(fecha);
                int diaint = Integer.parseInt(dia);

                conexion.commit();
                System.out.println("Se ha realizado la recarga");

            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
            System.out.println("Algo ha fallado, Entramos al rollback");
            try {
                conexion.rollback();
            } catch (SQLException ex1) {
                ex1.printStackTrace(System.out);
            }
        }

    }

    public static void CrearProductos() {
        Scanner sc = new Scanner(System.in);
        String nombre;
        int precio;
        int puntos;
        Connection conexion = null;

        try {
            conexion = Conexion.getConnection();

            if (conexion.getAutoCommit()) {
                conexion.setAutoCommit(false);
            }
            ProductoDAO prodao = new ProductoDAO(conexion);
            System.out.println("Introduzca el nombre del  nuevo producto:");
            nombre = sc.nextLine();
            System.out.println("Introduzca el precio del nuevo producto:");
            precio = sc.nextInt();
            System.out.println("introduzca los puntos del nuevo producto:");
            puntos = sc.nextInt();
            Producto nuevo = new Producto(nombre, precio, puntos);
            prodao.Insertar(nuevo);

            conexion.commit();
            System.out.println("Se ha creado nuevo producto");

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
            System.out.println("Algo ha fallado, Entramos al rollback");
            try {
                conexion.rollback();
            } catch (SQLException ex1) {
                ex1.printStackTrace(System.out);
            }
        }
    }

    public static void ComprarProducto() {
        Scanner sc = new Scanner(System.in);
        int id_producto;
        int id_wallet;
        int precio;
        int puntos;
        int saldo = 0;
        int puntoswallet;

        Connection conexion = null;

        try {
            conexion = Conexion.getConnection();
            Ewallet ewallet = new Ewallet();
            Producto producto = new Producto();
            EwalletDAO ewalletdao = new EwalletDAO();
            ProductoDAO prodao = new ProductoDAO();

            if (conexion.getAutoCommit()) {
                conexion.setAutoCommit(false);
            }

            CompraDAO compradao = new CompraDAO(conexion);

            System.out.println("Introduzca el Id del producto que desea comprar: ");
            id_producto = sc.nextInt();
            //Buscamos el produco a traves de su id
            producto = prodao.BuscarProducto(id_producto);
            //Si no se encuentra no realiza la compra
            if (producto.getId_producto() == 0) {
                System.out.println("Ese producto no existe");
                conexion.rollback();
                return;
            } else {
                precio = producto.getPrecioProducto();
                puntos = producto.getPuntosProducto();
                System.out.println("Ha seleccionado: " + producto);
                //Una vez localizado el producto identificamos al cliente.
                System.out.println("Introduzca su Id_wallet para identificarse y realizar el pago");
                id_wallet = sc.nextInt();
                ewallet = ewalletdao.BuscarWallet(id_wallet);

                //si no se encuentra el cliente no realiza la compra.
                if (ewallet.getId_wallet() == 0) {
                    System.out.println("No se ha encontrado ese Id_wallet");
                    conexion.rollback();

                } else {
                    java.util.Date fecha = new java.util.Date();
                    long lo = fecha.getTime();
                    Date fechapasa = new Date(lo);
                    System.out.println("Se ha encontrado: "+ewallet);
                    Compra compra = new Compra(fechapasa, id_wallet, id_producto);
                    //Si inserto aqui la compra se queda el programa pillado.
//                    compradao.Insertar(compra);
                    saldo = ewallet.getSaldoEuros();
                    puntoswallet = ewallet.getSaldoPuntos();

                    if (precio > saldo) {
                        System.out.println("No se puede comprar");
                        conexion.rollback();
                    } else if (precio <= saldo) {
                        saldo = saldo - precio;
                        puntoswallet = puntoswallet + puntos;
                        ewallet.setSaldoEuros(saldo);
                        ewallet.setSaldoPuntos(puntoswallet);
                        ewalletdao.Actualizar(ewallet);
                        compradao.Insertar(compra);
                        System.out.println("Compra realizada");
                    }

                }

            }
            conexion.commit();

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
            System.out.println("Algo ha fallado, Entramos al rollback");
            try {
                conexion.rollback();
            } catch (SQLException ex1) {
                ex1.printStackTrace(System.out);
            }
        }
    }

    public static void DevolverProducto() {
        Scanner sc = new Scanner(System.in);
        int id_compra;
        int id_producto;
        int id_ewallet;
        int preciopro;
        int puntospro;
        int saldowallet;
        int puntoswallet;
        boolean findcompra = false;

        Connection conexion = null;

        try {
            conexion = Conexion.getConnection();
            CompraDAO compradao = new CompraDAO();
            EwalletDAO ewalletdao = new EwalletDAO();
            ProductoDAO productodao = new ProductoDAO();
            Compra comprabusca = new Compra();
            Ewallet ewallet = new Ewallet();
            Producto producto = new Producto();
            Devolucion devolucion = null;

            if (conexion.getAutoCommit()) {
                conexion.setAutoCommit(false);
            }

            DevolucionDAO devoluciondao = new DevolucionDAO(conexion);

            System.out.println("Introduzca el Id_Compra que desea devolver: ");
            id_compra = sc.nextInt();
            comprabusca = compradao.BuscarCompra(id_compra);
            if (comprabusca.getId_compra() == 0) {
                System.out.println("Esa compra no está registrada en nuestro SuperComprin");
                findcompra = false;
            } else {
                System.out.println("Se ha encontrado la Compra " + comprabusca);
                findcompra = true;
            }
            if (findcompra == true) {
                //Buscamos la ewallet que le corresponde
                id_ewallet = comprabusca.getId_wallet();
                ewallet = ewalletdao.BuscarWallet(id_ewallet);

                //Buscamos el producto para saber el precio y los puntos
                id_producto = comprabusca.getId_producto();
                producto = productodao.BuscarProducto(id_producto);

                System.out.println("Se va a hacer devolucion del producto: " + producto);
                System.out.println("La compra se realizo desde: "+ewallet);

                //Obtenemos los valores del producto
                preciopro = producto.getPrecioProducto();
                puntospro = producto.getPuntosProducto();

                //Obtenemos los valores del wallet
                saldowallet = ewallet.getSaldoEuros();
                puntoswallet = ewallet.getSaldoPuntos();

                //Registramos la devolucion y eliminamos la compra
                java.util.Date fecha = new java.util.Date();
                long lo = fecha.getTime();
                Date fechapasa = new Date(lo);
                devolucion = new Devolucion(fechapasa, id_ewallet, id_producto);

                //Insertar la devolucion la devolucion y eliminar la compra se deberia de hacer aqui, pero se queda colgado el progarama :(
//                devoluciondao.Insertar(devolucion);
//                compradao.Eliminar(comprabusca);
                //Comprobamos la condicion
                puntoswallet = puntoswallet - puntospro;
                saldowallet = saldowallet + preciopro;

                if (puntoswallet < 5) {
                    System.out.println("El saldo de puntos no se puede quedar por debajo de 5 puntos, no se puede realizar la devolucion");
                    conexion.rollback();
                } else {
                    ewallet.setSaldoPuntos(puntoswallet);
                    ewallet.setSaldoEuros(saldowallet);
                    ewalletdao.Actualizar(ewallet);
                    devoluciondao.Insertar(devolucion);
                    compradao.Eliminar(comprabusca);
                    System.out.println("Se ha realizado la devolucion correctamente.");

                }
                findcompra = false;
            }
            conexion.commit();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
            System.out.println("Algo ha fallado, Entramos al rollback");
            try {
                conexion.rollback();
            } catch (SQLException ex1) {
                ex1.printStackTrace(System.out);
            }
        }
    }

    public static void ListarProductos() throws SQLException {
        Connection conexion = null;
        try {
            conexion = Conexion.getConnection();
            if (conexion.getAutoCommit()) {
                conexion.setAutoCommit(false);
            }

            ProductoDAO prodao = new ProductoDAO(conexion);
            List<Producto> listapro = prodao.Seleccionar();

            //Recorremos la lista para imprimir
            for (Producto pro : listapro) {
                System.out.println(pro);
            }

            conexion.commit();

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
            System.out.println("Algo ha fallado, Entramos al rollback");
            try {
                conexion.rollback();
            } catch (SQLException ex1) {
                ex1.printStackTrace(System.out);
            }
        }
    }

    public static void CanjearProductos() {
        Scanner sc = new Scanner(System.in);
        int id_wallet;
        int id_producto;
        int puntos;
        int puntoswallet;
        int precio;
        Connection conexion = null;
        try {
            conexion = Conexion.getConnection();
            Ewallet ewallet = new Ewallet();
            Producto producto = new Producto();
            EwalletDAO ewalletdao = new EwalletDAO();
            ProductoDAO prodao = new ProductoDAO();

            if (conexion.getAutoCommit()) {
                conexion.setAutoCommit(false);
            }

            CompraDAO compradao = new CompraDAO(conexion);

            System.out.println("Introduzca el Id del producto que desea canjear con puntos: ");
            id_producto = sc.nextInt();
            //Buscamos el produco a traves de su id
            producto = prodao.BuscarProducto(id_producto);
            //Si no se encuentra no realiza la compra
            if (producto.getId_producto() == 0) {
                System.out.println("Ese producto no existe");
                conexion.rollback();
                return;
            } else {
                precio = producto.getPrecioProducto();
                puntos = producto.getPuntosProducto();
                System.out.println("El producto tiene un valor de " + puntos + " puntos.");
                //Una vez localizado el producto identificamos al cliente.
                System.out.println("Introduzca su Id_wallet para identificarse y canjear sus puntos");
                id_wallet = sc.nextInt();
                ewallet = ewalletdao.BuscarWallet(id_wallet);
                System.out.println(ewallet);
                //si no se encuentra el cliente no realiza la compra.
                if (ewallet.getId_wallet() == 0) {
                    System.out.println("No se ha encontrado ese Id_wallet");
                    conexion.rollback();

                } else {
                    java.util.Date fecha = new java.util.Date();
                    long lo = fecha.getTime();
                    Date fechapasa = new Date(lo);

                    Compra compra = new Compra(fechapasa, id_wallet, id_producto);
                    //La compra se insertaria aqui, pero el programa se queda colgado.
//                    compradao.Insertar(compra);

                    puntoswallet = ewallet.getSaldoPuntos();

                    if (precio < 5) {
                        System.out.println("No se puede comprar");
                        conexion.rollback();
                    } else if ((precio >= 5) && (puntoswallet > puntos)) {
                        puntoswallet = puntoswallet - puntos;
                        ewallet.setSaldoPuntos(puntoswallet);
                        ewalletdao.Actualizar(ewallet);
                        compradao.Insertar(compra);
                        System.out.println("Compra realizada con  puntos.");
                    } else {
                        System.out.println("No dispone de puntos suficientes para este producto.");
                    }

                }

            }
            conexion.commit();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
            System.out.println("Algo ha fallado, Entramos al rollback");
            try {
                conexion.rollback();
            } catch (SQLException ex1) {
                ex1.printStackTrace(System.out);
            }
        }

    }

    public static void ConsultarMovimientos() {
        Scanner sc = new Scanner(System.in);
        int id_wallet;
        int id_compra;
        int id_devol;

        Connection conexion = null;
        try {
            conexion = Conexion.getConnection();

            if (conexion.getAutoCommit()) {
                conexion.setAutoCommit(false);
            }

            EwalletDAO ewalletdao = new EwalletDAO(conexion);
            CompraDAO compradao = new CompraDAO();
            DevolucionDAO devoluciondao = new DevolucionDAO();

            System.out.println("Introduzca su Id_wallet para consultar sus movimientos.");
            id_wallet = sc.nextInt();
            Ewallet ewallet = ewalletdao.BuscarWallet(id_wallet);

            //Comprobamos si se encuentra registrado
            if (ewallet.getId_wallet() == 0) {
                System.out.println("No se encunetra registrado.");
            } else {
                //Buscamos ese id encontrado en todas las compras y lo imprimos. 
                List<Compra> listacompras = compradao.Seleccionar();
                System.out.println("Compras:");
                for (Compra c : listacompras) {
                    if (id_wallet == c.getId_wallet()) {
                        System.out.println(c);
                    }
                }

                //Buscamos ese id encontrado en todas las devoluciones y las imprimimos.
                List<Devolucion> listadev = devoluciondao.Seleccionar();
                System.out.println("\nDevoluciones: ");
                for (Devolucion d : listadev) {
                    if (id_wallet == d.getId_wallet()) {
                        System.out.println(d);
                    }
                }
            }

            conexion.commit();

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
            System.out.println("Algo ha fallado, Entramos al rollback");
            try {
                conexion.rollback();
            } catch (SQLException ex1) {
                ex1.printStackTrace(System.out);
            }
        }
    }

    public static void ModificarProducto() {
        Scanner sc = new Scanner(System.in);
        String nombre;
        int precio;
        int puntos;
        int id_producto;
        Connection conexion = null;

        try {
            conexion = Conexion.getConnection();

            if (conexion.getAutoCommit()) {
                conexion.setAutoCommit(false);
            }
            ProductoDAO prodao = new ProductoDAO(conexion);

            System.out.println("Introduzca el Id del producto que desea modificar :");
            id_producto = sc.nextInt();
            Producto cambia = prodao.BuscarProducto(id_producto);

            //Comprobamos si se encuentra registrado el producto
            if (cambia.getId_producto() == 0) {
                System.out.println("El producto no se encuentra registrado.");
            } else {
                //introducimos los nuevos valores y actualizamos el producto.
                System.out.println("Encontrado " + cambia);
                System.out.println("Introduzca el nuevo precio del  producto:");
                precio = sc.nextInt();
                cambia.setPrecioProducto(precio);
                System.out.println("Introduzca los  nuevos puntos del producto:");
                puntos = sc.nextInt();
                cambia.setPuntosProducto(puntos);
                prodao.Actualizar(cambia);
            }

            conexion.commit();
            System.out.println("Se ha modificado el producto");

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
            System.out.println("Algo ha fallado, Entramos al rollback");
            try {
                conexion.rollback();
            } catch (SQLException ex1) {
                ex1.printStackTrace(System.out);
            }
        }
    }

}
