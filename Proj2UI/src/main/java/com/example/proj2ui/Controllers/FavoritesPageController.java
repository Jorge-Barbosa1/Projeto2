package com.example.proj2ui.Controllers;

import com.example.proj2dal.BLL.FavoritesBLL;
import com.example.proj2dal.Entity.FavoritosEntity;
import com.example.proj2ui.DTO.SessionInfo;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.collections.FXCollections;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;


public class FavoritesPageController {
    @FXML
    public Button addFavButton;
    private Integer userId;
    @FXML
    Button goBackButton;
    @FXML
    TableView<FavoritesBLL> favoritesTableView;
    @FXML
    TableColumn<FavoritesBLL, String> teamColumn;
    @FXML
    TableColumn<FavoritesBLL, String> playerColumn;

    public void initialize() {
        SessionInfo sessionInfo = new SessionInfo();
        userId = sessionInfo.getUserId();  // Aqui deve ser sessionInfo em vez de SessionInfo

        teamColumn.setCellValueFactory(new PropertyValueFactory<>("team"));
        playerColumn.setCellValueFactory(new PropertyValueFactory<>("player"));

        List<FavoritosEntity> favoritesList = FavoritesBLL.listFavsByUser(userId);
        ObservableList<FavoritesBLL> observableFavoritesList = FXCollections.observableArrayList();
        favoritesTableView.setItems(observableFavoritesList);
    }

    @FXML
    void goToAddFavPage(ActionEvent event){
        loadPage(addFavButton,"/com/example/proj2ui/AddFavorite.fxml","Add Favorite");
    }
    @FXML
    void goBackPage(ActionEvent event){
        loadPage(goBackButton,"/com/example/proj2ui/UserMenu.fxml","Login");
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
