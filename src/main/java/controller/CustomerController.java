package controller;

import helper.ControllerHelper;
import javafx.event.ActionEvent;
import javafx.scene.control.*;

import java.io.IOException;

public class CustomerController {
    public Label messageLabel;
    public Button saveButton;
    public Button cancelButton;
    public Button deleteButton;
    public RadioButton addRadioButton;
    public RadioButton updateRadioButton;
    public TextField customerIdTextField;
    public TextField firstNameTextField;
    public TextField LastNameTextField;
    public TextField addressTextField;
    public TextField postTextField;
    public TextField phoneTextField;
    public ComboBox countryComboBox;
    public ComboBox firstLevelComboBox;
    public TableView customerTableView;
    public TableColumn customerIdCol;
    public TableColumn nameCol;
    public TableColumn AddressCol;
    public TableColumn postalCol;
    public TableColumn phoneCol;
    public TableColumn countryCol;
    public TableColumn firstLevelCol;

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
