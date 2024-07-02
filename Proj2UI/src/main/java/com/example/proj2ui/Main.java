package com.example.proj2ui;
import com.example.proj2dal.BLL.DBConnection;
import com.example.proj2dal.BLL.RelatoryBLL;
import com.example.proj2dal.Entity.RelatorioEntity;
import jakarta.persistence.EntityManager;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import java.math.BigInteger;


public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("LoginPage.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 400 , 300);
        stage.setTitle("Login");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        //ADMIN PRINCIPAL username:admin pass: admin

        /*Teste de inserção de relatório
        RelatorioEntity relatorio = new RelatorioEntity();
        relatorio.setIdJogo(BigInteger.valueOf(1));
        relatorio.setDescricao("Teste");
        relatorio.setIdRelatorio(BigInteger.valueOf(1));
        RelatoryBLL.create(relatorio);*/
        launch();
    }
}