package com.example.proj2dal.BLL;

import com.example.proj2dal.Entity.JogoEntity;
import jakarta.persistence.EntityManager;
<<<<<<< HEAD
import jakarta.persistence.Query;

import java.math.BigDecimal;
import java.math.BigInteger;
=======

>>>>>>> eb702fc9e8dcd3b9124f9cec0d55e14d654e8284
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

<<<<<<< HEAD
    public static BigInteger getNextAvailableId(){
        EntityManager em = DBConnection.getEntityManager();
        try {
            Query query = em.createNativeQuery("SELECT COALESCE(MIN(j.id_jogo + 1), 1) FROM jogo j LEFT JOIN jogo j2 ON j.id_jogo + 1 = j2.id_jogo WHERE j2.id_jogo IS NULL");
            Object result = query.getSingleResult();
            if (result instanceof BigDecimal) {
                return ((BigDecimal) result).toBigInteger();
            } else if (result instanceof BigInteger) {
                return (BigInteger) result;
            }
            return BigInteger.ONE; // Default case, should not normally reach here
        } finally {
            //em.close(); // Ensure the EntityManager is closed after the operation.
        }
    }

=======
>>>>>>> eb702fc9e8dcd3b9124f9cec0d55e14d654e8284

}
