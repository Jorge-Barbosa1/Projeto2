package com.example.proj2ui.Controllers;

import com.example.proj2dal.BLL.TeamBLL;
import com.example.proj2dal.Entity.EquipaEntity;
import com.example.proj2dal.Entity.JogadorEntity;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListCell;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;

public class AddFavoriteController {
    @FXML
    Button goBackButton;
    @FXML
    ComboBox<EquipaEntity> teamsBox;
    @FXML
    ComboBox<JogadorEntity> playersBox;

    public void initialize() {
        loadTeams();
        teamsBox.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            loadPlayersBasedOnTeam();
        });
    }

    private void loadTeams() {
        List<EquipaEntity> teams = TeamBLL.listTeams();
        ObservableList<EquipaEntity> teamObservableList = FXCollections.observableArrayList(teams);
        teamsBox.setItems(teamObservableList);

        teamsBox.setCellFactory(lv-> new ListCell<>() {
            @Override
            protected void updateItem(EquipaEntity item, boolean empty) {
                super.updateItem(item, empty);
                setText(empty ? "" : item.getNome());
            }
        });

        teamsBox.setButtonCell(new ListCell<EquipaEntity>() {
            @Override
            protected void updateItem(EquipaEntity item, boolean empty) {
                super.updateItem(item, empty);
                setText(empty ? "" : item.getNome());
            }
        });
    }

    private void loadPlayersBasedOnTeam() {
        EquipaEntity selectedTeam = teamsBox.getSelectionModel().getSelectedItem();
        if(selectedTeam != null){
            List<JogadorEntity> players = TeamBLL.listPlayersByTeam(selectedTeam.getIdEquipa());
            ObservableList<JogadorEntity> playerObservableList = FXCollections.observableArrayList(players);
            playersBox.setItems(playerObservableList);

            playersBox.setCellFactory(lv-> new ListCell<>() {
                @Override
                protected void updateItem(JogadorEntity item, boolean empty) {
                    super.updateItem(item, empty);
                    setText(empty ? "" : item.getNome());
                }
            });

            playersBox.setButtonCell(new ListCell<JogadorEntity>() {
                @Override
                protected void updateItem(JogadorEntity item, boolean empty) {
                    super.updateItem(item, empty);
                    setText(empty ? "" : item.getNome());
                }
            });
        }else {
            playersBox.setItems(FXCollections.observableArrayList());
        }
    }


    @FXML
    void goBackPage(ActionEvent event){
        loadPage(goBackButton,"/com/example/proj2ui/FavoritesPage.fxml","Login");
    }
    private void loadPage(Button button, String fxmlPath, String title) {
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
