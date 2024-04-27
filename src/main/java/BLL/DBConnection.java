package BLL;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class DBConnection {
    private static EntityManagerFactory factory = Persistence.createEntityManagerFactory("default");
    private static EntityManager em = factory.createEntityManager();

    public static EntityManager getEntityManager(){
        return em;
    }
}
