package com.example.proj2ui.Controllers;

import com.example.proj2dal.Entity.ArbitragemEntity;
import com.example.proj2dal.BLL.RefTeamBLL;
import com.example.proj2dal.Entity.ArbitroEntity;
import com.example.proj2dal.BLL.RefereeBLL;
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

public class CreateRefTeamController {
    @FXML
    Button goBackButton;
    @FXML
    Button createButton;
    @FXML
    ComboBox<ArbitroEntity> ref1ComboBox;
    @FXML
    ComboBox<ArbitroEntity> ref2ComboBox;
    @FXML
    ComboBox<ArbitroEntity> ref3ComboBox;

    @FXML
    public void initialize() {
        loadReferees();
    }

    @FXML
    void createRefTeam(ActionEvent event) {
        ArbitroEntity ref1 = ref1ComboBox.getValue();
        ArbitroEntity ref2 = ref2ComboBox.getValue();
        ArbitroEntity ref3 = ref3ComboBox.getValue();


        // Aqui você pode verificar se algum dos árbitros é nulo
        if (ref1 == null || ref2 == null || ref3 == null) {
            showAlert(Alert.AlertType.ERROR, "Erro", "Selecione 3 árbitros.");
            return;
        }

        // Verificar se algum ID é inválido ou duplicado
        if (ref1.getIdArbitro() == ref2.getIdArbitro() || ref1.getIdArbitro() == ref3.getIdArbitro() || ref2.getIdArbitro() == ref3.getIdArbitro()) {
            showAlert(Alert.AlertType.ERROR, "Erro", "Selecione 3 árbitros diferentes.");
            return;
        }

        RefTeamBLL.createRefTeam(ref1, ref2, ref3);
        showAlert(Alert.AlertType.INFORMATION, "Sucesso", "Equipa de Arbitragem criada com sucesso.");

    }

    private void loadReferees() {
        List<ArbitroEntity> referees = RefereeBLL.listRefs();
        ObservableList<ArbitroEntity> refereeObservableList = FXCollections.observableArrayList(referees);
        ref1ComboBox.setItems(refereeObservableList);
        ref2ComboBox.setItems(refereeObservableList);
        ref3ComboBox.setItems(refereeObservableList);

        // Configuração do visual dos ComboBoxes
        setComboBoxCellFactory(ref1ComboBox);
        setComboBoxCellFactory(ref2ComboBox);
        setComboBoxCellFactory(ref3ComboBox);
    }

    private void setComboBoxCellFactory(ComboBox<ArbitroEntity> comboBox) {
        comboBox.setCellFactory(param -> new ListCell<ArbitroEntity>() {
            @Override
            protected void updateItem(ArbitroEntity item, boolean empty) {
                super.updateItem(item, empty);
                setText(empty ? "" : item.getNome());
            }
        });

        comboBox.setButtonCell(new ListCell<ArbitroEntity>() {
            @Override
            protected void updateItem(ArbitroEntity item, boolean empty) {
                super.updateItem(item, empty);
                setText(empty ? "" : item.getNome());
            }
        });
    }

    @FXML
    void backPage(ActionEvent event) {
        loadPage(goBackButton, "/com/example/proj2ui/AdminMenu.fxml", "Login");
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

    private void showAlert(Alert.AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }


}

