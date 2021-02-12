/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.gm.sga.domain;

import java.io.Serializable;
import java.util.Date;
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
@Table(name="compra")
public class Compra implements Serializable {
     private static final long SerialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idcompra")
    private int idcompra;
    private java.sql.Date fechacompra;
   // private int idwallet;
    private int idproducto;
    
    @JoinColumn(name = "idwallet")
    @ManyToOne
    private Ewallet ewallet;

    public Compra() {
    }

    public Compra(int idcompra, java.sql.Date fechacompra, Ewallet ewallet, int idproducto) {
        this.idcompra = idcompra;
        this.fechacompra = fechacompra;
        this.ewallet = ewallet;
        this.idproducto = idproducto;
    }

    public Compra(java.sql.Date fechacompra, Ewallet ewallet, int idproducto) {
        this.fechacompra = fechacompra;
        this.ewallet = ewallet;
        this.idproducto = idproducto;
    }

    public int getIdcompra() {
        return idcompra;
    }

    public void setIdcompra(int idcompra) {
        this.idcompra = idcompra;
    }

    public Date getFechacompra() {
        return fechacompra;
    }

    public void setFechacompra(java.sql.Date fechacompra) {
        this.fechacompra = fechacompra;
    }

    public Ewallet getEwallet() {
        return ewallet;
    }

    public void setEwallet(Ewallet ewallet) {
        this.ewallet = ewallet;
    }

    public int getIdproducto() {
        return idproducto;
    }

    public void setIdproducto(int idproducto) {
        this.idproducto = idproducto;
    }

//    @Override
//    public String toString() {
//        return "Compra{" + "idcompra=" + idcompra + ", fechacompra=" + fechacompra + ", idwallet=" + idwallet + ", idproducto=" + idproducto + '}';
//    }


    
    
}
