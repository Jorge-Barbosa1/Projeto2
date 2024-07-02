package com.example.proj2ui.DTO;

import com.example.proj2dal.BLL.DBConnection;


public class AdminManager {
    private DBConnection connection;

    public AdminManager(){
        this.connection= (DBConnection) DBConnection.getEntityManager();
    }


}
