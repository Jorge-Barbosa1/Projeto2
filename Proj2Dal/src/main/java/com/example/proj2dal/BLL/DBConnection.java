package com.example.proj2dal.BLL;

import com.example.proj2dal.Entity.UtilizadorEntity;
import jakarta.persistence.*;

import java.sql.*;

public class DBConnection {
    private static EntityManagerFactory factory = Persistence.createEntityManagerFactory("default");
    private static EntityManager em = factory.createEntityManager();

    public static EntityManager getEntityManager(){
        return em;
    }



}
