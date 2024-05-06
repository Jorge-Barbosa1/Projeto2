package com.example.proj2dal.BLL;

import com.example.proj2dal.Entity.AdministradorEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

import java.util.*;

public class AdministratorBLL {

    public static void createAdmin(AdministradorEntity adm){
        EntityManager em = DBConnection.getEntityManager();
        em.getTransaction().begin();
        em.persist(adm);
        em.getTransaction().commit();
    }

    public static void deleteAdmin(AdministradorEntity adm){
        EntityManager em = DBConnection.getEntityManager();
        em.getTransaction().begin();
        em.remove(adm);
        em.getTransaction().commit();
    }

    public static AdministradorEntity findAdmin(int id){
        return DBConnection.getEntityManager().find(AdministradorEntity.class,id);
    }

    public static AdministradorEntity findAdminByUsername(String username) {
        EntityManager em = DBConnection.getEntityManager();
        Query query = em.createQuery("From AdministradorEntity Where a.username = :username");
        query.setParameter("username", username);
        //List<AdministradorEntity> re
        return null;
    }

    public static List listAdmins(){
        return DBConnection.getEntityManager().createQuery("from AdministradorEntity ").getResultList();
    }

    public static List listAdminWithName(String name){
        return  DBConnection.getEntityManager().createQuery("from AdministradorEntity where nome like ?1 ").setParameter(1,name).getResultList();
    }

}
