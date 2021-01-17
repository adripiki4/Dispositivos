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
import mx.com.gm.sga.domain.Producto;

/**
 *
 * @author adrip
 */
public class GestionProducto {

    //metodo para obtener el objeto EntityManager
    private EntityManager getEntityManager() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("CompraPU");
        return factory.createEntityManager();
    }

    //Alta de producto
    public void altaProducto(String NombreProducto, int PrecioProducto, int PuntosProducto) {
        Producto pro = new Producto(NombreProducto, PrecioProducto, PuntosProducto);
        EntityManager em = getEntityManager();
        //incluimos la operacion en una transaccion
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(pro);
        tx.commit();
        em.clear();
    }

    //Listar Productos
    public List<Producto> listarProductos() {
        EntityManager em = getEntityManager();
        String select = "SELECT p from Producto p";
        Query qr = em.createQuery(select);
        List<Producto> listaproductos = qr.getResultList();
        em.clear();
        return listaproductos;
    }

    //Buscar un producto
    public Producto buscaProducto(int Id_producto) {
        Producto pro = new Producto();
        EntityManager em = getEntityManager();
//        String find = "SELECT p from Producto p WHERE Id_producto=" + Id_producto;
//        Query qr = em.createQuery(find);
        pro = em.find(Producto.class, Id_producto);
        em.clear();
        return pro;
    }
}
