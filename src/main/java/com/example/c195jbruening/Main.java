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
import java.time.ZoneId;
import java.util.Locale;
import java.util.ResourceBundle;




//TODO
//Finishing AddAppointment Controller, and UpdateAppointment Controller. Just need to JavaDoc
//Next work on Customers controller
//Login controller complete. still need to check a change in ZoneID.

//Do JavaDoc while building
//Build Helper Classes as needed?

//Complete Section A(1,2,3a,3b,3c,3d,3e,3f)
    //COMPLETE A.1.1 accepts username and password and provides an appropriate error message
    //A.1.2 determines the user's location and displays it in a label on the log-in form
    //A.1.3 displays the log-in form in English or French based on the user's computer language settings to translate
    // all the text, labels, buttons, and errors on the form
    //A.1.4  automatically translates error control messages into English or French based on the user's computer
    // language setting


//Complete Section B(lamda)
//Complete Section C(record login activity)
//Complete Section D(Javadoc)
//Complete Section E(README.txt)
//Complete Section F(proofread)
//Remove the throw statement in the Main.java after done testing


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
        System.out.println(Utilities.getAppointmentTimes());
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