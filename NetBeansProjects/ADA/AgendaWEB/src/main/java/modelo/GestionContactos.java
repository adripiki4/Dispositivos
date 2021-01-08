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
import javax.persistence.Query;
import mx.com.gm.sga.domain.Contacto;

/**
 *
 * @author adriba
 */
public class GestionContactos {

    //metodo para obtener el objeto EntityManager
    private EntityManager getEntityManager() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("WebPU");
        return factory.createEntityManager();
    }

    //Alta de contacto
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

    //Borrar un contacto
    public void eliminarContacto(int idContacto) {
        Contacto c = new Contacto();
        EntityManager em = getEntityManager();
        //La operacion la incluimos en una transaccion
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        c = em.find(Contacto.class, idContacto);
        em.remove(c);
        tx.commit();
        em.clear();
    }

    //Recuperar contactos
    public List<Contacto> recuperarContactos() {
        EntityManager em = getEntityManager();
        String select = "SELECT c from Contacto c";
        Query qr = em.createQuery(select);
        List<Contacto> listacont = qr.getResultList();
        em.clear();
        return listacont;
    }

    //Buscar contacto mismo email
    public List<Contacto> buscarEmails(String email) {
        EntityManager em = getEntityManager();
        String find = "SELECT c from Contacto c WHERE email=" + email;
        Query qr = em.createQuery(find);
        List<Contacto> listaemail = qr.getResultList();
        em.clear();
        return listaemail;
    }

    //Buscar un solo contacto con el email
    public Contacto buscaContacto(String email) {
        Contacto c = new Contacto();
        EntityManager em = getEntityManager();
        String find = "SELECT c from Contacto c WHERE email=" + email;
        Query qr = em.createQuery(find);
        c = (Contacto) qr.getSingleResult();
        em.clear();
        return c;
    }

}
