/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package herencia3;

import java.util.Random;

/**
 *
 * @author adriba
 */
public class Password {

    private int longitud;
    private String contrasena;

    public Password() {
        this.longitud = 8;
        this.contrasena = genetaPassword();

    }

    public Password(int longitud) {
        this.longitud = longitud;
        this.contrasena = genetaPassword();
    }

    public String genetaPassword() {
        String buena = "";
        int posicion;
        int azar;
        String letra = "";
        String[] creando = new String[longitud];
        String[] escoge = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z",
            "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
        Random random = new Random();

        for (int i = 0; i < longitud; i++) {
            azar = random.nextInt(escoge.length);
            letra = escoge[azar];
            buena = buena + letra;

        }

        return buena;
    }

    public boolean esFuerte() {
        int mayus=0;
        int min=0;
        int num=0;
        boolean res = false;
        
        for(int i = 0; i<longitud; i++){
           char let = contrasena.charAt(i);
        if (Character.isUpperCase(let)==true) {
            mayus++;
            //System.out.println("Mayuscula");
        } 
        else if (Character.isLowerCase(let)==true){
            //System.out.println("Minuscula");
            min++;
        } 
        else{
            //System.out.println("Numero");
            num++;
        }
        }
        
        if(mayus>2 && min>1 && num>5){
            res = true;
        }
        System.out.println("Mayusculas: "+mayus+". Minisculas: "+min+". Numeros: "+num);
        
        return res;
    }

    public String toString() {
        return contrasena;
    }

}
