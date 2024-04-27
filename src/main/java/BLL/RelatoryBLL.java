package BLL;

import Entity.RelatorioEntity;
import jakarta.persistence.EntityManager;

import java.util.*;

public class RelatoryBLL {

    public static void create(RelatorioEntity rl) {
        EntityManager em = DBConnection.getEntityManager();
        em.getTransaction().begin();
        em.persist(rl);
        em.getTransaction().commit();
    }

    public static void delete(RelatorioEntity rl) {
        EntityManager em = DBConnection.getEntityManager();
        em.getTransaction().begin();
        em.remove(rl);
        em.getTransaction().commit();
    }

    public static RelatorioEntity findReporter(long id) {
        return DBConnection.getEntityManager().find(RelatorioEntity.class, id);
    }

    public static List<RelatorioEntity> listRelatory(){
        return DBConnection.getEntityManager().createQuery("from RelatorioEntity ").getResultList();
    }
}
