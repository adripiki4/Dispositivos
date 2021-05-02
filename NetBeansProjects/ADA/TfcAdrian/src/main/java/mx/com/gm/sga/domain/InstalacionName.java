/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.gm.sga.domain;

/**
 *
 * @author adrip
 */
public class InstalacionName {
    private int idinstalacion;
    private String name;
    private double precio;
    private String deporte;

    public InstalacionName() {
    }

    public InstalacionName(int idinstalacion, String name, double precio, String deporte) {
        this.idinstalacion = idinstalacion;
        this.name = name;
        this.precio = precio;
        this.deporte = deporte;
    }

    public InstalacionName(int idinstalacion, String name, String deporte) {
        this.idinstalacion = idinstalacion;
        this.name = name;
        this.deporte = deporte;
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

    public String getDeporte() {
        return deporte;
    }

    public void setDeporte(String deporte) {
        this.deporte = deporte;
    }

    @Override
    public String toString() {
        return "InstalacionName{" + "idinstalacion=" + idinstalacion + ", name=" + name + ", precio=" + precio + ", deporte=" + deporte + '}';
    }
    
    
}
