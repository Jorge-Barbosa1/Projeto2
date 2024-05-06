package com.example.proj2dal.BLL;

import com.example.proj2dal.Entity.ArbitragemEntity;
import jakarta.persistence.EntityManager;

import java.util.List;

public class RefTeamBLL {

    public static void createRefTeam(ArbitragemEntity ref){
        EntityManager em = DBConnection.getEntityManager();
        em.getTransaction().begin();
        em.persist(ref);
        em.getTransaction().commit();
    }

    public static void deleteRefTeam(ArbitragemEntity ref){
        EntityManager em = DBConnection.getEntityManager();
        em.getTransaction().begin();
        em.remove(ref);
        em.getTransaction().commit();
    }

    public static ArbitragemEntity findRefTeam(int id){
        return DBConnection.getEntityManager().find(ArbitragemEntity.class,id);
    }

    public static List listRefTeam(){
        return DBConnection.getEntityManager().createQuery("from ArbitragemEntity ").getResultList();
    }


}