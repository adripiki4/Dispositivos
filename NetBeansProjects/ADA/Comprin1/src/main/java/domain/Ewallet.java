/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.sql.Date;

/**
 *
 * @author adrip
 */
public class Ewallet {

    private int Id_wallet;
    private String Nombre;
    private String Apellidos;
    private String Dni;
    private Date FechaNacimiento;
    private String Email;
    private int SaldoPuntos;
    private int SaldoEuros;
    
    public Ewallet(){
        
    }

    public Ewallet(int Id_wallet, String Nombre, String Apellidos, String Dni, Date FechaNacimiento, String Email, int SaldoPuntos, int SaldoEuros) {
        this.Id_wallet = Id_wallet;
        this.Nombre = Nombre;
        this.Apellidos = Apellidos;
        this.Dni = Dni;
        this.FechaNacimiento = FechaNacimiento;
        this.Email = Email;
        this.SaldoPuntos = SaldoPuntos;
        this.SaldoEuros = SaldoEuros;
    }

    public Ewallet(String Nombre, String Apellidos, String Dni, Date FechaNacimiento, String Email, int SaldoPuntos, int SaldoEuros) {
        this.Nombre = Nombre;
        this.Apellidos = Apellidos;
        this.Dni = Dni;
        this.FechaNacimiento = FechaNacimiento;
        this.Email = Email;
        this.SaldoPuntos = SaldoPuntos;
        this.SaldoEuros = SaldoEuros;
    }

    public Ewallet(int Id_wallet, String Nombre, String Apellidos, String Dni, Date FechaNacimiento, String Email) {
        this.Id_wallet = Id_wallet;
        this.Nombre = Nombre;
        this.Apellidos = Apellidos;
        this.Dni = Dni;
        this.FechaNacimiento = FechaNacimiento;
        this.Email = Email;
    }

    public Ewallet(String Nombre, String Apellidos, String Dni, Date FechaNacimiento, String Email) {
        this.Nombre = Nombre;
        this.Apellidos = Apellidos;
        this.Dni = Dni;
        this.FechaNacimiento = FechaNacimiento;
        this.Email = Email;
    }
    

    public int getId_wallet() {
        return Id_wallet;
    }

    public void setId_wallet(int Id_wallet) {
        this.Id_wallet = Id_wallet;
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

    public String getDni() {
        return Dni;
    }

    public void setDni(String Dni) {
        this.Dni = Dni;
    }

    public Date getFechaNacimiento() {
        return FechaNacimiento;
    }

    public void setFechaNacimiento(Date FechaNacimiento) {
        this.FechaNacimiento = FechaNacimiento;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public int getSaldoPuntos() {
        return SaldoPuntos;
    }

    public void setSaldoPuntos(int SaldoPuntos) {
        this.SaldoPuntos = SaldoPuntos;
    }

    public int getSaldoEuros() {
        return SaldoEuros;
    }

    public void setSaldoEuros(int SaldoEuros) {
        this.SaldoEuros = SaldoEuros;
    }

    @Override
    public String toString() {
        return "Ewallet: " + "|| Id_wallet = " + Id_wallet + "|| Nombre = " + Nombre + "|| Apellidos = " + Apellidos + "|| Dni = " + Dni + "|| FechaNacimiento = " + FechaNacimiento + " || Email = " + Email + "|| " + SaldoPuntos + "pts || " + SaldoEuros + "€ ||";
    }
    
    
}
