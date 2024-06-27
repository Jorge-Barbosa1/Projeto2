package com.example.proj2ui.Controllers;

import com.example.proj2dal.BLL.UserBLL;
import com.example.proj2dal.Entity.UtilizadorEntity;
<<<<<<< HEAD
import com.example.proj2ui.Managers.SessionInfo;
=======
>>>>>>> eb702fc9e8dcd3b9124f9cec0d55e14d654e8284
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
<<<<<<< HEAD
import java.math.BigInteger;
=======
>>>>>>> eb702fc9e8dcd3b9124f9cec0d55e14d654e8284

public class LoginController {
    @FXML
    private Button entryButton;
    @FXML
    private Button createAccountButton;
    @FXML
    private TextField usernameTxt;
    @FXML
    private PasswordField passwordPwd;

    @FXML
    void login(ActionEvent event){
        String username = usernameTxt.getText();
        String password = passwordPwd.getText();

        UtilizadorEntity user = UserBLL.logUser(username, password);

        if (user != null) {
            showAlert(Alert.AlertType.INFORMATION, "Login bem sucedido", "Bem Vindo " + user.getNome());
            if(user.getIsAdmin()==1){//Verifica se o Utilizador é Administrador ou não
<<<<<<< HEAD
                SessionInfo.setAdminId(BigInteger.valueOf(user.getIdUser()));
=======
>>>>>>> eb702fc9e8dcd3b9124f9cec0d55e14d654e8284
                loadPage("/com/example/proj2ui/AdminMenu.fxml","Menu Administrador");
            }else{
                //loadPage("/com/example/proj2ui/ReporterMenu.fxml","Menu Reporter");
            }
            // Mudar de tela
        } else {
            showAlert(Alert.AlertType.ERROR, "Erro no Login", "Username ou Password Inválidos");
        }
    }

    //Função para lançar alertas/Erros
    private void showAlert(Alert.AlertType alertType, String title, String message){
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    //Função para trocar de páginas
    private void loadPage(String fxmlPath, String title) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(fxmlPath));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = (Stage) entryButton.getScene().getWindow();
            stage.setScene(scene);
            stage.setTitle(title);
        } catch (IOException e) {
            e.printStackTrace();
            showAlert(Alert.AlertType.ERROR, "Error", "Failed to load the page.");
        }
    }

    @FXML
    void createAccount(ActionEvent event){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/proj2ui/CreateAccount.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = (Stage) createAccountButton.getScene().getWindow();
            stage.setScene(scene);
            stage.setTitle("Create Account");
        } catch (IOException e) {
            e.printStackTrace();
            showAlert(Alert.AlertType.ERROR, "Error", "Failed to load the Create Account page.");
        }
    }
}
