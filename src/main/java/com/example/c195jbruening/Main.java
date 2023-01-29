package com.example.c195jbruening;


import helper.JDBC;
import helper.Utilities;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Locale;
import java.util.ResourceBundle;




//TODO
//Reports Controller
//Complete the time overlap
//Add the Lamdas
//JavaDoc
//Record Login Avtivity
//README.txt
//proofread. remove any funky statements and unused imports
//check everything in the VM


public class Main extends Application implements Initializable {
    @Override
    public void start(Stage stage) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("logIn.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 300);
        stage.setScene(scene);
        stage.show();
    }

    public void initialize(URL url, ResourceBundle resourceBundle){
        Utilities.getLocale().getLanguage();
    }

    public static void main(String[] args) {

        JDBC.openConnection();


        //Locale france = new Locale("fr", "CA");
        //Locale.setDefault(france);

        //ZoneId.getAvailableZoneIds().stream().sorted().forEach(System.out::println);



        launch();

        //System.out.println(Utilities.toTargetTime(LocalDateTime.now()));
        //Instantiate french locale for checking language criteria

        /*Locale france = new Locale("fr", "CA");
        ResourceBundle fr = ResourceBundle.getBundle("Languages", france);


        if(Locale.getDefault().getLanguage().equals("fr")){
           System.out.println(france.getLanguage());
           System.out.println(fr.getString("hello") + " " + fr.getString("world"));
        }
        else{
            System.out.println("Language not supported");
        }*/




        JDBC.closeConnection();
    }
}