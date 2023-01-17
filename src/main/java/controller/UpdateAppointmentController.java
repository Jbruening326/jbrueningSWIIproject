package controller;

import helper.ControllerHelper;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import model.Appointment;
import model.Contact;
import model.Customer;
import model.User;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;

public class UpdateAppointmentController {
    public Label messageLabel;
    public Button saveButton;
    public Button cancelButton;
    public ComboBox<String> typeComboBox;
    public ComboBox<Contact> contactComboBox;
    public TextField appIdTextField;
    public TextField titleTextField;
    public TextField descTextField;
    public DatePicker datePicker;
    public ComboBox<LocalTime> startTimeComboBox;
    public ComboBox<LocalTime> endTimeComboBox;
    public ComboBox<Customer> customerComboBox;
    public ComboBox<User> userComboBox;
    public ComboBox<String> locationComboBox;


    public void sendAppointment(Appointment appointment) {
        appIdTextField.setText(String.valueOf(appointment.getAppointmentId()));
        titleTextField.setText(appointment.getTitle());
        descTextField.setText(appointment.getDescription());
        datePicker.setValue(appointment.getStartDateTime().toLocalDate());
        startTimeComboBox.setValue(appointment.getStartDateTime().toLocalTime());
        endTimeComboBox.setValue(appointment.getEndDateTime().toLocalTime());
        locationComboBox.setValue(appointment.getLocation());
        //contactComboBox.setValue(appointment.getContactId());
        typeComboBox.setValue(appointment.getType());
        //customerComboBox.setValue(appointment.getCustomerId());
        //userComboBox.setValue(appointment.getUserId());



    }
    public void onSaveButtonClick(ActionEvent actionEvent) {
    }

    public void onCancelButtonClick(ActionEvent actionEvent) throws IOException {
        ControllerHelper.changeScene(actionEvent, "mainWindow.fxml", 964, 570);
    }
}
