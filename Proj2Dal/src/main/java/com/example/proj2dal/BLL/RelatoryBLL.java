package com.example.proj2dal.BLL;

import com.example.proj2dal.Entity.RelatorioEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;


public class RelatoryBLL {

    public static void create(RelatorioEntity rl) {
        EntityManager em = null;
        try {
            System.out.println("Obtaining EntityManager");
            em = DBConnection.getEntityManager();
            if (!em.isOpen()) {
                System.out.println("EntityManager is closed!");
                return;
            }
            System.out.println("Starting transaction");
            em.getTransaction().begin();
            System.out.println("Persisting entity");
            em.persist(rl);
            System.out.println("Committing transaction");
            em.getTransaction().commit();
            System.out.println("Transaction committed");
        } catch (Exception e) {
            System.out.println("Error during transaction: " + e.getMessage());
            if (em != null && em.getTransaction().isActive()) {
                System.out.println("Attempting to rollback transaction");
                em.getTransaction().rollback();
            }
            throw e;
        } finally {
            if (em != null) {
                System.out.println("Closing EntityManager");
                em.close();
            }
        }
    }

    public static void delete(RelatorioEntity rl) {
        EntityManager em = null;
        try {
            em = DBConnection.getEntityManager();
            em.getTransaction().begin();
            em.remove(em.contains(rl) ? rl : em.merge(rl));
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em != null && em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw e;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public static RelatorioEntity findReporter(long id) {
        EntityManager em = DBConnection.getEntityManager();
        try {
            return em.find(RelatorioEntity.class, id);
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public static List<RelatorioEntity> listRelatory() {
        EntityManager em = DBConnection.getEntityManager();
        try {
            return em.createQuery("from RelatorioEntity", RelatorioEntity.class).getResultList();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public static BigInteger getNextAvailableId(){
        EntityManager em = DBConnection.getEntityManager();
        try {
            // Ajuste na query para buscar o próximo ID da tabela relatorio
            Query query = em.createNativeQuery("SELECT COALESCE(MIN(r.id_relatorio + 1), 1) FROM relatorio r LEFT JOIN relatorio r2 ON r.id_relatorio + 1 = r2.id_relatorio WHERE r2.id_relatorio IS NULL");
            Object result = query.getSingleResult();
            if (result instanceof BigDecimal) {
                return ((BigDecimal) result).toBigInteger();
            } else if (result instanceof BigInteger) {
                return (BigInteger) result;
            }
            return BigInteger.ONE; // Caso padrão, não deve ser normalmente alcançado
        } finally {
            if(em != null)
                em.close();
            // Considera-se uma boa prática fechar o EntityManager
        }
    }
}
