/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio5;

import java.util.Random;

/**
 *
 * @author adriba
 */
public class Ejercicio5Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int vector[] = new int[15];
        int matriz[][] = new int [5][3];
        int aleatorio;
        boolean rellena= false;
        boolean valor = true;
        
        Random random = new Random();
        
        
        
        for (int i = 0; i <15; i++) {
            rellena=false;
            while(rellena==false){
            aleatorio = random.nextInt(90)+1;
            valor = Comprueba_numero(vector, aleatorio);
            if(valor==true){
                vector[i]=aleatorio;
                rellena = true;
            }else if (valor==false){
                rellena=false;
            }
            }   
            
        }
        
        for (int x: vector) {
            System.out.println(x);
        }
        
        for (int i = 0; i <15 ; i++) {
            for (int j = 0; j < 15; j++) {
                
                
            }
        }
        
         
    }
    
    public static boolean Comprueba_numero(int vector[],int aleatorio){
       int comprueba;
       boolean valor = true;
       
       for(int i = 0; i<15;i++){
           comprueba = vector[i];
           if(comprueba == aleatorio){
               valor = false;
               break;
           }
       }
        return valor;
        
    }
    
}
