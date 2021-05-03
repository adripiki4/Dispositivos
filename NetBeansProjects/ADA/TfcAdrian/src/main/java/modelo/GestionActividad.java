/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import mx.com.gm.sga.domain.Actividad;

/**
 *
 * @author adrip
 */
public class GestionActividad {
     //metodo para obtener el objeto EntityManager

    private EntityManager getEntityManager() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("TFCadrianPU");
        return factory.createEntityManager();
    }
    
    //Alta de Actividad
    public void altaActividad(Actividad actividad){
        EntityManager em = getEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(actividad);
        tx.commit();
        em.clear();
    }
    
    //Listar Actividades
    public List<Actividad> recuperarActividades(){
        EntityManager em = getEntityManager();
        TypedQuery<Actividad> qr = em.createQuery("SELECT a from Actividad a", Actividad.class);
        List<Actividad> listactividades = qr.getResultList();
        em.clear();
        return listactividades;
    }
    
    //Buscar una Actividad por id
    public Actividad buscaActividad(int idactividad){
        Actividad actividad = new Actividad();
        EntityManager em = getEntityManager();
        actividad = em.find(Actividad.class, idactividad);
        em.clear();
        return actividad;
    }
    
    //Actualizar actividad
    public void actualizarActividad(Actividad actividad){
        EntityManager em = getEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.merge(actividad);
        tx.commit();
        em.clear();
    }
    
    //Eliminar actividad
    public void eliminarActividad(int idactividad){
        EntityManager em = getEntityManager();
        Actividad actividad = new Actividad();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        actividad = em.find(Actividad.class,idactividad);
        em.remove(actividad);
        tx.commit();
        em.clear();
    }
}
