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

    public UtilizadorEntity getAuthenticatedUser(String username, String password){
        UtilizadorEntity user = null;

        final String Db_Url = "jdbc:postgresql://localhost:5432/projeto";
        final String DB_username = "postgres";
        final String DB_password = "basedados";

        try{
            Connection con = DriverManager.getConnection(Db_Url,DB_username,DB_password);
            //Connected with the database

            Statement stat = con.createStatement();
            String sql = "Select u.id_user,u.username,u.password From Utilizador u " +
                    "Left Join administrador a ON u.id_user= a.id_user " +
                    " Where u.username=? And u.password=? ";
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1,username);
            preparedStatement.setString(2,password);

            ResultSet resultSet = preparedStatement.executeQuery();

            if(resultSet.next()){
                user = new UtilizadorEntity();
                user.setNome(resultSet.getString("nome"));
                user.setEmail(resultSet.getString("email"));
                user.setUsername(resultSet.getString("username"));


            }

            stat.close();
            con.close();//Close the connection

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return user;

    }

}
