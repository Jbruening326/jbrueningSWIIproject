package controller;


import helper.ControllerHelper;
import javafx.event.ActionEvent;
import javafx.scene.control.*;

import java.io.IOException;

public class MainWindowController {
    public RadioButton weekViewRadio;
    public RadioButton monthViewRadioButton;
    public RadioButton allAppointmentsRadioButton;
    public Button addButton;
    public Button updateButton;
    public Button cancelButton;
    public Button customersButton;
    public Label messageLabel;
    public Button exitButton;

    public void onWeekViewRadioButton(ActionEvent actionEvent) {
    }

    public void onMonthViewRadioButton(ActionEvent actionEvent) {
    }

    public void onAllAppointmentsRadioButton(ActionEvent actionEvent) {
    }


    public void onAddButtonClick(ActionEvent actionEvent) throws IOException {
        ControllerHelper.changeScene(actionEvent, "appointment.fxml", 732, 515);
    }

    public void onUpdateButtonClick(ActionEvent actionEvent) throws IOException {
        ControllerHelper.changeScene(actionEvent, "appointment.fxml", 732, 515);
    }

    public void onCancelButtonClick(ActionEvent actionEvent) {
    }

    public void onCustomersButtonClick(ActionEvent actionEvent) throws IOException {
        ControllerHelper.changeScene(actionEvent, "customer.fxml", 919, 623);
    }

    public void onExitButtonClick(ActionEvent actionEvent) {System.exit(0);}

    public void onReportsButtonClick(ActionEvent actionEvent) throws IOException {
        ControllerHelper.changeScene(actionEvent, "reports.fxml", 696, 427);
    }
}
