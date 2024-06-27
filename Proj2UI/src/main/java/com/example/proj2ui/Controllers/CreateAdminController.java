package com.example.proj2ui.Controllers;

import com.example.proj2dal.BLL.AdministratorBLL;
import com.example.proj2dal.BLL.ReporterBLL;
import com.example.proj2dal.BLL.UserBLL;
import com.example.proj2dal.Entity.UtilizadorEntity;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.math.BigInteger;

public class CreateAdminController {
    @FXML
    public Button createAdminButton;
    @FXML
    public Button backButton;
    @FXML
    public TextField nameTxt;
    @FXML
    public TextField phoneTxt;
    @FXML
    public TextField emailTxt;
    @FXML
    public TextField usernameTxt;
    @FXML
    public PasswordField passwordPwd;

    @FXML
    void createAccount(ActionEvent event) {
        String name = nameTxt.getText();
        int phone = Integer.parseInt(phoneTxt.getText());
        String email = emailTxt.getText();
        String username = usernameTxt.getText();
        String password = passwordPwd.getText();

        //Encontrar o proximo id disponivel
        int id = UserBLL.getNextAvailableId();

        UtilizadorEntity user = new UtilizadorEntity();
        user.setNome(name);
        user.setTelefone(BigInteger.valueOf(phone));
        user.setEmail(email);
        user.setUsername(username);
        user.setPassword(password);
        user.setIsAdmin(1);
        user.setIdUser(id);

        // Criar o utilizador na tabela User e na Tabela Reporter
        try {
            UserBLL.createUser(user);
            AdministratorBLL.createAdmin(user);
            showAlert(Alert.AlertType.INFORMATION,"Conta Criada", "A conta foi criada com sucesso!");
        } catch (Exception e) {
            e.printStackTrace();
            showAlert(Alert.AlertType.ERROR,"Erro", "Não foi possível criar a conta!");
        }

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/proj2ui/AdminMenu.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = (Stage) backButton.getScene().getWindow();
            stage.setScene(scene);
            stage.setTitle("Create Account");
        } catch (IOException e) {
            e.printStackTrace();
            showAlert(Alert.AlertType.ERROR, "Erro", "Não foi possível carregar a página de criação de conta.");
        }
    }


    private void showAlert(Alert.AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    @FXML
    void backScene(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/proj2ui/AdminMenu.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = (Stage) backButton.getScene().getWindow();
            stage.setScene(scene);
            stage.setTitle("Create Account");
        } catch (IOException e) {
            e.printStackTrace();
            showAlert(Alert.AlertType.ERROR, "Erro", "Não foi possível carregar a página de criação de conta.");
        }
    }
}
