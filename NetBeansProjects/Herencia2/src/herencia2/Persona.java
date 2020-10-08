/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package herencia2;

/**
 *
 * @author adriba
 */
public class Persona {
    private String nombre;
    private int edad;
    private String dni;
    private String sexo;
    private double peso;
    private double altura;
    
    public Persona(){
        this.nombre = "";
        this.edad = 0;
        this.dni = "";
        this.sexo = "hombre";
        this.peso = 0;
        this.altura = 0;
    }
    
    public Persona(String nombre, int edad, String sexo){
        this.nombre = nombre;
        this.edad = edad;
        this.dni = "";
        this.sexo = sexo;
        this.peso = 0;
        this.altura = 0;
    }
    
    public Persona(String nombre, int edad, String dni, String sexo, double peso, double altura){
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
        this.sexo = sexo;
        this.peso = peso;
        this.altura = altura;
    }
    
    public double calcularIMC(){
        double resultado = 0;
        double respuesta = 0;
        resultado = (peso / (altura*altura));
        if(resultado<20){
            respuesta = -1;
        }else if(resultado>=20 && resultado<=25){
            respuesta = 0;
        }else if (resultado>25){
            respuesta = 1;
        }
        return resultado;
    }
    
    public boolean esMayorDeEdad(){
        boolean res = false;
        if(this.edad>=18){
            res=true;
        }
        return res;
    }
    
    public String toString(){
        String res = "";
        
        return res;
    }
    
}
