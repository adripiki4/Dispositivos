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
import javax.persistence.TypedQuery;
import mx.com.gm.sga.domain.Cliente;

/**
 *
 * @author adrip
 */
public class GestionCliente {
    //metodo para obtener el objeto EntityManager

    private EntityManager getEntityManager() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("TFCadrianPU");
        return factory.createEntityManager();
    }
    
    //Alta de Cliente
    public void altaCliente(String dni,String nombre, String apellidos, int telefono, String email,double cuota){
        Cliente cliente = new Cliente(dni, nombre, apellidos, telefono, email, cuota);
        EntityManager em = getEntityManager();
        //Incluimos la operacion en una transaccion
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(cliente);
        tx.commit();
        em.clear();
    }
    
    //Listar Clientes
    public List<Cliente> recuperarClientes(){
        EntityManager em = getEntityManager();
//        String select = "SELECT c from clientes c";
//        System.out.println("Antes");
//        Query qr = em.createQuery(select);
//        System.out.println("Despues");
        TypedQuery<Cliente> qr = em.createQuery("SELECT c from Cliente c",Cliente.class);
        List<Cliente> listClientes = qr.getResultList();
        em.clear();
        return listClientes;
    }
    
    //Buscar un cliente por dni
    public Cliente buscaCliente(String dni){
        Cliente cliente = new Cliente();
        EntityManager em = getEntityManager();
        cliente = em.find(Cliente.class, dni);
        em.clear();
        return cliente;
    }
    
    //Actualizar Cliente
    public void actualizarCliente(Cliente cliente){
        EntityManager em = getEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.merge(cliente);
        tx.commit();
        em.clear();
    }
    
    //Borrar un cliente
    public void eliminarCliente(String dni){
        Cliente cliente = new Cliente();
        EntityManager em = getEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        cliente = em.find(Cliente.class, dni);
        em.remove(cliente);
        tx.commit();
        em.clear();
    }
}
