/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package herencia1;

import java.time.Clock;

/**
 *
 * @author adriba
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Cuenta c = new Cuenta("jose", 100);
        Cuenta c2 = new Cuenta("Enrique");
        System.out.println(c);
        System.out.println(c2);
        c2.set_cantidad(20.5);
        System.out.println(c2);
        c.ingresar_cantidad(20);
        
        System.out.println(c);
        c.retirar_dinero(123);
        System.out.println(c);
    }
    
}
