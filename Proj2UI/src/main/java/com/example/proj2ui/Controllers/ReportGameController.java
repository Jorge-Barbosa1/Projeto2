package com.example.proj2ui.Controllers;

import com.example.proj2dal.BLL.RelatoryBLL;
import com.example.proj2dal.Entity.RelatorioEntity;
import com.example.proj2ui.DTO.GameInfo;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import java.util.logging.Logger;
import java.io.IOException;

public class ReportGameController {
    private static final Logger logger = Logger.getLogger(ReportGameController.class.getName());
    private GameInfo game;
    @FXML
    TextArea reportTxtArea;
    @FXML
    Button submitButton;
    @FXML
    Button goBackButton;

    public void initData(GameInfo game){
        this.game = game;
    }
    @FXML
    void submitReport(ActionEvent event){
        try {
            RelatorioEntity relatorio = new RelatorioEntity();
            relatorio.setIdJogo(game.getIdGame());
            relatorio.setDescricao(reportTxtArea.getText());
            relatorio.setIdRelatorio(RelatoryBLL.getNextAvailableId());
            logger.info("Submitting report with ID: " + relatorio.getIdRelatorio());
            RelatoryBLL.create(relatorio);
            showAlert(Alert.AlertType.INFORMATION, "Sucess", "Report submitted successfully.");
            loadPage(submitButton, "/com/example/proj2ui/UserMenu.fxml", "Menu");
        } catch (Exception e) {
            e.printStackTrace();
            showAlert(Alert.AlertType.ERROR, "Error", "Failed to submit the report.");
        }
    }

    @FXML
    void backPage(ActionEvent event){
        loadPage(goBackButton,"/com/example/proj2ui/UserMenu.fxml","Login");
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



}
