package com.example.c195jbruening;

import dao.AppointmentDao;
import dao.ContactDao;
import dao.CountryDao;
import helper.JDBC;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.Appointment;
import model.Country;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDateTime;


//TODO
//Currently building DAO methods need: CustomerDAO, FirstLevelDivisionDao, UserDao. Do JavaDoc while building
//Completed AppointmentDAO, ContactDao, CountryDao with javadocs.
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


        JDBC.closeConnection();
    }
}