package com.example.proj2ui.Controllers;

import com.example.proj2dal.BLL.FavoritesBLL;
import com.example.proj2dal.BLL.TeamBLL;
import com.example.proj2dal.Entity.EquipaEntity;
import com.example.proj2dal.Entity.FavoritosEntity;
import com.example.proj2dal.Entity.JogadorEntity;
import com.example.proj2ui.DTO.SessionInfo;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListCell;
import javafx.stage.Stage;

import java.io.IOException;
import java.math.BigInteger;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class AddFavoriteController implements Initializable {
    @FXML
    Button goBackButton;
    @FXML
    ComboBox<EquipaEntity> teamsBox;
    @FXML
    ComboBox<JogadorEntity> playersBox;
    @FXML
    Button addButton;
    private Integer userId;


    public void initialize(URL url, ResourceBundle resourceBundle) {
        loadTeams();
        userId = SessionInfo.getUserId();
        teamsBox.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            loadPlayersBasedOnTeam();
        });
    }

    public void addFavorite() {
        try {
            FavoritosEntity favorite = new FavoritosEntity();
            favorite.setEquipa(String.valueOf(teamsBox.getSelectionModel().getSelectedItem().getNome()));
            favorite.setJogadores(String.valueOf(playersBox.getSelectionModel().getSelectedItem().getNome()));
            favorite.setIdFavoritos(BigInteger.valueOf(FavoritesBLL.getNextAvailableId()));
            favorite.setUserId(userId);

            FavoritesBLL.createFavorite(favorite);
            showAlert(Alert.AlertType.INFORMATION, "Success", "Sucesso ao adicionar favorito!");
        } catch (Exception e) {
            showAlert(Alert.AlertType.ERROR, "Error", "Erro ao adicionar favorito: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private void loadTeams() {
        Task<List<EquipaEntity>> loadTeamsTask = new Task<>() {
            @Override
            protected List<EquipaEntity> call() throws Exception {
                return TeamBLL.listTeams();
            }

            @Override
            protected void succeeded() {
                ObservableList<EquipaEntity> teamObservableList = FXCollections.observableArrayList(getValue());
                teamsBox.setItems(teamObservableList);
                teamsBox.setCellFactory(lv -> new ListCell<>() {
                    @Override
                    protected void updateItem(EquipaEntity item, boolean empty) {
                        super.updateItem(item, empty);
                        setText(empty ? "" : item.getNome());
                    }
                });

                teamsBox.setButtonCell(new ListCell<>() {
                    @Override
                    protected void updateItem(EquipaEntity item, boolean empty) {
                        super.updateItem(item, empty);
                        setText(empty ? "" : item.getNome());
                    }
                });
            }

            @Override
            protected void failed() {
                super.failed();
                showAlert(Alert.AlertType.ERROR, "Error", "Erro ao loadar as equipas.");
                getException().printStackTrace();  // Isso imprimirá o stack trace no console.
            }
        };

        new Thread(loadTeamsTask).start();
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
            showAlert(Alert.AlertType.ERROR, "Error", "Erro ao loadar as equipas.");
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
