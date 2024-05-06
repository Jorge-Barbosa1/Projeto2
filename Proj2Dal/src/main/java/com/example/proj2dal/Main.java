package com.example.proj2dal;

import com.example.proj2dal.BLL.UserBLL;
import com.example.proj2dal.Entity.UtilizadorEntity;


public class Main {
    public static void main(String[] args) {
        //TESTES

        UtilizadorEntity user = UserBLL.findUser(1);
        System.out.println(user.getNome());

    }
}