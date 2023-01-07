package com.example.c195jbruening;

import helper.JDBC;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;



//TODO
//Add controller functionality to go to all screens
//Build models, DAOs and interface
//Also need to complete the UML Diagram


public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("logIn.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 300);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {

        JDBC.openConnection();

        launch();

        JDBC.closeConnection();
    }
}