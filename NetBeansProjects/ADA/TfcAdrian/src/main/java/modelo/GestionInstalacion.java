/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import mx.com.gm.sga.domain.Instalacion;

/**
 *
 * @author adrip
 */
public class GestionInstalacion {
     //metodo para obtener el objeto EntityManager

    private EntityManager getEntityManager() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("TFCadrianPU");
        return factory.createEntityManager();
    }
    
    //Listar Instalaciones
    public List<Instalacion> recuperarInstalaciones(){
        EntityManager em = getEntityManager();
        TypedQuery qr = em.createQuery("SELECT c from Instalacion c",Instalacion.class);
        List<Instalacion> listinstalaciones = qr.getResultList();
        em.clear();
        return listinstalaciones;       
    }
    
    //Busca instalacion
    public Instalacion buscaInstalacion(int idinstalaciones){
        EntityManager em = getEntityManager();
        Instalacion instalacion = new Instalacion();
        instalacion = em.find(Instalacion.class, idinstalaciones);
        em.clear();
        return instalacion;
    }
    
}
