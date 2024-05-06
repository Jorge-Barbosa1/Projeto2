package com.example.proj2ui.Managers;

import com.example.proj2dal.BLL.DBConnection;


public class AdminManager {
    private DBConnection connection;

    public AdminManager(){
        this.connection= (DBConnection) DBConnection.getEntityManager();
    }


}
