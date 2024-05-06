package com.example.proj2dal.BLL;

import com.example.proj2dal.Entity.ArbitroEntity;
import jakarta.persistence.EntityManager;

import java.util.List;

public class RefereeBLL {

    public static void createRef(ArbitroEntity ref){
        EntityManager em = DBConnection.getEntityManager();
        em.getTransaction().begin();
        em.persist(ref);
        em.getTransaction().commit();
    }

    public static void deleteRef(ArbitroEntity ref){
        EntityManager em = DBConnection.getEntityManager();
        em.getTransaction().begin();
        em.remove(ref);
        em.getTransaction().commit();
    }

    public static ArbitroEntity findRef(int id){
        return DBConnection.getEntityManager().find(ArbitroEntity.class,id);
    }

    public static List listRefs(){
        return DBConnection.getEntityManager().createQuery("from ArbitroEntity ").getResultList();
    }


    //Find the referee by the name (1 team has 3 refs)
    public static List listRef1WithName(String name){
        return  DBConnection.getEntityManager().createQuery("from ArbitroEntity where nome like ?1 ").setParameter(1,name).getResultList();
    }

}
