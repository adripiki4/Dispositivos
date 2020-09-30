/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio3;

import java.time.Clock;
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
        int numero;
        
        System.out.println("Introduzca un numero para calcular sus divisores");
        numero = sc.nextInt();
        
        for (int i =1; i <= numero; i++) {
            if (numero % i == 0) {
                System.out.println(i);
                
            }
            
        }
    }
    
}
