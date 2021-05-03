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
public class ActividadName {
    private int idactividad;
    private String nombre;
    private String dia;
    private String hora;
    private int maxpersonas;
    private int inscritos;
    private double precio;
    private String instalacion;
    private String deporte;
    private String monitores;

    public ActividadName() {
    }

    public ActividadName(int idactividad, String nombre, String dia, String hora, int maxpersonas, int inscritos, double precio, String instalacion, String deporte, String monitores) {
        this.idactividad = idactividad;
        this.nombre = nombre;
        this.dia = dia;
        this.hora = hora;
        this.maxpersonas = maxpersonas;
        this.inscritos = inscritos;
        this.precio = precio;
        this.instalacion = instalacion;
        this.deporte = deporte;
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

    public String getInstalacion() {
        return instalacion;
    }

    public void setInstalacion(String instalacion) {
        this.instalacion = instalacion;
    }

    public String getDeporte() {
        return deporte;
    }

    public void setDeporte(String deporte) {
        this.deporte = deporte;
    }

    public String getMonitores() {
        return monitores;
    }

    public void setMonitores(String monitores) {
        this.monitores = monitores;
    }

    @Override
    public String toString() {
        return "ActividadName{" + "idactividad=" + idactividad + ", nombre=" + nombre + ", dia=" + dia + ", hora=" + hora + ", maxpersonas=" + maxpersonas + ", inscritos=" + inscritos + ", precio=" + precio + ", instalacion=" + instalacion + ", deporte=" + deporte + ", monitores=" + monitores + '}';
    }

   
    
    
}
