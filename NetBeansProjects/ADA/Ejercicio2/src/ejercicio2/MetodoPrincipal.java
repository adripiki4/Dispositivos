/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio2;

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
        Scanner sc = new Scanner(System.in);
        int lado1;
        int lado2;
        int lado3;
        
        System.out.println("Introduzca la longitud de los lados de su triangulo");
        lado1 = sc.nextInt();
        lado2 = sc.nextInt();
        lado3 = sc.nextInt();
        
        Triangulo tri = new Triangulo(lado1, lado2, lado3);
        tri.Comprueba_triangulo();
    }
    
}
