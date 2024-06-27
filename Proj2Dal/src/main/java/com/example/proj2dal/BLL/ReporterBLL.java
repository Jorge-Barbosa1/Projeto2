package com.example.proj2dal.BLL;

import com.example.proj2dal.Entity.ReporterEntity;
import com.example.proj2dal.Entity.UtilizadorEntity;
import jakarta.persistence.EntityManager;

import java.util.*;
public class ReporterBLL {

    public static void create (UtilizadorEntity rep){
        EntityManager em = DBConnection.getEntityManager();
        em.getTransaction().begin();
        em.persist(rep);
        em.getTransaction().commit();
    }

    public static void delete (ReporterEntity rep){
        EntityManager em = DBConnection.getEntityManager();
        em.getTransaction().begin();
        em.remove(rep);
        em.getTransaction().commit();
    }
    public static ReporterEntity findReporter(long id){
        return DBConnection.getEntityManager().find(ReporterEntity.class, id);
    }

    public static List listReporter(){
        return DBConnection.getEntityManager().createQuery("from ReporterEntity ").getResultList();
    }

    public static List listRepoterWithName(String name){
        return DBConnection.getEntityManager().createQuery("from ReporterEntity where nome like ?1").setParameter(1, name).getResultList();
    }

}
