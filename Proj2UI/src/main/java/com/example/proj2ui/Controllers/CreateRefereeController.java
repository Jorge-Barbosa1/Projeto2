package com.example.proj2ui.Controllers;

import com.example.proj2dal.BLL.RefereeBLL;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class CreateRefereeController {
    @FXML
    Button goBackButton;
    @FXML
    Button createButton;
    @FXML
    TextField nameTextField;


    @FXML
    void backPage(ActionEvent event){
        loadPage(goBackButton,"/com/example/proj2ui/AdminMenu.fxml","Login");
    }


    @FXML
    void createReferee(ActionEvent event){
        String name = nameTextField.getText();
        int id = RefereeBLL.getNextAvailableId();

        if(name.isEmpty()){
            showAlert(Alert.AlertType.ERROR, "Erro", "O Nome nao pode estar vazio.");
            return;
        }
        //Criar o árbitro
        com.example.proj2dal.Entity.ArbitroEntity referee = new com.example.proj2dal.Entity.ArbitroEntity();
        referee.setNome(name);
        referee.setIdArbitro(id);
        RefereeBLL.createRef(referee);
        showAlert(Alert.AlertType.INFORMATION,"Sucesso", "Árbitro criado com sucesso!");
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
