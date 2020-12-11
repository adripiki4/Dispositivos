/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import mx.com.gm.sga.domain.Contacto;

/**
 *
 * @author adriba
 */
public class GestionContactos {

    //metodo para obtener el objeto EntityManager
    private EntityManager getEntityManager() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("ContactoPU");
        return factory.createEntityManager();
    }

    public void altaContacto(String nombre, String email, int telefono) {
        Contacto c = new Contacto(nombre, email, telefono);
        EntityManager em = getEntityManager();
        //la operacion la incluimos en una transaccion
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(c);
        tx.commit();
        em.clear();
    }
}
