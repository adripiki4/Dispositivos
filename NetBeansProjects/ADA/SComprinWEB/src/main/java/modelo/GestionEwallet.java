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
import mx.com.gm.sga.domain.Ewallet;

/**
 *
 * @author adrip
 */
public class GestionEwallet {
    //metodo para obtener el objeto EntityManager

    private EntityManager getEntityManager() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("CompraPU");
        return factory.createEntityManager();
    }

    //Alta de Ewallet
    public void altaEwallet(String Nombre, String Apellidos, String Dni, Date FechaNacimiento, String Email, int SaldoPuntos, int SaldoEuros) {
        Ewallet ewallet = new Ewallet(Nombre, Apellidos, Dni, FechaNacimiento, Email, SaldoPuntos, SaldoEuros);
        EntityManager em = getEntityManager();
        //Incluimos la operacion en una transaccion
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(ewallet);
        tx.commit();
        em.clear();
    }

    //listar Ewallets
    public List<Ewallet> recuperarEwallets() {
        EntityManager em = getEntityManager();
        String select = "SELECT e from Ewallet e";
        Query qr = em.createQuery(select);
        List<Ewallet> listEwallets = qr.getResultList();
        em.clear();
        return listEwallets;
    }

    //Buscar una Ewallet con el Id_wallet
    public Ewallet buscaEwallet(int Id_wallet) {
        Ewallet ewallet = new Ewallet();
        EntityManager em = getEntityManager();
//        String find = "SELECT e from EWALLET e WHERE Id_wallet=" + Id_wallet;
//        Query qr = em.createQuery(find);
        ewallet = em.find(Ewallet.class, Id_wallet);
        em.clear();
        return ewallet;
    }
}
