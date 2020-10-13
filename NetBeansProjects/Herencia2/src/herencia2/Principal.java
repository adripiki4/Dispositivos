/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package herencia2;

import java.util.Scanner;

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
        String nombre;
        int edad;
        double peso;
        double altura;
        String sexo;
        char sexoPasa = 0;
        Scanner sc = new Scanner(System.in);
        
        
        System.out.println("Introduzca el nombre:");
        nombre = sc.next();
        System.out.println("Introduzca la edad: ");
        edad = sc.nextInt();
        System.out.println("Introduzca el sexo, (H/M): ");
        sexo = sc.next();
        System.out.println("Introduzca el peso en kg: ");
        peso = sc.nextDouble();
        System.out.println("Introduzca la altura en metros: ");
        altura = sc.nextDouble();
        
        if(sexo.equalsIgnoreCase("H")==true){
            sexoPasa = 'H';
        }
        else if(sexo.equalsIgnoreCase("M")==true){
            sexoPasa = 'M';
        }
        else{
            System.out.println("El sexo introducido no es correcto.");
        }
        
        Persona p1 = new Persona(nombre, edad, sexoPasa, peso, altura);
        Persona p2 = new Persona(nombre, edad, sexoPasa);
        Persona p3 = new Persona();
        
        p3.setNombre("Roberto");
        p3.setEdad(16);
        p3.setSexo('H');
        p3.setPeso(86);
        p3.setAltura(1.75);
        
        System.out.println(p1.calcularIMC());
        System.out.println(p2.calcularIMC());
        System.out.println(p3.calcularIMC());
        
        System.out.println(p1.esMayorDeEdad());
        System.out.println(p2.esMayorDeEdad());
        System.out.println(p3.esMayorDeEdad());
        
        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p3);
        
        
        
        
        
        
        
        
    }
    
}
