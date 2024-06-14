package com.example.proj2dal.BLL;

import com.example.proj2dal.Entity.JogoEntity;
import jakarta.persistence.EntityManager;

import java.util.List;

public class GameBLL {

    public static void createGame(JogoEntity game){
        EntityManager em = DBConnection.getEntityManager();
        em.getTransaction().begin();
        em.persist(game);
        em.getTransaction().commit();
    }

    public static void deleteGame(JogoEntity game){
        EntityManager em = DBConnection.getEntityManager();
        em.getTransaction().begin();
        em.remove(game);
        em.getTransaction().commit();
    }

    public static JogoEntity findGame(int id){
        return DBConnection.getEntityManager().find(JogoEntity.class,id);
    }

    public static List listGames(){
        return DBConnection.getEntityManager().createQuery("from JogoEntity ").getResultList();
    }


}
