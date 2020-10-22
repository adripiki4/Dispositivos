/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package herencia3;

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
        Password p = new Password();
        System.out.println(p);
        System.out.println(p.esFuerte());
        
        Password p2 = new Password(24);
        System.out.println(p2);
        System.out.println(p2.esFuerte());
    }
    
}
