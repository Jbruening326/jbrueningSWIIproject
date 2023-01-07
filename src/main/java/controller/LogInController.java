package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class LogInController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    public void onUserNameText(ActionEvent actionEvent) {
    }

    public void onPasswordText(ActionEvent actionEvent) {
    }

    public void onLoginClick(ActionEvent actionEvent) {
    }

    public void onExtiButtonClick(ActionEvent actionEvent) {
    }
}