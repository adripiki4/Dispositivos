package ejercicio4;

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
        System.out.println("Introduzca un numero");
        numero = sc.nextInt();
        
        for (int i = 1; i <= numero; i++) {
            System.out.print(i+"\t"+i*2+"\t"+i*3);
            System.out.println();
            
        }
    }
    
}