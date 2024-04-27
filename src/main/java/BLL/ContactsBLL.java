package BLL;

import Entity.ContactosEntity;
import jakarta.persistence.EntityManager;

import java.util.*;

public class ContactsBLL {

    public static void createAdmin(ContactosEntity con){
        EntityManager em = DBConnection.getEntityManager();
        em.getTransaction().begin();
        em.persist(con);
        em.getTransaction().commit();
    }

    public static void deleteAdmin(ContactosEntity con){
        EntityManager em = DBConnection.getEntityManager();
        em.getTransaction().begin();
        em.remove(con);
        em.getTransaction().commit();
    }

    public static ContactosEntity findContacts(int id){
        return DBConnection.getEntityManager().find(ContactosEntity.class,id);
    }

    public static List listContacts(){
        return DBConnection.getEntityManager().createQuery("from ContactosEntity ").getResultList();
    }

    // Listar Com o mail( nao sei se faz sentido)
    public static List listContactsWithEmail(String name){
        return  DBConnection.getEntityManager().createQuery("from ContactosEntity where email like ?1 ").setParameter(1,name).getResultList();
    }
}
