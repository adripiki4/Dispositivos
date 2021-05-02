/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import mx.com.gm.sga.domain.Deportes;

/**
 *
 * @author adrip
 */
public class GestionDeportes {
    //metodo para obtener el objeto EntityManager

    private EntityManager getEntityManager() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("TFCadrianPU");
        return factory.createEntityManager();
    }
    
    //Listar deportes
    public List<Deportes> recuperarDeportes(){
        EntityManager em = getEntityManager();
        TypedQuery qr = em.createQuery("SELECT d from Deportes d", Deportes.class);
        List<Deportes> listdeportes = qr.getResultList();
        em.clear();
        return listdeportes;
    }
    
    //Buscar deporte
    public Deportes buscaDeporte(int id){
        EntityManager em = getEntityManager();
        Deportes deporte = new Deportes();
        deporte = em.find(Deportes.class, id);
        em.clear();
        return deporte;
    }
}
