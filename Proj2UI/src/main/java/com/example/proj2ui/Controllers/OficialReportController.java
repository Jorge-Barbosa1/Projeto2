package com.example.proj2ui.Controllers;

import com.example.proj2dal.BLL.GameBLL;
import com.example.proj2dal.BLL.RelatoryBLL;
import com.example.proj2dal.Entity.JogoEntity;
import com.example.proj2dal.Entity.RelatorioEntity;
import javafx.collections.FXCollections;
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

public class OficialReportController implements Initializable {
    @FXML
    Button goBackButton;
    @FXML
    Button sendOficialReportButton;
    @FXML
    ComboBox<JogoEntity> gamesIdComboBox;
    @FXML
    TextArea reportTextArea;

    @FXML
    void goBack(ActionEvent event){
        loadPage(goBackButton,"/com/example/proj2ui/CheckReports.fxml","Login");
    }

    @FXML
    void sendOfficialReport(ActionEvent event) {
        try {
            RelatorioEntity relatorio = new RelatorioEntity();
            relatorio.setIdJogo(gamesIdComboBox.getValue().getIdJogo());
            relatorio.setDescricao(reportTextArea.getText());
            relatorio.setIdRelatorio(RelatoryBLL.getNextAvailableId());
            RelatoryBLL.create(relatorio);
            showAlert(Alert.AlertType.INFORMATION, "Sucesso", "Relatorio submetido com sucesso.");
            loadPage(sendOficialReportButton, "/com/example/proj2ui/AdminMenu.fxml", "Menu");
        } catch (Exception e) {
            e.printStackTrace();
            showAlert(Alert.AlertType.ERROR, "Error", "Failed to submit the report.");
        }
    }

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

    private void loadGames(){
        List<JogoEntity> games = GameBLL.listGames();
        gamesIdComboBox.setItems(FXCollections.observableArrayList(games));
        gamesIdComboBox.setCellFactory(lv -> new ListCell<JogoEntity>(){
            @Override
            protected void updateItem(JogoEntity game, boolean empty){
                super.updateItem(game, empty);
                setText(empty ? "" : String.valueOf(game.getIdJogo()));
            }
        });
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        loadGames();

    }
}
