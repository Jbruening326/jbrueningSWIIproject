package controller;

import dao.AppointmentDao;
import helper.ControllerHelper;
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
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ResourceBundle;

public class AddAppointmentController implements Initializable {
    public Label messageLabel;
    public Button saveButton;
    public Button cancelButton;
    public ComboBox<String> typeComboBox;
    public ComboBox<Contact> contactComboBox;
    public ComboBox<LocalTime> startTimeComboBox;
    public ComboBox<LocalTime> endTimeComboBox;
    public ComboBox<Customer> customerComboBox;
    public ComboBox<User> userComboBox;
    public ComboBox<String> locationComboBox;
    public TextField appIdTextField;
    public TextField titleTextField;
    public TextField descTextField;
    public DatePicker datePicker;



    public void initialize(URL url, ResourceBundle resourceBundle) {
        //Prefill location combobox list
        ObservableList<String> locations = locationComboBox.getItems();
        locations.add("Coffee Shop");
        locations.add("Main Office");
        locations.add("Video Call");
        locations.add("Project site");

        //Prefill type combobox list
        ObservableList<String> types = typeComboBox.getItems();
        types.add("Panning Session");
        types.add("De-Briefing");
        types.add("Building");
        types.add("Execution");
        types.add("Project Close");

        //Prefill start time
        ObservableList<LocalTime> startTimes = startTimeComboBox.getItems();
        startTimes.add(LocalTime.of(8,0));

        //Prefill end time
        ObservableList<LocalTime> endTimes = endTimeComboBox.getItems();
        endTimes.add(LocalTime.of(9, 0));

    }


    public void onSaveButtonClick(ActionEvent actionEvent) throws Exception {
        String title = titleTextField.getText();
        String description = descTextField.getText();
        String location = String.valueOf(locationComboBox.getValue());
        String contact = String.valueOf(contactComboBox.getValue());
        String type = String.valueOf(typeComboBox.getValue());
        LocalDate date = datePicker.getValue();
        LocalTime start = startTimeComboBox.getValue();
        LocalTime end = endTimeComboBox.getValue();
        String customer = String.valueOf(customerComboBox.getValue());
        String user = String.valueOf(userComboBox.getValue());

        LocalDateTime startDateTime = LocalDateTime.of(date, start);
        LocalDateTime endDateTime = LocalDateTime.of(date, end);

        Appointment appointment = new Appointment(0, title, description, location, type, startDateTime, endDateTime, 1, 1, 1);

        AppointmentDao.insert(appointment);



        ControllerHelper.changeScene(actionEvent, "mainWindow.fxml", 964, 570);
    }

    public void onCancelButtonClick(ActionEvent actionEvent) throws IOException {
        ControllerHelper.changeScene(actionEvent, "mainWindow.fxml", 964, 570);
    }

}
