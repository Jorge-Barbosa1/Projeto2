package com.example.proj2ui.Controllers;

<<<<<<< HEAD
import com.example.proj2dal.Entity.JogoEntity;
import com.example.proj2dal.BLL.CampBLL;
import com.example.proj2dal.BLL.GameBLL;
import com.example.proj2dal.BLL.RefTeamBLL;
import com.example.proj2dal.BLL.TeamBLL;
import com.example.proj2dal.Entity.ArbitragemEntity;
import com.example.proj2dal.Entity.CampoEntity;
import com.example.proj2dal.Entity.EquipaEntity;
import com.example.proj2ui.Managers.SessionInfo;
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
import java.math.BigInteger;
import java.net.URL;
import java.sql.Date;
import java.util.List;
import java.util.ResourceBundle;

import static com.example.proj2dal.BLL.GameBLL.getNextAvailableId;

public class CreateGameController implements Initializable {
    @FXML
    Button goBackButton;
    @FXML
    Button createButton;
    @FXML
    DatePicker datePicker;
    @FXML
    TextField timeTxtField;
    @FXML
    ComboBox<EquipaEntity> team1;
    @FXML
    ComboBox<EquipaEntity> team2;
    @FXML
    ComboBox<ArbitragemEntity> refTeam;
    @FXML
    ComboBox<CampoEntity> camp;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        loadTeams();
        loadRefTeams();
        loadCamps();
    }

    @FXML
    public void createGame(){
        String date = datePicker.getValue().toString();
        String time = timeTxtField.getText();
        EquipaEntity team1Entity = team1.getValue();
        EquipaEntity team2Entity = team2.getValue();
        ArbitragemEntity refTeamEntity = refTeam.getValue();
        CampoEntity campEntity = camp.getValue();
        if(date.isEmpty() || time.isEmpty() || team1Entity == null || team2Entity == null || refTeamEntity == null || campEntity == null){
            showAlert(Alert.AlertType.ERROR, "Erro", "Preencha todos os campos.");
            return;
        }
        //Criar o jogo
        com.example.proj2dal.Entity.JogoEntity game = new com.example.proj2dal.Entity.JogoEntity();

        game.setData(Date.valueOf(datePicker.getValue().toString()));
        game.setHora(time);
        game.setIdEquipa(team1Entity.getIdEquipa());
        game.setIdEquipa2(team2Entity.getIdEquipa());
        game.setIdArbitragem(refTeamEntity.getIdArbitragem());
        game.setIdCampo(campEntity.getIdCampo());
        game.setIdAdministrador(SessionInfo.getAdminId());
        BigInteger nextid = getNextAvailableId();

        game.setIdJogo(nextid);
        GameBLL.createGame(game);
        showAlert(Alert.AlertType.INFORMATION,"Sucesso", "Jogo criado com sucesso!");
    }

    private void loadCamps(){
        List<CampoEntity> camps = CampBLL.listCamp();
        ObservableList<CampoEntity> campObservableList = FXCollections.observableArrayList(camps);
        camp.setItems(campObservableList);
        camp.setCellFactory(lv-> new ListCell<>() {
            @Override
            protected void updateItem(CampoEntity item, boolean empty) {
                super.updateItem(item, empty);
                setText(empty ? "" : item.getNome());
            }
        });

        camp.setButtonCell(new ListCell<CampoEntity>() {
            @Override
            protected void updateItem(CampoEntity item, boolean empty) {
                super.updateItem(item, empty);
                setText(empty ? "" : item.getNome());
            }
        });
    }

    private void loadRefTeams() {
        List<ArbitragemEntity> refTeams = RefTeamBLL.listRefTeam(); // Asume que isso retorna uma List<ArbitragemEntity>
        ObservableList<ArbitragemEntity> refTeamObservableList = FXCollections.observableArrayList(refTeams);
        refTeam.setItems(refTeamObservableList);

        refTeam.setCellFactory(lv -> new ListCell<ArbitragemEntity>() {
            @Override
            protected void updateItem(ArbitragemEntity item, boolean empty) {
                super.updateItem(item, empty);
                setText(empty ? "" : String.valueOf(item.getIdArbitragem())); // Aparece o ID da arbitragem
            }
        });

        refTeam.setButtonCell(new ListCell<ArbitragemEntity>() {
            @Override
            protected void updateItem(ArbitragemEntity item, boolean empty) {
                super.updateItem(item, empty);
                setText(empty ? "" : String.valueOf(item.getIdArbitragem())); // Aparece o ID da arbitragem
            }
        });
    }
    private void loadTeams(){
        List<EquipaEntity> teams = TeamBLL.listTeams();
        ObservableList<EquipaEntity> teamObservableList = FXCollections.observableArrayList(teams);
        team1.setItems(teamObservableList);
        team2.setItems(teamObservableList);
        team1.setCellFactory(lv-> new ListCell<>() {
            @Override
            protected void updateItem(EquipaEntity item, boolean empty) {
                super.updateItem(item, empty);
                setText(empty ? "" : item.getNome());
            }
        });

        team1.setButtonCell(new ListCell<EquipaEntity>() {
            @Override
            protected void updateItem(EquipaEntity item, boolean empty) {
                super.updateItem(item, empty);
                setText(empty ? "" : item.getNome());
            }
        });
        team2.setCellFactory(lv-> new ListCell<>() {
            @Override
            protected void updateItem(EquipaEntity item, boolean empty) {
                super.updateItem(item, empty);
                setText(empty ? "" : item.getNome());
            }
        });

        team2.setButtonCell(new ListCell<EquipaEntity>() {
            @Override
            protected void updateItem(EquipaEntity item, boolean empty) {
                super.updateItem(item, empty);
                setText(empty ? "" : item.getNome());
            }
        });
    }

    @FXML
    void backPage(ActionEvent event){
        loadPage(goBackButton,"/com/example/proj2ui/AdminMenu.fxml","Login");
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
=======
public class CreateGameController {
>>>>>>> eb702fc9e8dcd3b9124f9cec0d55e14d654e8284
}
