package controller;

import helper.ControllerHelper;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.io.IOException;

public class LogInController {


    public void onUserNameText(ActionEvent actionEvent) {
    }

    public void onPasswordText(ActionEvent actionEvent) {
    }

    public void onLoginClick(ActionEvent actionEvent) throws IOException {

        ControllerHelper.changeScene(actionEvent, "mainWindow.fxml", 964, 570);
    }

    public void onExitButtonClick(ActionEvent actionEvent) {System.exit(0);}
}