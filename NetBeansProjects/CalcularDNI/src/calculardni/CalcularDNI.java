/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculardni;

import java.util.Random;

/**
 *
 * @author adrian
 */
public class CalcularDNI {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Random random = new Random();
         String res ="";
        String letra;
        String letras[]={"T","R","W","A","G","M","Y","F","P","D","X","B","N","J","Z","S","Q","V","H","L","C","K","E"};
        int numero;
        int resto;
        
        numero = random.nextInt(99999999)+1;
        resto = numero % 23;
        letra = letras[resto];
        res = Integer.toString(numero)+" "+letra;
        System.out.println(resto);
        System.out.println(res);
    }
    
}
