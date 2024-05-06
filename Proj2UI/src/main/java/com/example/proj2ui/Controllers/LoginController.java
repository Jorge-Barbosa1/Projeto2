package com.example.proj2ui.Controllers;

import com.example.proj2dal.BLL.DBConnection;
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
    public void initialize() {
        dbConnection = new DBConnection();
    }
    @FXML
    void login(ActionEvent event){
        initialize();

        String username= usernameTxt.getText();
        String password = passwordPwd.getText();

        UtilizadorEntity user = dbConnection.getAuthenticatedUser(username,password);

        if(user!= null){
            if(user.isAdmin()){

            }
        }

    }

}