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
public class Persona {
    private int Id_persona;
    private String Nombre;
    private String Apellidos;
    private int Edad;
    private String Email;
    
    public Persona(){
        
    }
    
    public Persona(int Id_persona){
        this.Id_persona= Id_persona;
    }
    
    public Persona(String Nombre, String Apellidos, int Edad){
        this.Nombre=Nombre;
        this.Apellidos=Apellidos;
        this.Edad=Edad;
    }
    
    public Persona(int Id_persona, String Nombre, String Apellidos, int Edad){
        this.Id_persona= Id_persona;
        this.Nombre = Nombre;
        this.Apellidos = Apellidos;
        this.Edad=Edad;
    }
    
     public Persona(int Id_persona, String Nombre, String Apellidos, int Edad, String Email){
        this.Id_persona= Id_persona;
        this.Nombre = Nombre;
        this.Apellidos = Apellidos;
        this.Edad=Edad;
        this.Email = Email;
    }

    public int getId_persona() {
        return Id_persona;
    }

    public void setId_persona(int Id_persona) {
        this.Id_persona = Id_persona;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getApellidos() {
        return Apellidos;
    }

    public void setApellidos(String Apellidos) {
        this.Apellidos = Apellidos;
    }

    public int getEdad() {
        return Edad;
    }

    public void setEdad(int Edad) {
        this.Edad = Edad;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }
    
    
    public String toString(){
        String res = "";
        res = Id_persona+", "+Nombre+", "+Apellidos+". "+Edad;
        return res;
    }
}
