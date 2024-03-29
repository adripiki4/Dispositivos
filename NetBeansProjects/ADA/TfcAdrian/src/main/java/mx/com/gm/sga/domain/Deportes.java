/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.gm.sga.domain;

import java.io.Serializable;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author adrip
 */
@Entity
@Table(name = "deportes")
public class Deportes implements Serializable {
    private static final long SerialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "iddeporte")
    private int id;
    private String name;
    
    
    
    //Relacion hacia instalacion
    @OneToMany(mappedBy = "deportes")
    private List<Instalacion> instalaciones = new ArrayList<Instalacion>();
    
    //Relacion hacia actividad
    @OneToMany(mappedBy = "deportes")
    private List<Actividad> actividades = new ArrayList<Actividad>();

    
    
    public Deportes() {
    }

    public Deportes(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
    
    
    
}
