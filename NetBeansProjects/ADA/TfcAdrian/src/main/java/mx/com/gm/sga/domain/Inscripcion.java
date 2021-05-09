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
@Table(name = "inscripcion")
public class Inscripcion implements Serializable {
    private static final long SerialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idinscripcion")
    private int idinscripcion;
    
    //Relacion con cliente
    @JoinColumn(name = "idcliente")
    @ManyToOne
    private Cliente cliente;
    
    //Relacion con actividad
    @JoinColumn(name = "idactividad")
    @ManyToOne
    private Actividad actividad;

    public Inscripcion() {
    }

    public Inscripcion(int idinscripcion, Cliente cliente, Actividad actividad) {
        this.idinscripcion = idinscripcion;
        this.cliente = cliente;
        this.actividad = actividad;
    }

    public Inscripcion(Cliente cliente, Actividad actividad) {
        this.cliente = cliente;
        this.actividad = actividad;
    }

    public int getIdinscripcion() {
        return idinscripcion;
    }

    public void setIdinscripcion(int idinscripcion) {
        this.idinscripcion = idinscripcion;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Actividad getActividad() {
        return actividad;
    }

    public void setActividad(Actividad actividad) {
        this.actividad = actividad;
    }

    @Override
    public String toString() {
        return "Inscripcion{" + "idinscripcion=" + idinscripcion + ", cliente=" + cliente + ", actividad=" + actividad + '}';
    }
    
    
    
}
