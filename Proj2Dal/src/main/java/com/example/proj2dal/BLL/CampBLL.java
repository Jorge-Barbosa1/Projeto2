package com.example.proj2dal.BLL;

import com.example.proj2dal.Entity.CampoEntity;
import jakarta.persistence.EntityManager;

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
}
