package com.example.c195jbruening;


import helper.JDBC;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Locale;
import java.util.ResourceBundle;


//TODO
//Continue to build DAOs with needed additional methods
//Do JavaDoc while building
//Completed All Dao classes
//Build Helper Classes as needed?

//Complete Section A(1,2,3a,3b,3c,3d,3e,3f)
//Complete Section B(lamda)
//Complete Section C(record login activity)
//Complete Section D(Javadoc)
//Complete Section E(README.txt)
//Complete Section F(proofread)
//Remove the throw statement in the Main.java after done testing


public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("logIn.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 300);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) throws SQLException{

        JDBC.openConnection();

        //launch();
        ResourceBundle fr = ResourceBundle.getBundle(
                "helper/LanguageBundle_fr_FR.properties", Locale.getDefault());
        if (Locale.getDefault().getLanguage().equals("fr"))
            System.out.println(fr.getString("hello") + " " + fr.getString("world"));


        JDBC.closeConnection();
    }
}