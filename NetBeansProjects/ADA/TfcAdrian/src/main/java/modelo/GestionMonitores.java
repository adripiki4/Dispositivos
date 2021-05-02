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
import mx.com.gm.sga.domain.Monitores;

/**
 *
 * @author adrip
 */
public class GestionMonitores {
    //metodo para obtener el objeto EntityManager

    private EntityManager getEntityManager() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("TFCadrianPU");
        return factory.createEntityManager();
    }
    
    //Alta de Monitor
    public void altaMonitor(int idmonitores, String nombre, String apellidos, int telefono, String email){
        Monitores monitor = new Monitores(idmonitores, nombre, apellidos, telefono, email);
        EntityManager em = getEntityManager();
        //Incluimos la operacion en una transaccion
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(monitor);
        tx.commit();
        em.clear();
    }
    
    //Listar monitores
    public List<Monitores> recuperarMonitores(){
        EntityManager em = getEntityManager();
        TypedQuery<Monitores> qr = em.createQuery("SELECT m from Monitores m", Monitores.class);
        List<Monitores> listmonitores = qr.getResultList();
        em.clear();
        return listmonitores;
    }
    
    //Actualizar monitores
    public void actualizarMonitores(Monitores monitor){
        EntityManager em = getEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.merge(monitor);
        tx.commit();
        em.clear();
    }
    
    //Borrar un monitor
    public void eliminarMonitor(int idmonitores){
        Monitores monitor = new Monitores();
        EntityManager em = getEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        monitor = em.find(Monitores.class, idmonitores);
        em.remove(monitor);
        tx.commit();
        em.clear();
    }
    
    //Buscar un monitor
    public Monitores buscaMonitor(int idmonitores){
        Monitores monitor = new Monitores();
        EntityManager em = getEntityManager();
        monitor = em.find(Monitores.class, idmonitores);
        em.clear();
        return monitor;
    }
}
