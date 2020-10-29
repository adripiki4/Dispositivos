/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio2;

/**
 *
 * @author adriba
 */
public class Triangulo {
    static int lado1;
    static int lado2;
    static int lado3;
    
    public Triangulo(int lado1, int lado2, int lado3){
        this.lado1=lado1;
        this.lado2=lado2;
        this.lado3=lado3;
    }
    
    public static void Comprueba_triangulo(){
        int suma1 = lado1 + lado2;
        if (suma1 > lado3) {
            System.out.println("Es un triangulo");
        }else if (suma1 < lado3){
            System.out.println("No es un triangulo");
        }
    }
}
