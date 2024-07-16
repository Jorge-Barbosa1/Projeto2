package com.example.proj2ui.Controllers;

import com.example.proj2dal.BLL.GameBLL;
import com.example.proj2dal.Entity.JogoEntity;
import com.example.proj2ui.DTO.GameInfo;
import javafx.collections.FXCollections;
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
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class UserMenuController implements Initializable {
    @FXML
    Button goBackButton;
    @FXML
    Button exitButton;
    @FXML
    TableView<GameInfo> gamesTable;
    @FXML
    private TableColumn<GameInfo, String> team1Column;
    @FXML
    private TableColumn<GameInfo, String> timeColumn;
    @FXML
    private TableColumn<GameInfo, String> team2Column;
    @FXML
    private TableColumn<GameInfo, String> fieldColumn;
    @FXML
    Button reportGameButton;
    @FXML
    Button viewFavoritesButton;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        team1Column.setCellValueFactory(new PropertyValueFactory<>("team1Name"));
        timeColumn.setCellValueFactory(new PropertyValueFactory<>("time"));
        team2Column.setCellValueFactory(new PropertyValueFactory<>("team2Name"));
        fieldColumn.setCellValueFactory(new PropertyValueFactory<>("fieldName"));

        gamesTable.setItems(getGames());
        gamesTable.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                System.out.println("Selected Game: " + newSelection.getTeam1Name() + " " + newSelection.getTime() + " " + newSelection.getTeam2Name() + " " + newSelection.getFieldName());
                GameInfo selectedGame = gamesTable.getSelectionModel().getSelectedItem();
            }
        });
    }

    @FXML
    private void handleDescribeGame(ActionEvent event){
        GameInfo selectedGame = gamesTable.getSelectionModel().getSelectedItem();
        if (selectedGame == null) {
            showAlert(Alert.AlertType.ERROR, "Erro", "Selecione um jogo.");
            return;
        }
        //Load Page to Describe Game and pass the selected game
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/proj2ui/ReportGame.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            ReportGameController controller = fxmlLoader.getController();
            controller.initData(selectedGame);
            Stage stage = (Stage) reportGameButton.getScene().getWindow();
            stage.setScene(scene);
            stage.setTitle("Descrever Jogo");
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
            showAlert(Alert.AlertType.ERROR, "Error", "Failed to load the page.");
        }

    }

    private ObservableList<GameInfo> getGames() {
        List<JogoEntity> games = GameBLL.listGames();
        ObservableList<GameInfo> gameInfoList = FXCollections.observableArrayList();

        for (JogoEntity game : games) {
            String team1Name = game.getEquipaByIdEquipa() != null ? game.getEquipaByIdEquipa().getNome() : "Unknown";
            String team2Name = game.getEquipaByIdEquipa2() != null ? game.getEquipaByIdEquipa2().getNome() : "Unknown";
            String fieldName = game.getCampoByIdCampo() != null ? game.getCampoByIdCampo().getNome() : "Unknown";

            GameInfo gameInfo = new GameInfo(
                    game.getIdJogo(),
                    team1Name,
                    game.getHora(),
                    team2Name,
                    fieldName
            );
            gameInfoList.add(gameInfo);
        }
        return gameInfoList;
    }


    @FXML
    void viewFavorites(ActionEvent event){
        loadPage(viewFavoritesButton,"/com/example/proj2ui/FavoritesPage.fxml","Favoritos");
    }

    @FXML
    void backPage(ActionEvent event){
        loadPage(goBackButton,"/com/example/proj2ui/LoginPage.fxml","Login");
    }
    //Função para trocar de páginas
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
    @FXML
    void exitApp(ActionEvent event){
        Stage stage = (Stage) exitButton.getScene().getWindow();
        stage.close();
    }
}
