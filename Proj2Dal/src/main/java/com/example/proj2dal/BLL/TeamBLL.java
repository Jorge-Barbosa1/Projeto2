package com.example.proj2dal.BLL;


import com.example.proj2dal.Entity.EquipaEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

import java.util.List;

public class TeamBLL {

    public static void createTeam(EquipaEntity eq){
        EntityManager em = DBConnection.getEntityManager();
        em.getTransaction().begin();
        em.persist(eq);
        em.getTransaction().commit();
    }

    public static void deleteTeam(EquipaEntity eq){
        EntityManager em = DBConnection.getEntityManager();
        em.getTransaction().begin();
        em.remove(eq);
        em.getTransaction().commit();
    }

    public static EquipaEntity findTeam(int id){
        return DBConnection.getEntityManager().find(EquipaEntity.class,id);
    }

    public static List listTeams(){
        return DBConnection.getEntityManager().createQuery("from EquipaEntity ").getResultList();
    }

    public static List listTeamWithName(String name){
        return  DBConnection.getEntityManager().createQuery("from EquipaEntity where nome like ?1 ").setParameter(1,name).getResultList();
    }

    public static int getNextAvailableId(){
        EntityManager em = DBConnection.getEntityManager();
        Query query = em.createNativeQuery("SELECT MIN(e.id_equipa + 1) FROM equipa e LEFT JOIN equipa e2 ON e.id_equipa + 1 = e2.id_equipa WHERE e2.id_equipa IS NULL");
        return (Integer) query.getSingleResult();
    }
}
