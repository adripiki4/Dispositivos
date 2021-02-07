/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import mx.com.gm.sga.domain.Devolucion;

/**
 *
 * @author adrip
 */
public class GestionDevolucion {
    //metodo para obtener el objeto EntityManager

    private EntityManager getEntityManager() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("CompraPU");
        return factory.createEntityManager();
    }

    //Alta de devolucion
    public void altaDevolucion(Date FechaDevolucion, int Id_wallet, int Id_producto) {
        Devolucion d = new Devolucion(FechaDevolucion, Id_wallet, Id_producto);
        EntityManager em = getEntityManager();
        //incluimos la operacion en una transaccion
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(d);
        tx.commit();
        em.clear();
    }

    //Listar devoluciones
    public List<Devolucion> listarDevoluciones() {
        EntityManager em = getEntityManager();
        String select = "SELECT d from Devolucion d";
        Query qr = em.createQuery(select);
        List<Devolucion> listadevoluciones = qr.getResultList();
        em.clear();
        return listadevoluciones;
    }
}
