package com.example.proj2ui.Controllers;

import com.example.proj2dal.BLL.CampBLL;
import com.example.proj2dal.BLL.TeamBLL;
import com.example.proj2dal.Entity.CampoEntity;
import com.example.proj2dal.Entity.EquipaEntity;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class CreateCampController {
    @FXML
    public Button goBackButton;
    @FXML
    public Button createButton;
    @FXML
    public TextField nameTxtField;
    @FXML
    public TextField villageTxtField;
    @FXML
    public TextField rueTxtField;
    @FXML
    public TextField postCodeTxtField;

    @FXML
    void backPage(ActionEvent event){
        loadPage(goBackButton,"/com/example/proj2ui/AdminMenu.fxml","Login");
    }

    @FXML
    void createCamp(ActionEvent event){
        CampoEntity campo = new CampoEntity();

        String name = nameTxtField.getText();
        String village = villageTxtField.getText();
        String rue = rueTxtField.getText();
        int postCode = Integer.parseInt(postCodeTxtField.getText());
        int id = CampBLL.getNextAvailableId();

        if(name.isEmpty()){
            showAlert(Alert.AlertType.ERROR, "Erro", "O nome da equipa não pode estar vazio.");
            return;
        }
        //Criar a equipa
        campo.setNome(name);
        campo.setIdCampo(id);
        campo.setCodpostal(postCode);
        campo.setFreguesia(village);
        campo.setRua(rue);
        CampBLL.createCamp(campo);
        showAlert(Alert.AlertType.INFORMATION,"Equipa Criada", "A equipa foi criada com sucesso!");
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
