package BLL;


import Entity.CampoEntity;
import Entity.JogadorEntity;
import jakarta.persistence.EntityManager;

import java.util.List;

public class PlayerBLL {
    public static void createCamp(JogadorEntity j){
        EntityManager em = DBConnection.getEntityManager();
        em.getTransaction().begin();
        em.persist(j);
        em.getTransaction().commit();
    }

    public static void deleteCamp(JogadorEntity j){
        EntityManager em = DBConnection.getEntityManager();
        em.getTransaction().begin();
        em.remove(j);
        em.getTransaction().commit();
    }

    public static JogadorEntity findPlayer(int id){
        return DBConnection.getEntityManager().find(JogadorEntity.class,id);
    }

    public static List listPlayer(){
        return DBConnection.getEntityManager().createQuery("from JogadorEntity ").getResultList();
    }

    public static List listPlayerWithName(String name){
        return  DBConnection.getEntityManager().createQuery("from JogadorEntity where nome like ?1 ").setParameter(1,name).getResultList();
    }
}
