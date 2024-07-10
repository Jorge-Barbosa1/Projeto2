package com.example.proj2ui.Controllers;

import com.example.proj2dal.BLL.FavoritesBLL;
import com.example.proj2dal.Entity.FavoritosEntity;
import com.example.proj2ui.DTO.SessionInfo;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.collections.FXCollections;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;


public class FavoritesPageController implements Initializable {
    @FXML
    public Button addFavButton;
    private Integer userId;
    @FXML
    Button goBackButton;
    @FXML
    TableView<FavoritosEntity> favoritesTableView;
    @FXML
    TableColumn<FavoritosEntity, String> teamColumn;
    @FXML
    TableColumn<FavoritosEntity, String> playerColumn;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        userId = SessionInfo.getUserId();  // Ensure this correctly fetches the current user's ID

        teamColumn.setCellValueFactory(new PropertyValueFactory<>("equipa"));
        playerColumn.setCellValueFactory(new PropertyValueFactory<>("jogadores"));

        List<FavoritosEntity> favoritesList = FavoritesBLL.listFavsByUser(userId);
        ObservableList<FavoritosEntity> observableFavoritesList = FXCollections.observableArrayList(favoritesList);
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
