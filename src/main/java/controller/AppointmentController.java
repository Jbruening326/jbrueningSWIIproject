package controller;

import helper.ControllerHelper;
import javafx.event.ActionEvent;
import javafx.scene.control.*;

import java.io.IOException;

public class AppointmentController {
    public Label messageLabel;
    public Button saveButton;
    public Button cancelButton;
    public ComboBox typeComboBox;
    public ComboBox contactComboBox;
    public TextField appIdTextField;
    public ChoiceBox locationComboBox;
    public TextField titleTextField;
    public TextField descTextField;
    public DatePicker datePicker;
    public ComboBox startTimeComboBox;
    public ComboBox endTimeComboBox;
    public ComboBox customerComboBox;
    public ComboBox userComboBox;


    public void onSaveButtonClick(ActionEvent actionEvent) throws IOException {
        ControllerHelper.changeScene(actionEvent, "mainWindow.fxml", 964, 570);
    }

    public void onCancelButtonClick(ActionEvent actionEvent) throws IOException {
        ControllerHelper.changeScene(actionEvent, "mainWindow.fxml", 964, 570);
    }

    public void onStartComboSelection(ActionEvent actionEvent) {
    }
}
