package controller;

import helper.ControllerHelper;
import javafx.event.ActionEvent;
import javafx.scene.control.*;

import java.io.IOException;

public class ReportsController {
    public ComboBox monthComboBox;
    public ComboBox typeComboBox;
    public ComboBox contactComboBox;
    public ComboBox countryComboBox;
    public Label messageLabel;
    public Button runButton;
    public Button cancelButton;
    public RadioButton appRadioButton;
    public ToggleGroup reportOptions;
    public RadioButton contactRadioButton;
    public RadioButton customerRadioButton;

    public void onRunButtonClick(ActionEvent actionEvent) throws IOException {
        ControllerHelper.changeScene(actionEvent, "result.fxml", 600, 400);
    }

    public void onCancelButtonClick(ActionEvent actionEvent) throws IOException {
        ControllerHelper.changeScene(actionEvent, "mainWindow.fxml", 964, 570);
    }

    public void onAppRadioButtonClick(ActionEvent actionEvent) {
    }

    public void onContactRadioButtonClick(ActionEvent actionEvent) {
    }

    public void onCustomerRadioButtonClick(ActionEvent actionEvent) {
    }
}
