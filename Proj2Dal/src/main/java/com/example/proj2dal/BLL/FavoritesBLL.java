package com.example.proj2dal.BLL;

import com.example.proj2dal.Entity.FavoritosEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;

public class FavoritesBLL {

    public static void createFavorite(FavoritosEntity fav){
        EntityManager em = DBConnection.getEntityManager();
        em.getTransaction().begin();
        em.persist(fav);
        em.getTransaction().commit();
    }

    public static void deleteFavorite(BigInteger id){
        EntityManager em = DBConnection.getEntityManager();
        try {
            em.getTransaction().begin();
            FavoritosEntity fav = em.find(FavoritosEntity.class, id);
            if (fav != null) {
                em.remove(fav);
            } else {
                throw new NoResultException("Favorite not found with ID: " + id);
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw e;
        } finally {
            em.close();
        }
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

    public static List<FavoritosEntity> listFavsByUser(int userId) {
        EntityManager em = DBConnection.getEntityManager();
        try {
            return em.createQuery("SELECT f FROM FavoritosEntity f WHERE f.userId = :id", FavoritosEntity.class)
                    .setParameter("id", userId)
                    .getResultList();
        } finally {
            em.close();
        }
    }

    public static int getNextAvailableId(){
        EntityManager em = DBConnection.getEntityManager();
        try {
            String sql = "SELECT MIN(f.id_favoritos + 1) FROM favoritos f LEFT JOIN favoritos f2 ON f.id_favoritos + 1 = f2.id_favoritos WHERE f2.id_favoritos IS NULL";
            // O resultado é extraído como BigDecimal
            BigDecimal result = (BigDecimal) em.createNativeQuery(sql).getSingleResult();
            // Converte BigDecimal para int
            int nextId = (result != null) ? result.intValue() : 1;
            return nextId;
        } catch (Exception e) {
            e.printStackTrace();
            return 1; // Fallback em caso de erro
        } finally {
            if (em != null && em.isOpen()) {
                em.close();
            }
        }
    }

}
