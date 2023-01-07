module com.example.c195jbruening {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.c195jbruening to javafx.fxml;
    exports com.example.c195jbruening;
    exports controller;
    opens controller to javafx.fxml;
}