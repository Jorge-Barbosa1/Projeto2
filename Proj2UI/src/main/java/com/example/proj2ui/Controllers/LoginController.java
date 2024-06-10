package com.example.proj2ui.Controllers;

import com.example.proj2dal.BLL.DBConnection;
import com.example.proj2dal.BLL.UserBLL;
import com.example.proj2dal.Entity.UtilizadorEntity;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginController {
    @FXML
    Button entryButton;
    @FXML
    Button createAccountButton;
    @FXML
    TextField usernameTxt;
    @FXML
    PasswordField passwordPwd;

    private DBConnection dbConnection;

    @FXML
    void login(ActionEvent event){


        String username= usernameTxt.getText();
        String password = passwordPwd.getText();

        UtilizadorEntity loginSuccesfull = UserBLL.logUser(username,password);

        if(loginSuccesfull != null){
            System.out.println("Logged In");

        }

    }

}