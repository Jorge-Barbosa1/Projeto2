module com.example.proj2ui {
    requires javafx.controls;
    requires javafx.fxml;
    requires Proj2Dal;
    requires org.controlsfx.controls;

    opens com.example.proj2ui to javafx.fxml;
    exports com.example.proj2ui;
    exports com.example.proj2ui.Controllers;
    opens com.example.proj2ui.Controllers to javafx.fxml;
}