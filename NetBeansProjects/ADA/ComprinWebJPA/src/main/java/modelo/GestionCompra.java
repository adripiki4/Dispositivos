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
import mx.com.gm.sga.domain.Compra;

/**
 *
 * @author adrip
 */
public class GestionCompra {
    //metodo para obtener el objeto EntityManager

    private EntityManager getEntityManager() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("CompraPU");
        return factory.createEntityManager();
    }

    //Alta de compra
    public void altaCompra(Date FechaCompra, int Id_wallet, int Id_producto) {
        Compra c = new Compra(FechaCompra, Id_wallet, Id_producto);
        EntityManager em = getEntityManager();
        //incluimos la operacion en una transaccion
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(c);
        tx.commit();
        em.clear();
    }

    //Listar compras
    public List<Compra> listarCompras() {
        EntityManager em = getEntityManager();
        String select = "SELECT c from Compra c";
        Query qr = em.createQuery(select);
        List<Compra> listacompra = qr.getResultList();
        em.clear();
        return listacompra;
    }

    //Buscar una compra
    public Compra buscarCompra(int Id_compra) {
        Compra c = new Compra();
        EntityManager em = getEntityManager();
//        String find = "SELECT c from Compra c WHERE Id_compra=" + Id_compra;
//        Query qr = em.createQuery(find);
        c = em.find(Compra.class, Id_compra);
        em.clear();
        return c;
    }

    //Borrar un compra
    public void eliminarCompra(int Id_compra) {
        Compra c = new Compra();
        EntityManager em = getEntityManager();
        //incluimos la operacion en una transaccion
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        c = em.find(Compra.class, Id_compra);
        em.remove(c);
        tx.commit();
        em.clear();
    }
}
