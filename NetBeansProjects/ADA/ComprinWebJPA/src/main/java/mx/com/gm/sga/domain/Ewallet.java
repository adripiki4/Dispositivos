/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.gm.sga.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author adrip
 */
@Entity
@Table(name = "ewallet")
public class Ewallet implements Serializable {

    private static final long SerialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idwallet")
    private int idwallet;
    private String nombre;
    private String apellidos;
    private String dni;
    private java.sql.Date fechanacimiento;
    private String email;
    private int saldopuntos;
    private int saldoeuros;
    
    //Relacion onetomany hacia compra
    @OneToMany(mappedBy = "ewallet")
    private List<Compra> compras = new ArrayList<Compra>();

    public Ewallet() {
    }

    public Ewallet(int idwallet, String nombre, String apellidos, String dni, java.sql.Date fechanacimiento, String email, int saldopuntos, int saldoeuros) {
        this.idwallet = idwallet;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.dni = dni;
        this.fechanacimiento = fechanacimiento;
        this.email = email;
        this.saldopuntos = saldopuntos;
        this.saldoeuros = saldoeuros;
    }

    public Ewallet(String nombre, String apellidos, String dni, java.sql.Date fechanacimiento, String email, int saldopuntos, int saldoeuros) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.dni = dni;
        this.fechanacimiento = fechanacimiento;
        this.email = email;
        this.saldopuntos = saldopuntos;
        this.saldoeuros = saldoeuros;
    }

    public Ewallet(String nombre, String apellidos, String dni, java.sql.Date fechanacimiento, String email) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.dni = dni;
        this.fechanacimiento = fechanacimiento;
        this.email = email;
    }

    public int getIdwallet() {
        return idwallet;
    }

    public void setIdwallet(int idwallet) {
        this.idwallet = idwallet;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public Date getFechanacimiento() {
        return fechanacimiento;
    }

    public void setFechanacimiento(java.sql.Date fechanacimiento) {
        this.fechanacimiento = fechanacimiento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getSaldopuntos() {
        return saldopuntos;
    }

    public void setSaldopuntos(int saldopuntos) {
        this.saldopuntos = saldopuntos;
    }

    public int getSaldoeuros() {
        return saldoeuros;
    }

    public void setSaldoeuros(int saldoeuros) {
        this.saldoeuros = saldoeuros;
    }

    @Override
    public String toString() {
    return ""+idwallet;
    }

    
   

}
