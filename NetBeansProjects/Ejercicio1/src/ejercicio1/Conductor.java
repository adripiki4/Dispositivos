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
public class Conductor {
    private String nombre;
    private int tipo;
    static Scanner sc;
    
    public Conductor(String nombre){
        this.nombre=nombre;
        sc = new Scanner(System.in);
        
    }
    
    public static void comprueba_tipo(){
        int vehiculo;
        System.out.println("Indica el tipo de conductor:");
        System.out.println("(Tipo 1:vehiculos de carga y vehiculos especiales)(Tipo 2: turismos y bicicletas");
        vehiculo = sc.nextInt();
        if (vehiculo==1) {
            System.out.println("La tasa permitida para es de 0'3");
        }
        else if (vehiculo==2) {
            System.out.println("La tasa permitida es de 0'5");
        }
    }
}
