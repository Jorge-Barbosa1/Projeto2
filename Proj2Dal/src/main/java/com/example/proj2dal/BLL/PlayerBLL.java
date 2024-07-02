package com.example.proj2dal.BLL;


import com.example.proj2dal.Entity.JogadorEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

import java.util.List;

public class PlayerBLL {
    public static void createPlayer(JogadorEntity j){
        EntityManager em = DBConnection.getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(j);
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw new RuntimeException(e);  // Propague a exceção para ser tratada ou logada adequadamente
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public static void deletePlayer(JogadorEntity j){
        EntityManager em = DBConnection.getEntityManager();
        em.getTransaction().begin();
        em.remove(j);
        em.getTransaction().commit();
    }

    public static JogadorEntity findPlayer(int id){
        return DBConnection.getEntityManager().find(JogadorEntity.class,id);
    }

    public static List listPlayer(){
        return DBConnection.getEntityManager().createQuery("from JogadorEntity ").getResultList();
    }

    public static List listPlayerWithName(String name){
        return  DBConnection.getEntityManager().createQuery("from JogadorEntity where nome like ?1 ").setParameter(1,name).getResultList();
    }

    public static int getNextAvailableId(){
        EntityManager em = DBConnection.getEntityManager();
        try {
            String sql = "SELECT MIN(j.id_jogador + 1) FROM jogador j LEFT JOIN jogador j2 ON j.id_jogador + 1 = j2.id_jogador WHERE j2.id_jogador IS NULL";
            Integer nextId = (Integer) em.createNativeQuery(sql).getSingleResult();
            return (nextId != null) ? nextId : 1;
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
