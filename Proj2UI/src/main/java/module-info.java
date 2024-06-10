module com.example.proj2ui {
    requires javafx.controls;
    requires javafx.fxml;
    requires jakarta.persistence;
    requires org.hibernate.orm.core;
    requires org.controlsfx.controls;
    requires com.example.proj2dal;

    opens com.example.proj2ui to javafx.fxml;
    exports com.example.proj2ui;
    opens com.example.proj2ui.Controllers to javafx.fxml;
}