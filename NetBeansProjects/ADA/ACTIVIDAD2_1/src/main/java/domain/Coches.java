/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

/**
 *
 * @author adriba
 */
public class Coches {
    private String matricula;
    private String marca;
    private int precio;
    private String dni;

    public Coches(String matricula) {
        this.matricula = matricula;
    }

    public Coches(String matricula, String marca, int precio, String dni) {
        this.matricula = matricula;
        this.marca = marca;
        this.precio = precio;
        this.dni = dni;
    }

    //Constructor para insertar nuevo coche con su usuario
    public Coches(String matricula, String marca, int precio) {
        this.matricula = matricula;
        this.marca = marca;
        this.precio = precio;
    }
    

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    @Override
    public String toString() {
        return "Coches{" + "matricula=" + matricula + ", marca=" + marca + ", precio=" + precio + ", dni=" + dni + '}';
    }
    
    
    
    
    
    
}
