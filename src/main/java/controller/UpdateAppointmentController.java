package controller;

import dao.AppointmentDao;
import dao.ContactDao;
import dao.CustomerDao;
import dao.UserDao;
import helper.ControllerHelper;
import helper.Utilities;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import model.Appointment;
import model.Contact;
import model.Customer;
import model.User;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ResourceBundle;

public class UpdateAppointmentController implements Initializable {
    public Label messageLabel;
    public Button saveButton;
    public Button cancelButton;


    public TextField appIdTextField;
    public TextField titleTextField;
    public TextField descTextField;
    public DatePicker datePicker;

    public ComboBox<String> typeComboBox;
    public ComboBox<Contact> contactComboBox;
    public ComboBox<LocalTime> startTimeComboBox;
    public ComboBox<LocalTime> endTimeComboBox;
    public ComboBox<Customer> customerComboBox;
    public ComboBox<User> userComboBox;
    public ComboBox<String> locationComboBox;


    public void initialize(URL url, ResourceBundle resourceBundle)  {
        //Prefill location combobox list
        ObservableList<String> locations = locationComboBox.getItems();
        locations.add("Coffee Shop");
        locations.add("Main Office");
        locations.add("Video Call");
        locations.add("Project site");

        //Prefill type combobox list
        ObservableList<String> types = typeComboBox.getItems();
        types.add("Planning Session");
        types.add("De-Briefing");
        types.add("Building");
        types.add("Execution");
        types.add("Project Close");

        //Prefill Contact ComboBox
        contactComboBox.getItems();
        try {
            contactComboBox.setItems(ContactDao.getAll());
        }
        catch (SQLException e) {
            messageLabel.setText("There are currently no contacts or something else went wrong");
            throw new RuntimeException(e);
        }

        //Prefill Customer ComboBox
        customerComboBox.getItems();
        try {
            customerComboBox.setItems(CustomerDao.getAll());
        }
        catch (SQLException e) {
            messageLabel.setText("There are currently no customers or something else went wrong");
            throw new RuntimeException(e);
        }

        //Prefill User ComboBox
        userComboBox.getItems();
        try {
            userComboBox.setItems(UserDao.getAll());
        }
        catch (SQLException e) {
            messageLabel.setText("something else went wrong");
            throw new RuntimeException(e);
        }

        //Prefill startTimeComboBox
        startTimeComboBox.getItems();
        startTimeComboBox.setItems(Utilities.getAppointmentTimes());
        //Prefill endTimeComboBox
        endTimeComboBox.getItems();
        endTimeComboBox.setItems(Utilities.getAppointmentTimes());
    }

    public void sendAppointment(Appointment appointment) throws SQLException {
        appIdTextField.setText(String.valueOf(appointment.getAppointmentId()));
        titleTextField.setText(appointment.getTitle());
        descTextField.setText(appointment.getDescription());
        datePicker.setValue(appointment.getStartDateTime().toLocalDate());
        startTimeComboBox.setValue(appointment.getStartDateTime().toLocalTime());
        endTimeComboBox.setValue(appointment.getEndDateTime().toLocalTime());
        locationComboBox.setValue(appointment.getLocation());
        contactComboBox.setValue(appointment.getContact());
        typeComboBox.setValue(appointment.getType());
        customerComboBox.setValue(appointment.getCustomer());
        userComboBox.setValue(appointment.getUser());


    }
    public void onSaveButtonClick(ActionEvent actionEvent) {
        try {
            int appointmentId = Integer.parseInt(appIdTextField.getText());
            String title = titleTextField.getText();
            String description = descTextField.getText();
            String location = String.valueOf(locationComboBox.getValue());
            int contact = contactComboBox.getValue().getContactID();
            String type = String.valueOf(typeComboBox.getValue());
            LocalDate date = datePicker.getValue();
            LocalTime start = startTimeComboBox.getValue();
            LocalTime end = endTimeComboBox.getValue();
            int customer = customerComboBox.getValue().getCustomerId();
            int user = userComboBox.getValue().getUserId();

            LocalDateTime startDateTime = LocalDateTime.of(date, start);
            LocalDateTime endDateTime = LocalDateTime.of(date, end);

            System.out.println(title + "|" + description + "|" + location + "|" + contact + "|" + type + "|" + date + "|" + start + "|" + end + "|" + customer + "|" + user);

            if (title.isEmpty() || title.isBlank() || description.isBlank() || description.isEmpty() ||
                    locationComboBox.getValue() == null || typeComboBox.getValue() == null ||
                    startTimeComboBox.getValue() == null || endTimeComboBox.getValue() == null){
                messageLabel.setText("Please make all field are completed");
            }
            else if(start.isAfter(end)){
                messageLabel.setText("'End Time' cannot be before 'Start Time'");
            }
            else if(date.isBefore(LocalDate.now())){
                messageLabel.setText("Cannot schedule appointment in the past");
            }
            else if(Utilities.toTargetTime(startDateTime).isBefore(LocalDateTime.of(date, LocalTime.of(8, 00)))){
                messageLabel.setText("Start time not within business hours of 8 am - 10 pm EST");
            }
            else if (Utilities.toTargetTime(endDateTime).isAfter(LocalDateTime.of(date, LocalTime.of(22, 00)))) {
                messageLabel.setText(("End time not within business hours of 8 am - 10 pm EST"));
            }
            else {
                Appointment appointment = new Appointment(appointmentId, title, description, location, type, startDateTime, endDateTime, customer, user, contact);
                AppointmentDao.update(appointment);
                ControllerHelper.changeScene(actionEvent, "mainWindow.fxml", 964, 570);
            }
        }
        catch(Exception e){
            messageLabel.setText("All fields must be completed and text fields cannot exceed 50 characters");
        }
    }

    public void onCancelButtonClick(ActionEvent actionEvent) throws IOException {
        ControllerHelper.changeScene(actionEvent, "mainWindow.fxml", 964, 570);
    }
}
