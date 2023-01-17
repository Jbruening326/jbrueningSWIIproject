package controller;


import dao.AppointmentDao;
import helper.ControllerHelper;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Appointment;
import model.Contact;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ResourceBundle;

public class MainWindowController implements Initializable{
    public RadioButton weekViewRadio;
    public RadioButton monthViewRadioButton;
    public RadioButton allAppointmentsRadioButton;
    public Button addButton;
    public Button updateButton;
    public Button cancelButton;
    public Button customersButton;
    public Button reportsButton;
    public Button exitButton;
    public Label messageLabel;

    public TableView<Appointment> appointmentsTableView;
    public TableColumn<Appointment, Integer> appIdCol;
    public TableColumn<Appointment, String> titleCol;
    public TableColumn<Appointment, String> descCol;
    public TableColumn<Appointment, String> locCol;
    public TableColumn<Contact, String> contCol;
    public TableColumn<Appointment, String> typeCol;
    public TableColumn<Appointment, LocalDate> dateCol;
    public TableColumn<Appointment, LocalTime> startCol;
    public TableColumn<Appointment, LocalTime> endCol;
    public TableColumn<Appointment, Integer> customerIdCol;
    public TableColumn<Appointment, Integer> userIdCol;

    public void initialize(URL url, ResourceBundle resourceBundle){

        try {
            appointmentsTableView.setItems(AppointmentDao.getAll());
            appIdCol.setCellValueFactory(new PropertyValueFactory<>("AppointmentId"));
            titleCol.setCellValueFactory(new PropertyValueFactory<>("Title"));
            descCol.setCellValueFactory(new PropertyValueFactory<>("Description"));
            locCol.setCellValueFactory(new PropertyValueFactory<>("Location"));
            contCol.setCellValueFactory(new PropertyValueFactory<>("ContactId"));
            typeCol.setCellValueFactory(new PropertyValueFactory<>("Type"));
            //dateCol.setCellValueFactory(new PropertyValueFactory<>("StartDateTime"));
            //startCol.setCellValueFactory(new PropertyValueFactory<>("AppointmentId"));
            //endCol.setCellValueFactory(new PropertyValueFactory<>("AppointmentId"));
            customerIdCol.setCellValueFactory(new PropertyValueFactory<>("CustomerId"));
            userIdCol.setCellValueFactory(new PropertyValueFactory<>("UserId"));

        }
        catch(Exception e){
            System.out.println(e.getMessage());
            System.out.println(e.getStackTrace());
        }
    }


    public void onWeekViewRadioButton(ActionEvent actionEvent) {
    }

    public void onMonthViewRadioButton(ActionEvent actionEvent) {
    }

    public void onAllAppointmentsRadioButton(ActionEvent actionEvent) throws Exception {
        appointmentsTableView.setItems(AppointmentDao.getAll());
    }


    public void onAddButtonClick(ActionEvent actionEvent) throws IOException {
        ControllerHelper.changeScene(actionEvent, "addAppointment.fxml", 732, 515);
    }

    public void onUpdateButtonClick(ActionEvent actionEvent) throws IOException {
        ControllerHelper.changeScene(actionEvent, "updateAppointment.fxml", 732, 515);

        FXMLLoader fxmlLoader = ControllerHelper.getFxmlLoader();
        UpdateAppointmentController UAController = fxmlLoader.getController();
        UAController.sendAppointment(appointmentsTableView.getSelectionModel().getSelectedItem());


    }

    public void onCancelButtonClick(ActionEvent actionEvent) {
    }

    public void onCustomersButtonClick(ActionEvent actionEvent) throws IOException {
        ControllerHelper.changeScene(actionEvent, "customer.fxml", 970, 631);
    }

    public void onExitButtonClick(ActionEvent actionEvent) {System.exit(0);}

    public void onReportsButtonClick(ActionEvent actionEvent) throws IOException {
        ControllerHelper.changeScene(actionEvent, "reports.fxml", 696, 427);
    }
}
