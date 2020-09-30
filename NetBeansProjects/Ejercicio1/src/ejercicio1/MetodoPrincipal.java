/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio1;

import java.util.Scanner;

/**
 *
 * @author adriba
 */
public class MetodoPrincipal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        String nombre;
        
        System.out.println("Introduzca el nombre del conductor");
        nombre = sc.nextLine();
        Conductor c = new Conductor(nombre);
        c.comprueba_tipo();
        
        
    }
    
}
