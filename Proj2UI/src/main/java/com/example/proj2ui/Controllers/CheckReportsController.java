package com.example.proj2ui.Controllers;

import com.example.proj2dal.BLL.RelatoryBLL;
import com.example.proj2dal.Entity.RelatorioEntity;
import com.example.proj2ui.DTO.SessionInfo;
import javafx.collections.FXCollections;
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

public class CheckReportsController implements Initializable {
    @FXML
    TableView<RelatorioEntity> reportsTable;
    @FXML
    TableColumn<RelatorioEntity, Integer> idGameCol;
    @FXML
    TableColumn<RelatorioEntity, String> reportCol;
    @FXML
    Button goBackButton;
    @FXML
    Button resumeButton;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        idGameCol.setCellValueFactory(new PropertyValueFactory<>("idJogo"));
        reportCol.setCellValueFactory(new PropertyValueFactory<>("descricao"));

        List<RelatorioEntity> reports = RelatoryBLL.listRelatory();
        reportsTable.setItems(FXCollections.observableArrayList(reports));
    }

    @FXML
    void oficialReport(ActionEvent event){
        loadPage(resumeButton,"/com/example/proj2ui/OficialReport.fxml","Relatório Oficial");
    }
    @FXML
    void goBack(ActionEvent event){
        loadPage(goBackButton,"/com/example/proj2ui/AdminMenu.fxml","Login");
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

}
