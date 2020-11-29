/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

/**
 *
 * @author adrip
 */
public class Producto {

    private int Id_producto;
    private String NombreProducto;
    private int PrecioProducto;
    private int PuntosProducto;

    public Producto() {

    }

    public Producto(int Id_producto, String NombreProducto, int PrecioProducto, int PuntosProducto) {
        this.Id_producto = Id_producto;
        this.NombreProducto = NombreProducto;
        this.PrecioProducto = PrecioProducto;
        this.PuntosProducto = PuntosProducto;
    }

    public Producto(String NombreProducto, int PrecioProducto, int PuntosProducto) {
        this.NombreProducto = NombreProducto;
        this.PrecioProducto = PrecioProducto;
        this.PuntosProducto = PuntosProducto;
    }

    public int getId_producto() {
        return Id_producto;
    }

    public void setId_producto(int Id_producto) {
        this.Id_producto = Id_producto;
    }

    public String getNombreProducto() {
        return NombreProducto;
    }

    public void setNombreProducto(String NombreProducto) {
        this.NombreProducto = NombreProducto;
    }

    public int getPrecioProducto() {
        return PrecioProducto;
    }

    public void setPrecioProducto(int PrecioProducto) {
        this.PrecioProducto = PrecioProducto;
    }

    public int getPuntosProducto() {
        return PuntosProducto;
    }

    public void setPuntosProducto(int PuntosProducto) {
        this.PuntosProducto = PuntosProducto;
    }

    @Override
    public String toString() {
        return "Producto: " + "||Id_producto = " + Id_producto + "|| NombreProducto = " + NombreProducto + "|| PrecioProducto = " + PrecioProducto + "€ || PuntosProducto = " + PuntosProducto + "pts ||";
    } 

}
