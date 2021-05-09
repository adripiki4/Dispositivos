/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.gm.sga.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
    //private int deportes_id;
    
    
    //Relacion con deporte
    @JoinColumn(name = "iddeporte")
    @ManyToOne
    private Deportes deportes;
    
    //Relacion hacia actividad
    @OneToMany(mappedBy = "instalacion")
    private List<Actividad> actividades = new ArrayList<Actividad>();
    

    public Instalacion() {
    }

    public Instalacion(int idinstalacion, String name, double precio, Deportes deporte) {
        this.idinstalacion = idinstalacion;
        this.name = name;
        this.precio = precio;
        this.deportes = deporte;
    }

    public Instalacion(String name, double precio, Deportes deporte) {
        this.name = name;
        this.precio = precio;
        this.deportes = deporte;
    }

    public Instalacion(String name, Deportes deporte) {
        this.name = name;
        this.deportes = deporte;
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

    public Deportes getDeportes() {
        return deportes;
    }

    public void setDeportes(Deportes deporte) {
        this.deportes = deporte;
    }

    @Override
    public String toString() {
        return name;
    }
    
    

    
    
    
    
}
