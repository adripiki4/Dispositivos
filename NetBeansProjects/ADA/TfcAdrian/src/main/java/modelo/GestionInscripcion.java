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
import mx.com.gm.sga.domain.Inscripcion;

/**
 *
 * @author adrip
 */
public class GestionInscripcion {
    //metodo para obtener el objeto EntityManager

    private EntityManager getEntityManager() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("TFCadrianPU");
        return factory.createEntityManager();
    }
    
    //Alta de inscripcion
    public void altaInscripcion(Inscripcion nueva){
        EntityManager em = getEntityManager();
        //Incluimos la operacion en una transaccion
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(nueva);
        tx.commit();
        em.clear();
    }
    
    //Listar Inscripciones
    public List<Inscripcion> recuperarInscripciones(){
        EntityManager em = getEntityManager();
        TypedQuery<Inscripcion> qr = em.createQuery("SELECT i from Inscripcion i",Inscripcion.class);
        List<Inscripcion> list = qr.getResultList();
        em.clear();
        return list;
    }
    
    //Buscar una inscripcion
    public Inscripcion buscaInscripcion(int idinscripcion){
        Inscripcion inscripcion = new Inscripcion();
        EntityManager em = getEntityManager();
        inscripcion = em.find(Inscripcion.class,idinscripcion);
        em.clear();
        return inscripcion;
    }
    
    //Actualizar inscripcion
    public void actualizarInscripcion(Inscripcion inscripcion){
        EntityManager em = getEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.merge(inscripcion);
        tx.commit();
        em.clear();
    }
    
    //Eliminar una inscripcion
    public void eliminarInscripcion(int idinscripcion){
        EntityManager em = getEntityManager();
        EntityTransaction tx = em.getTransaction();
        Inscripcion inscripcion = new Inscripcion();
        tx.begin();
        inscripcion = em.find(Inscripcion.class,idinscripcion);
        em.remove(inscripcion);
        tx.commit();
        em.clear();      
    }
}
