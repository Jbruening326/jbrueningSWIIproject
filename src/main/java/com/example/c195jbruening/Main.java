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
//Do JavaDoc while building
//Build Helper Classes as needed?
//Stuck: LoginController Adding Language resource bundle
//Stuck: MainWindowController adding, Date from LocalDateTime, Adding Time from Local Date time, Adding Contact Name from an Appointment object in the table view

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



        launch();
        //Instantiate french locale for checking language criteria
        //Locale french = new Locale("fr", "CA");
        //ResourceBundle fr = ResourceBundle.getBundle("com.example.c195jbruening.LanguageBundle_fr_CA.properties", french);
        //System.out.println(french.getLanguage());



        JDBC.closeConnection();
    }
}