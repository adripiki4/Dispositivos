package test;

import mx.com.gm.sga.domain.Persona;
import org.apache.logging.log4j.*;
import javax.persistence.*;

public class ClienteEntidadPersona {

    static Logger log = LogManager.getFormatterLogger();

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PersonaPU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        //iniciamos la transaccion
        tx.begin();
        Persona persona1 = new Persona("Pedro", "Linares", "pedro@@", 45);
        log.debug("objeto a persistir " + persona1);
        //persistimos el objeto
        em.persist(persona1);
        //terminamos transaccion
        tx.commit();
        log.debug("Objeto persistido" + persona1);
        em.clear();
    }
}
