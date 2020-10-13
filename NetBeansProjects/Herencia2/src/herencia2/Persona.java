/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package herencia2;

import java.util.Random;

/**
 *
 * @author adriba
 */
public class Persona {
    private String nombre;
    private int edad;
    private String dni;
    private char sexo;
    private double peso;
    private double altura;
    private Random random;
    
    public Persona(){
        this.nombre = "";
        this.edad = 0;
        this.dni = generaDni();
        this.sexo = 'H';
        this.peso = 0;
        this.altura = 0;
    }
    
    public Persona(String nombre, int edad, char sexo){
        this.nombre = nombre;
        this.edad = edad;
        this.dni = generaDni();
        this.sexo = compruebaSexo(sexo);
        this.peso = 0;
        this.altura = 0;
        
    }
    
    public Persona(String nombre, int edad, char sexo, double peso, double altura){
        this.nombre = nombre;
        this.edad = edad;
        this.dni = generaDni();
        this.sexo = compruebaSexo(sexo);
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
        return respuesta;
    }
    
    public boolean esMayorDeEdad(){
        boolean res = false;
        if(this.edad>=18){
            res=true;
        }
        return res;
    }
    
    public char compruebaSexo(char sexo){
        if(sexo!='H' && sexo!='M'){
            sexo = 'H';
        }else{
            sexo = sexo;
        }
            return sexo;
    }
    
    public String toString(){
        String res = "";
        res = "Nombre: "+nombre+", Edad: "+edad+", DNI: "+dni+", Sexo: "+sexo+", Peso: "+peso+", Altura: "+altura;
        return res;
    }
    public String generaDni(){
        String res ="";
        String letra;
        String letras[]={"T","R","W","A","G","M","Y","F","P","D","X","B","N","J","Z","S","Q","V","H","L","C","K","E"};
        int numero;
        int resto;
        random = new Random();
        
        numero = random.nextInt(99999999)+1;
        resto = numero % 23;
        letra = letras[resto];
        res = Integer.toString(numero)+" "+letra;
        
        return res;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }
    
}
