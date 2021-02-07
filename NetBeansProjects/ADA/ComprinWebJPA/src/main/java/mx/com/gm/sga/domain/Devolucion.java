/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.gm.sga.domain;

import java.io.Serializable;
import java.util.Date;
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
@Table(name = "devolucion")
public class Devolucion implements Serializable {

    private static final long SerialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int iddevolucion;
    private Date fechadevolucion;
    private int idwallet;
    private int idproducto;

    public Devolucion() {
    }

    public Devolucion(int iddevolucion, Date fechadevolucion, int idwallet, int idproducto) {
        this.iddevolucion = iddevolucion;
        this.fechadevolucion = fechadevolucion;
        this.idwallet = idwallet;
        this.idproducto = idproducto;
    }

    public Devolucion(Date fechadevolucion, int idwallet, int idproducto) {
        this.fechadevolucion = fechadevolucion;
        this.idwallet = idwallet;
        this.idproducto = idproducto;
    }

    public int getIddevolucion() {
        return iddevolucion;
    }

    public void setIddevolucion(int iddevolucion) {
        this.iddevolucion = iddevolucion;
    }

    public Date getFechadevolucion() {
        return fechadevolucion;
    }

    public void setFechadevolucion(Date fechadevolucion) {
        this.fechadevolucion = fechadevolucion;
    }

    public int getIdwallet() {
        return idwallet;
    }

    public void setIdwallet(int idwallet) {
        this.idwallet = idwallet;
    }

    public int getIdproducto() {
        return idproducto;
    }

    public void setIdproducto(int idproducto) {
        this.idproducto = idproducto;
    }

    @Override
    public String toString() {
        return "Devolucion{" + "iddevolucion=" + iddevolucion + ", fechadevolucion=" + fechadevolucion + ", idwallet=" + idwallet + ", idproducto=" + idproducto + '}';
    }
    
    

  
    

}
