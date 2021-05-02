/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.gm.sga.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author adrip
 */
@Entity
@Table(name="instalacion")
public class Instalacion implements Serializable {
     private static final long SerialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idinstalacion")
    private int idinstalacion;
    private String name;
    private double precio;
    private int deportes_id;

    public Instalacion() {
    }

    public Instalacion(int idinstalacion, String name, double precio, int deportes_id) {
        this.idinstalacion = idinstalacion;
        this.name = name;
        this.precio = precio;
        this.deportes_id = deportes_id;
    }

    public Instalacion(String name, double precio, int deportes_id) {
        this.name = name;
        this.precio = precio;
        this.deportes_id = deportes_id;
    }

    public Instalacion(String name, int deportes_id) {
        this.name = name;
        this.deportes_id = deportes_id;
    }

    public int getIdinstalacion() {
        return idinstalacion;
    }

    public void setIdinstalacion(int idinstalacion) {
        this.idinstalacion = idinstalacion;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getDeportes_id() {
        return deportes_id;
    }

    public void setDeportes_id(int deportes_id) {
        this.deportes_id = deportes_id;
    }

    @Override
    public String toString() {
        return "Instalacion{" + "idinstalacion=" + idinstalacion + ", name=" + name + ", precio=" + precio + ", deportes_id=" + deportes_id + '}';
    }
    
    
    
}
