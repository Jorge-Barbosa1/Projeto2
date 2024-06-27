package com.example.proj2ui.Controllers;

import com.example.proj2dal.Entity.EquipaEntity;
import com.example.proj2dal.BLL.PlayerBLL;
import com.example.proj2dal.BLL.TeamBLL;
import com.example.proj2dal.Entity.JogadorEntity;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

<<<<<<< HEAD
public class CreatePlayerController implements Initializable {
    @FXML
=======
public class CreatePlayerController{ //implements Initializable {
    /*@FXML
>>>>>>> eb702fc9e8dcd3b9124f9cec0d55e14d654e8284
    Button goBackButton;
    @FXML
    Button createButton;
    @FXML
    TextField nameTxtField;
    @FXML
    ComboBox<EquipaEntity> teamComboBox;

    @FXML
    void backPage(ActionEvent event){
        loadPage(goBackButton,"/com/example/proj2ui/AdminMenu.fxml","Login");
    }

    @FXML
    void createPlayer(ActionEvent event){
        String name = nameTxtField.getText();
        EquipaEntity team = teamComboBox.getValue();
        int id = PlayerBLL.getNextAvailableId();

        if(name.isEmpty()){
            showAlert(Alert.AlertType.ERROR, "Erro", "O Nome nao pode estar vazio.");
            return;
        }
        if(team == null){
            showAlert(Alert.AlertType.ERROR, "Erro", "Selecione uma equipa.");
            return;
        }
        //Criar o jogador
        JogadorEntity player = new JogadorEntity();
        player.setNome(name);
        player.setIdEquipa(team.getIdEquipa());
        player.setIdJogador(id);
        PlayerBLL.createPlayer(player);
        showAlert(Alert.AlertType.INFORMATION,"Sucesso", "Jogador criado com sucesso!");
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

    //Mostrar as Equipas na ComboBox
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        loadTeams();
    }

    private void loadTeams(){
        List<EquipaEntity> teams = TeamBLL.listTeams();
        ObservableList<EquipaEntity> teamObservableList = FXCollections.observableArrayList(teams);
        teamComboBox.setItems(teamObservableList);

        teamComboBox.setCellFactory(lv-> new ListCell<>() {
            @Override
            protected void updateItem(EquipaEntity item, boolean empty) {
                super.updateItem(item, empty);
                setText(empty ? "" : item.getNome());
            }
        });

        teamComboBox.setButtonCell(new ListCell<EquipaEntity>() {
            @Override
            protected void updateItem(EquipaEntity item, boolean empty) {
                super.updateItem(item, empty);
                setText(empty ? "" : item.getNome());
            }
        });
    }
<<<<<<< HEAD
=======

     */
>>>>>>> eb702fc9e8dcd3b9124f9cec0d55e14d654e8284
}
