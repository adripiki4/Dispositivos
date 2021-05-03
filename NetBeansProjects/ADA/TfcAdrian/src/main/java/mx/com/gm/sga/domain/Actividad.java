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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author adrip
 */
@Entity
@Table(name = "actividad")
public class Actividad implements Serializable {
    private static final long SerialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idactividad")
    private int idactividad;
    private String nombre;
    private String dia;
    private String hora;
    private int maxpersonas;
    private int inscritos;
    private double precio;
    
//    private int idinstalacion;
//    private int iddeporte;
//    private int idmonitores;
    
    //Relacion con deporte
    @JoinColumn(name = "iddeporte")
    @ManyToOne
    private Deportes deportes;
    
    //Relacion con instalacion
    @JoinColumn(name = "idinstalacion")
    @ManyToOne
    private Instalacion instalacion;
    
    //Relacion con monitores
    @JoinColumn(name = "idmonitores")
    @ManyToOne
    private Monitores monitores;

    public Actividad() {
    }

    public Actividad(int idactividad, String nombre, String dia, String hora, int maxpersonas, int inscritos, double precio, Deportes deportes, Instalacion instalacion, Monitores monitores) {
        this.idactividad = idactividad;
        this.nombre = nombre;
        this.dia = dia;
        this.hora = hora;
        this.maxpersonas = maxpersonas;
        this.inscritos = inscritos;
        this.precio = precio;
        this.deportes = deportes;
        this.instalacion = instalacion;
        this.monitores = monitores;
    }

    public Actividad(String nombre, String dia, String hora, int maxpersonas, int inscritos, double precio, Deportes deportes, Instalacion instalacion, Monitores monitores) {
        this.nombre = nombre;
        this.dia = dia;
        this.hora = hora;
        this.maxpersonas = maxpersonas;
        this.inscritos = inscritos;
        this.precio = precio;
        this.deportes = deportes;
        this.instalacion = instalacion;
        this.monitores = monitores;
    }

    public int getIdactividad() {
        return idactividad;
    }

    public void setIdactividad(int idactividad) {
        this.idactividad = idactividad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public int getMaxpersonas() {
        return maxpersonas;
    }

    public void setMaxpersonas(int maxpersonas) {
        this.maxpersonas = maxpersonas;
    }

    public int getInscritos() {
        return inscritos;
    }

    public void setInscritos(int inscritos) {
        this.inscritos = inscritos;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public Deportes getDeportes() {
        return deportes;
    }

    public void setDeportes(Deportes deportes) {
        this.deportes = deportes;
    }

    public Instalacion getInstalacion() {
        return instalacion;
    }

    public void setInstalacion(Instalacion instalacion) {
        this.instalacion = instalacion;
    }

    public Monitores getMonitores() {
        return monitores;
    }

    public void setMonitores(Monitores monitores) {
        this.monitores = monitores;
    }

    @Override
    public String toString() {
        return "Actividad{" + "idactividad=" + idactividad + ", nombre=" + nombre + ", dia=" + dia + ", hora=" + hora + ", maxpersonas=" + maxpersonas + ", inscritos=" + inscritos + ", precio=" + precio + ", deportes=" + deportes + ", instalacion=" + instalacion + ", monitores=" + monitores + '}';
    }

    
    
    
    
}
