/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import datos.CochesDAO;
import datos.PropietariosDAO;
import domain.Coches;
import domain.propietarios;
import java.sql.*;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author adrip
 */
public class Main {

    public static void main(String[] args) throws SQLException {
//        CochesDAO cdao = new CochesDAO();
//        PropietariosDAO pdao = new PropietariosDAO();
//        
//        Coches nuevo = new Coches("2323JKL", "Ford", 5000, "25256111F");
//        cdao.actualizar(nuevo);
//        
//        List<Coches>listcoches = cdao.seleccionar();
//        
//        for(Coches c : listcoches){
//            System.out.println(c);
//        }

//        propietarios pnuevo = new propietarios("25256111F", "Pepe", 58);
//        pdao.actualizarpropietarios(pnuevo);
//        List<propietarios> listpro = pdao.seleccionar();
//        for (propietarios pr : listpro){
//            System.out.println(pr);
//        }
        String nombrepro;
        String dnipro;
        int edad;
        String marcaco;
        String matriculaco;
        int precioco;
        String dnico;
        Scanner sc = new Scanner(System.in);
        boolean exit = false;
        int opcion;

        do {
            menu();
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    listarPropietarios();
                    break;

                case 2:
                    insertarCoche();
                    break;
                    
                case 3:
                    eliminarPropietarios();
                    break;
                    
                case 4:
                    insertarNuevo();
                    break;
                    
                case 5:
                    exit=true;

            }
        } while (exit == false);

    }

    public static void menu() {
        System.out.println("\n"
                + "-----------MENU-----------\n"
                + "1.-Listar propietarios.\n"
                + "2.-Insertar nuevo coche.\n"
                + "3.-Eliminar propietario y sus coches.\n"
                + "4.-Insertar propietario nuevo.\n"
                + "5.-Salir.");
    }

    public static void listarPropietarios() throws SQLException {
        Scanner sc = new Scanner(System.in);
        String dnipro;
        String comprueba;
        CochesDAO cdao = new CochesDAO();
        PropietariosDAO pdao = new PropietariosDAO();
        List<propietarios> listpro = pdao.seleccionar();
        List<Coches> listcoches = cdao.seleccionar();

        System.out.println("Introduzca el dni del propietario que desea listar:");
        dnipro = sc.nextLine();

        for (propietarios pro : listpro) {
            comprueba = pro.getDni();
            if (comprueba.equalsIgnoreCase(dnipro) == true) {
                System.out.println(pro);
                break;
            }
        }

        for (Coches c : listcoches) {
            comprueba = c.getDni();
            if (comprueba.equalsIgnoreCase(dnipro) == true) {
                System.out.println(c);
            }
        }
    }

    public static void insertarCoche() throws SQLException {
        Scanner sc = new Scanner(System.in);
        String dnipro;
        String comprueba;
        String marca;
        String matricula;
        int precio;
        boolean encontrado = false;
        CochesDAO cdao = new CochesDAO();
        PropietariosDAO pdao = new PropietariosDAO();
        List<propietarios> listpro = pdao.seleccionar();
        List<Coches> listcoches = cdao.seleccionar();

        System.out.println("Introduzca el dni del propietario que desea insertar el coche:");
        dnipro = sc.nextLine();

        for (propietarios pro : listpro) {
            comprueba = pro.getDni();
            if (comprueba.equalsIgnoreCase(dnipro) == true) {
                System.out.println("Se ha encontrado un propietario");
                System.out.println(pro);
                encontrado = true;
                break;
            }
        }
        if (encontrado == false) {
            System.out.println("No se ha encontrado ningun propietario");
        } else {
            System.out.println("Introduzac la marca del nuevo coche");
            marca = sc.nextLine();
            System.out.println("Introduzca la matricula del nuevo coche");
            matricula = sc.nextLine();
            System.out.println("Introduzca el precio del nuevo coche");
            precio = sc.nextInt();

            Coches nuevo = new Coches(matricula, marca, precio, dnipro);
            cdao.insertar(nuevo);
        }
    }

    public static void eliminarPropietarios() throws SQLException {
        Scanner sc = new Scanner(System.in);
        String dnipro;
        String comprueba;
        boolean encontrado = false;
        propietarios proborra = null;
        Coches borracoche = null;
        CochesDAO cdao = new CochesDAO();
        PropietariosDAO pdao = new PropietariosDAO();
        List<propietarios> listpro = pdao.seleccionar();
        List<Coches> listcoches = cdao.seleccionar();

        System.out.println("Introduzca el dni del propietario que desea eliminar:");
        dnipro = sc.nextLine();

        for (propietarios pro : listpro) {
            comprueba = pro.getDni();
            if (comprueba.equalsIgnoreCase(dnipro) == true) {
                System.out.println("Se borrara el siguiente propietario junto con sus coches de la base de datos.");
                System.out.println(pro);
                proborra = pro;
                encontrado = true;
                break;
            }
        }
        if (encontrado == false) {
            System.out.println("No se ha encontrado ningun propietario.");
        } else {
            for (Coches c : listcoches) {
                comprueba = c.getDni();
                if (comprueba.equalsIgnoreCase(dnipro) == true) {
                    cdao.eliminar(c);
                }
            }
            pdao.eliminar(proborra);
        }

    }
    
    public static void insertarNuevo() throws SQLException{
        Scanner sc = new Scanner(System.in);
        String dnipro;
        String nombrepro;
        int edad;
        String comprueba;
        boolean existe = false;
        PropietariosDAO pdao = new PropietariosDAO();
        List<propietarios> listpro = pdao.seleccionar();
        
        System.out.println("Introduzca el dni del nuevo propietario:");
        dnipro = sc.nextLine();
        
        for (propietarios pro : listpro) {
            comprueba = pro.getDni();
            if (comprueba.equalsIgnoreCase(dnipro) == true) {
                existe=true;
                break;
            }
        }
        
        if(existe==true){
           System.out.println("El dni introducido pertenece a otro usuario");
        } else{
            System.out.println("Introduzca el nombre del neuvo propietario:");
            nombrepro = sc.nextLine();
            System.out.println("Introduzca la edad del nuevo propietario:");
            edad = sc.nextInt();
            
            propietarios nuevo = new propietarios(dnipro, nombrepro, edad);
            pdao.insertar(nuevo);
        }
        
    }
}
