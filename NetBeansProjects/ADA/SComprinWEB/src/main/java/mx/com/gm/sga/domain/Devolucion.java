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
    private int Id_devolucion;
    private Date FechaDevolucion;
    private int Id_wallet;
    private int Id_producto;

    public Devolucion() {
    }

    public Devolucion(int Id_devolucion, Date FechaDevolucion, int Id_wallet, int Id_producto) {
        this.Id_devolucion = Id_devolucion;
        this.FechaDevolucion = FechaDevolucion;
        this.Id_wallet = Id_wallet;
        this.Id_producto = Id_producto;
    }

    public Devolucion(Date FechaDevolucion, int Id_wallet, int Id_producto) {
        this.FechaDevolucion = FechaDevolucion;
        this.Id_wallet = Id_wallet;
        this.Id_producto = Id_producto;
    }

    public int getId_devolucion() {
        return Id_devolucion;
    }

    public void setId_devolucion(int Id_devolucion) {
        this.Id_devolucion = Id_devolucion;
    }

    public Date getFechaDevolucion() {
        return FechaDevolucion;
    }

    public void setFechaDevolucion(Date FechaDevolucion) {
        this.FechaDevolucion = FechaDevolucion;
    }

    public int getId_wallet() {
        return Id_wallet;
    }

    public void setId_wallet(int Id_wallet) {
        this.Id_wallet = Id_wallet;
    }

    public int getId_producto() {
        return Id_producto;
    }

    public void setId_producto(int Id_producto) {
        this.Id_producto = Id_producto;
    }

    @Override
    public String toString() {
        return "Devolucion{" + "Id_devolucion=" + Id_devolucion + ", FechaDevolucion=" + FechaDevolucion + ", Id_wallet=" + Id_wallet + ", Id_producto=" + Id_producto + '}';
    }
    
    

}
