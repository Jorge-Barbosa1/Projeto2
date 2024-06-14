package com.example.proj2dal.BLL;

import com.example.proj2dal.Entity.UtilizadorEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;

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

    //Fazer Login
    public static UtilizadorEntity logUser(String username, String password){
        EntityManager em = DBConnection.getEntityManager();
        TypedQuery<UtilizadorEntity> query = em.createQuery(
                "FROM UtilizadorEntity u WHERE u.username = :username AND u.password = :password", UtilizadorEntity.class);
                query.setParameter("username", username);
                query.setParameter("password", password);
                try {
                    return query.getSingleResult();
                } catch (NoResultException ex) {
                    return null; // Nenhum resultado encontrado
                } catch (jakarta.persistence.NonUniqueResultException ex) {
                    // Lidar com múltiplos resultados
                    List<UtilizadorEntity> results = query.getResultList();
                    if (!results.isEmpty()) {
                        return results.get(0); // Retorna o primeiro resultado
                    } else {
                        return null; //
                }
            }
        }


    //Ver qual é o id mais baixo disponivel para atribuir ao proximo user
    public static int getNextAvailableId(){
        EntityManager em = DBConnection.getEntityManager();
        Query query = em.createNativeQuery("SELECT MIN(u1.id_user + 1) FROM utilizador u1 LEFT JOIN utilizador u2 ON u1.id_user + 1 = u2.id_user WHERE u2.id_user IS NULL");
        return (Integer) query.getSingleResult();
    }



    public static List listUser(){
        return DBConnection.getEntityManager().createQuery("from UtilizadorEntity ").getResultList();
    }
}
