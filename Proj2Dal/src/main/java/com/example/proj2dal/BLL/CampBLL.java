package com.example.proj2dal.BLL;

import com.example.proj2dal.Entity.CampoEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

import java.util.List;

public class CampBLL {

    public static void createCamp(CampoEntity camp){
        EntityManager em = DBConnection.getEntityManager();
        em.getTransaction().begin();
        em.persist(camp);
        em.getTransaction().commit();
    }

    public static void deleteCamp(CampoEntity camp){
        EntityManager em = DBConnection.getEntityManager();
        em.getTransaction().begin();
        em.remove(camp);
        em.getTransaction().commit();
    }

    public static CampoEntity findCamp(int id){
        return DBConnection.getEntityManager().find(CampoEntity.class,id);
    }

    public static List listCamp(){
        return DBConnection.getEntityManager().createQuery("from CampoEntity ").getResultList();
    }

    public static List listCampWithName(String name){
        return  DBConnection.getEntityManager().createQuery("from CampoEntity where nome like ?1 ").setParameter(1,name).getResultList();
    }

    public static int getNextAvailableId(){
        EntityManager em = DBConnection.getEntityManager();
        Query query = em.createNativeQuery("SELECT MIN(c.id_campo + 1) FROM campo c LEFT JOIN campo c2 ON c.id_campo + 1 = c2.id_campo WHERE c2.id_campo IS NULL");
        return (Integer) query.getSingleResult();
    }
}
