package com.example.proj2ui.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class AdminMenuController {
    @FXML
    Button newAdminButton;
    @FXML
    Button newTeamButton;
    @FXML
    Button newPlayerButton;
    @FXML
    Button exitButton;
    @FXML
    Button backToLoginButton;
    @FXML
    Button checkResultButton;
    @FXML
    Button resumeButton;
    @FXML
    Button newCampButton;
    @FXML
    Button newGameButton;
    @FXML
    Button newRefButton;
    @FXML
    Button newRefTeamButton;

    @FXML
    void createAdmin(ActionEvent event){
        loadPage(newAdminButton,"/com/example/proj2ui/CreateAdmin.fxml","Novo Administrador");
    }

    @FXML
    void createTeam(ActionEvent event){
        loadPage(newTeamButton,"/com/example/proj2ui/CreateTeam.fxml","Nova Equipa");
    }

    @FXML
    void newPlayer(ActionEvent event){
        loadPage(newPlayerButton,"/com/example/proj2ui/CreatePlayer.fxml","Novo Jogador");
    }
    @FXML
    void createRef(ActionEvent event){
        loadPage(newRefButton,"/com/example/proj2ui/CreateReferee.fxml","Novo Árbitro");
    }

    @FXML
    void checkResult(ActionEvent event){
        loadPage(checkResultButton,"/com/example/proj2ui/CheckResult.fxml","Ver Resultados");
    }

    @FXML
    void createRefTeam(ActionEvent event){
        loadPage(newRefTeamButton,"/com/example/proj2ui/CreateRefTeam.fxml","Nova Equipa de Arbitragem");
    }

    @FXML
    void resume(ActionEvent event){
        loadPage(resumeButton,"/com/example/proj2ui/CreateResume.fxml","Resumo");
    }

    @FXML
    void backToLogin(ActionEvent event){
        loadPage(backToLoginButton,"/com/example/proj2ui/LoginPage.fxml","Login");
    }

    @FXML
    void createCamp(ActionEvent event){
        loadPage(newCampButton,"/com/example/proj2ui/CreateCamp.fxml","Novo Campo");
    }

    @FXML
    void createGame(ActionEvent event){
        loadPage(newGameButton,"/com/example/proj2ui/CreateGame.fxml","Novo Jogo");
    }
    @FXML
    void exitApp(ActionEvent event){
        Stage stage = (Stage) exitButton.getScene().getWindow();
        stage.close();
    }

    //Função para trocar de páginas
    private void loadPage(Button button,String fxmlPath, String title) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(fxmlPath));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = (Stage) button.getScene().getWindow();
            stage.setScene(scene);
            stage.setTitle(title);
        } catch (IOException e) {
            e.printStackTrace();
            showAlert(Alert.AlertType.ERROR, "Error", "Failed to load the page.");
        }
    }

    private void showAlert(Alert.AlertType alertType, String title, String message){
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

}
