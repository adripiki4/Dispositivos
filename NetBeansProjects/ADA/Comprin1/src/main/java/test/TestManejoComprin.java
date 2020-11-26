/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import datos.Conexion;
import datos.EwalletDAO;
import domain.Ewallet;
import java.text.ParseException;
import java.sql.*;
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
                return;
            } else {
                System.out.println("Es mayor de edad");
            }

            //Formato de fecha
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date fecha = sdf.parse(fechaNacimiento);
            //Formato de fecha para SQL
            java.sql.Date fechabuena = new java.sql.Date(fecha.getTime());

            //Creamos la nueva e-Wallet
            nueva = new Ewallet(nombre, apellidos, dni, fechabuena, email);
            ewalletdao.Insertar(nueva);

            conexion.commit();
            System.out.println("Todo ha salido bien");

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
            System.out.println("Todo ha salido bien");

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
                System.out.println("Introduzca la cantidad que desea recargar: ");
                recarga = sc.nextInt();
                saldo = busca.getSaldoEuros();
                saldo = saldo + recarga;
                busca.setSaldoEuros(saldo);
                ewalletdao.Actualizar(busca);

                conexion.commit();
                System.out.println("Todo ha salido bien");

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

}
