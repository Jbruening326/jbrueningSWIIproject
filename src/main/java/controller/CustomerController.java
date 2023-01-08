package controller;

import helper.ControllerHelper;
import javafx.event.ActionEvent;
import javafx.scene.control.*;

import java.io.IOException;

public class CustomerController {
    public Button saveButton;
    public Button cancelButton;
    public Label messageLabel;
    public TextField customerIdTextField;
    public TextField firstNameTextField;
    public TextField LastNameTextField;
    public ComboBox countryComboBox;
    public ComboBox firstLevelComboBox;
    public TextField addressTextField;
    public TextField postTextField;
    public TextField phoneTextField;
    public TableView customerTableView;
    public Button deleteButton;
    public RadioButton addRadioButton;
    public RadioButton updateRadioButton;

    public void onCountryComboSelection(ActionEvent actionEvent) {
    }

    public void onDeleteButtonClick(ActionEvent actionEvent) {
    }

    public void onAddRadioButtonClick(ActionEvent actionEvent) {
    }

    public void onUpdateRadioButtonClick(ActionEvent actionEvent) {
    }

    public void onSaveButtonClick(ActionEvent actionEvent) throws IOException {
        ControllerHelper.changeScene(actionEvent, "mainWindow.fxml", 964, 570);
    }

    public void onCancelButtonClick(ActionEvent actionEvent) throws IOException {
        ControllerHelper.changeScene(actionEvent, "mainWindow.fxml", 964, 570);
    }
}
