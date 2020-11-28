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
public class Compra {

    private int Id_compra;
    private Date FechaCompra;
    private int Id_wallet;
    private int Id_producto;

    public Compra() {

    }

    public Compra(int Id_compra, Date FechaCompra, int Id_wallet, int Id_producto) {
        this.Id_compra = Id_compra;
        this.FechaCompra = FechaCompra;
        this.Id_wallet = Id_wallet;
        this.Id_producto = Id_producto;
    }

    public Compra(Date FechaCompra, int Id_wallet, int Id_producto) {
        this.FechaCompra = FechaCompra;
        this.Id_wallet = Id_wallet;
        this.Id_producto = Id_producto;
    }

    public Compra(int Id_compra) {
        this.Id_compra = Id_compra;
    }

    public int getId_compra() {
        return Id_compra;
    }

    public void setId_compra(int Id_compra) {
        this.Id_compra = Id_compra;
    }

    public Date getFechaCompra() {
        return FechaCompra;
    }

    public void setFechaCompra(Date FechaCompra) {
        this.FechaCompra = FechaCompra;
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
        return "Compra{" + "Id_compra=" + Id_compra + ", FechaCompra=" + FechaCompra + ", Id_wallet=" + Id_wallet + ", Id_producto=" + Id_producto + '}';
    }
    
    
}
