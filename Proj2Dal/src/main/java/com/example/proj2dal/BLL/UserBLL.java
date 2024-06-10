package com.example.proj2dal.BLL;

import com.example.proj2dal.Entity.UtilizadorEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;

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

    public static UtilizadorEntity logUser(String username, String password){
        try {
            return DBConnection.getEntityManager().createQuery("from UtilizadorEntity u Where u.username= username AND u.password= password", UtilizadorEntity.class).getSingleResult();
        }catch (NoResultException ex){
            return null;
        }
    }

    public static List listUser(){
        return DBConnection.getEntityManager().createQuery("from UtilizadorEntity ").getResultList();
    }
}
