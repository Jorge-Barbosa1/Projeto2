package com.example.proj2dal.BLL;

import com.example.proj2dal.Entity.FavoritosEntity;
import jakarta.persistence.EntityManager;

import java.util.*;

public class FavoritesBLL {

    public static void createAdmin(FavoritosEntity fav){
        EntityManager em = DBConnection.getEntityManager();
        em.getTransaction().begin();
        em.persist(fav);
        em.getTransaction().commit();
    }

    public static void deleteAdmin(FavoritosEntity fav){
        EntityManager em = DBConnection.getEntityManager();
        em.getTransaction().begin();
        em.remove(fav);
        em.getTransaction().commit();
    }

    public static FavoritosEntity findFavs(int id){
        return DBConnection.getEntityManager().find(FavoritosEntity.class,id);
    }

    public static List listFavs(){
        return DBConnection.getEntityManager().createQuery("from FavoritosEntity ").getResultList();
    }

    public static List listFavsName(String equipa) {
        return DBConnection.getEntityManager().createQuery("from FavoritosEntity where equipa like ?1 ").setParameter(1, equipa).getResultList();
    }
}
