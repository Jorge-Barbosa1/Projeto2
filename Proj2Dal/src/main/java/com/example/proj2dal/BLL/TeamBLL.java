package com.example.proj2dal.BLL;


import com.example.proj2dal.Entity.EquipaEntity;
import jakarta.persistence.EntityManager;

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
}
