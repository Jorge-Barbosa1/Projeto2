package com.example.proj2dal.BLL;

import com.example.proj2dal.Entity.UtilizadorEntity;
import jakarta.persistence.EntityManager;

import java.util.*;

public class UserBLL {

    public static void createUser(UtilizadorEntity con){
        EntityManager em = DBConnection.getEntityManager();
        em.getTransaction().begin();
        em.persist(con);
        em.getTransaction().commit();
    }

    public static void deleteUser(UtilizadorEntity con){
        EntityManager em = DBConnection.getEntityManager();
        em.getTransaction().begin();
        em.remove(con);
        em.getTransaction().commit();
    }

    public static UtilizadorEntity findUser(int id){
        return DBConnection.getEntityManager().find(UtilizadorEntity.class,id);
    }

    public static List listUser(){
        return DBConnection.getEntityManager().createQuery("from UtilizadorEntity ").getResultList();
    }
}
