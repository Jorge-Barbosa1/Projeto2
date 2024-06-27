package com.example.proj2ui;

<<<<<<< HEAD
=======
import com.example.proj2dal.BLL.AdministratorBLL;
import com.example.proj2dal.BLL.UserBLL;
import com.example.proj2dal.Entity.UtilizadorEntity;
import com.example.proj2ui.Managers.UserManager;
>>>>>>> eb702fc9e8dcd3b9124f9cec0d55e14d654e8284
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
<<<<<<< HEAD
=======
import java.math.BigInteger;
>>>>>>> eb702fc9e8dcd3b9124f9cec0d55e14d654e8284

public class   Main extends Application {
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

        launch();
    }
}