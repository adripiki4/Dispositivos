/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.gm.sga.domain;

import java.io.Serializable;
import java.util.ArrayList;
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
@Table(name = "monitores")
public class Monitores implements Serializable {
    private static final long SerialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idmonitores")
    private int idmonitores;
    private String nombre;
    private String apellidos;
    private int telefono;
    private String email;
    
    //Relacion hacia actividad
     @OneToMany(mappedBy = "monitores")
     private List<Actividad> actividades = new ArrayList<Actividad>();

    public Monitores() {
    }

    public Monitores(int idmonitores, String nombre, String apellidos, int telefono, String email) {
        this.idmonitores = idmonitores;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.telefono = telefono;
        this.email = email;
    }

    public Monitores(String nombre, String apellidos, int telefono, String email) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.telefono = telefono;
        this.email = email;
    }

    public Monitores(int idmonitores, String nombre, String apellidos) {
        this.idmonitores = idmonitores;
        this.nombre = nombre;
        this.apellidos = apellidos;
    }

    public int getIdmonitores() {
        return idmonitores;
    }

    public void setIdmonitores(int idmonitores) {
        this.idmonitores = idmonitores;
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

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Monitores{" + "idmonitores=" + idmonitores + ", nombre=" + nombre + ", apellidos=" + apellidos + ", telefono=" + telefono + ", email=" + email + '}';
    }
    
    
}
