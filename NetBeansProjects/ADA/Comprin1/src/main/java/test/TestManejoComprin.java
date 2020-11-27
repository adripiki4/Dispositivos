/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import datos.CompraDAO;
import datos.Conexion;
import datos.EwalletDAO;
import datos.ProductoDAO;
import domain.Compra;
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
            }

        } while (exit == false);

    }

    public static void Menu() {
        System.out.println("\n"
                + "-----------MENU-----------\n"
                + "1.-Fidelizar cliente\n"
                + "2.-Recargar saldo.\n"
                + "3.-Dar de alta nuevos productos.\n"
                + "4.-Comprar productos.\n"
                + "5.-Devolucion de productos.\n"
                + "6.-Canjear puntos de E-Wallet.\n"
                + "7.-Ver catalogo de productos.\n"
                + "8.-Consultar movimientos de E-Wallet.\n"
                + "9.-Listar los clientes.\n"
                + "10.-Salir.");
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
            System.out.println("Introduce la fecha de nacimiento del cliente: ");
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
                System.out.println("Se ha insertado correctamente");
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
                System.out.println(busca);
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

//                if (diaint >= 5) {
//                    System.out.println("Solo se puede recargar del 1 al 5 de cada mes, hoy estamos a " + dia);
//                    conexion.rollback();
//                }
                conexion.commit();
                System.out.println("Se ha realizado la recarga");

            }

//            List<Ewallet> listawallet = ewalletdao.Seleccionar();
//            for (Ewallet w : listawallet) {
//                if (w.getId_wallet() == id_wallet) {
//                    System.out.println("Encontrado");
//                    busca = w;
//                    System.out.println(busca);
//                    encontrado = true;
//                }
//            }
//
//            if (encontrado == true) {
//                System.out.println("Introduzca la cantidad que desea recargar: ");
//                recarga = sc.nextInt();
//                saldo = busca.getSaldoEuros();
//                saldo = saldo + recarga;
//                busca.setSaldoEuros(saldo);
//                ewalletdao.Actualizar(busca);
//            }
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
        int saldo=0;

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
            } else {
                precio = producto.getPrecioProducto();
                puntos = producto.getPuntosProducto();
                System.out.println("El producto tiene un precio de " + precio + " y le sumara " + puntos + " puntos.");
                //Una vez localizado el producto identificamos al cliente.
                System.out.println("Introduzca su Id_wallet para identificarse y realizar el pago");
                id_wallet = sc.nextInt();
                ewallet = ewalletdao.BuscarWallet(id_wallet);
                System.out.println("buscando");
                System.out.println(ewallet);
                //si no se encuentra el cliente no realiza la compra.
                if (ewallet.getId_wallet() == 0) {
                    System.out.println("No se ha encontrado ese Id_wallet");
                    conexion.rollback();
                    
                } else  {
                    java.util.Date fecha = new java.util.Date();
                    long lo = fecha.getTime();
                    Date fechapasa = new Date(lo);
                    
                    Compra compra = new Compra(fechapasa, id_wallet, id_producto);
                    System.out.println("buscando1");
                    compradao.Insertar(compra);
                    System.out.println("buscando2");
                    saldo = ewallet.getSaldoEuros();
                    System.out.print(saldo);

                    if (precio > saldo) {
                        System.out.println("No se puede comprar");
                        conexion.rollback();
                    } else if (precio <= saldo) {
                        saldo = saldo - precio;
                        ewallet.setSaldoEuros(saldo);
                        ewalletdao.Actualizar(ewallet);
                         System.out.println("buscando3");
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

}
