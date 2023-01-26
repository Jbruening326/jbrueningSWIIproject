package controller;
import dao.AppointmentDao;
import helper.ControllerHelper;
import helper.Utilities;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Appointment;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ResourceBundle;

/**
 * This class is a controller for the main window form.
 */
public class MainWindowController implements Initializable{
    /**
     * Creates a Radio Button object for weekly view of appointments
     */
    public RadioButton weekViewRadio;
    /**
     * Creates a Radio Button object for month view of appointments
     */
    public RadioButton monthViewRadioButton;
    /**
     * Creates a Radio Button Object for all appointments
     */
    public RadioButton allAppointmentsRadioButton;
    /**
     * Creates a Button object for an Add Appointments button
     */
    public Button addButton;
    /**
     * Creates a Button object for an Update Appointments button
     */
    public Button updateButton;
    /**
     * Creates a Button object for a Cancel Appointment button
     */
    public Button cancelButton;
    /**
     * Creates a Button object for a Customers button
     */
    public Button customersButton;
    /**
     * Creates a Button object for a Reports button
     */
    public Button reportsButton;
    /**
     * Creates a Button object for an Exit button
     */
    public Button exitButton;
    /**
     * Creates a Label object to be able to display messages within the program
     */
    public Label messageLabel;

    /**
     * Creates a TableView object for Appointment objects to be displayed in
     */
    public TableView<Appointment> appointmentsTableView;
    /**
     * Creates a TableColumn object for an Appointment object field to be displayed in
     */
    public TableColumn<Appointment, Integer> appIdCol;
    /**
     * Creates a TableColumn object for an Appointment object field to be displayed in
     */
    public TableColumn<Appointment, String> titleCol;
    /**
     * Creates a TableColumn object for an Appointment object field to be displayed in
     */
    public TableColumn<Appointment, String> descCol;
    /**
     * Creates a TableColumn object for an Appointment object field to be displayed in
     */
    public TableColumn<Appointment, String> locCol;
    /**
     * Creates a TableColumn object for an Appointment object field to be displayed in
     */
    public TableColumn<Appointment, String> contCol;
    /**
     * Creates a TableColumn object for an Appointment object field to be displayed in
     */
    public TableColumn<Appointment, String> typeCol;
    /**
     * Creates a TableColumn object for an Appointment object field to be displayed in
     */
    public TableColumn<Appointment, LocalDate> dateCol;
    /**
     * Creates a TableColumn object for an Appointment object field to be displayed in
     */
    public TableColumn<Appointment, LocalTime> startCol;
    /**
     * Creates a TableColumn object for an Appointment object field to be displayed in
     */
    public TableColumn<Appointment, LocalTime> endCol;
    /**
     * Creates a TableColumn object for an Appointment object field to be displayed in
     */
    public TableColumn<Appointment, Integer> customerIdCol;
    /**
     * Creates a TableColumn object for an Appointment object field to be displayed in
     */
    public TableColumn<Appointment, Integer> userIdCol;

    /**
     * This method initializes the main window form. When the main window form is updated, the table is repopulated
     * with all appointments.
     * @param url
     * @param resourceBundle
     */
    public void initialize(URL url, ResourceBundle resourceBundle){
        try {
            appointmentsTableView.setItems(AppointmentDao.getAll());
            appIdCol.setCellValueFactory(new PropertyValueFactory<>("AppointmentId"));
            titleCol.setCellValueFactory(new PropertyValueFactory<>("Title"));
            descCol.setCellValueFactory(new PropertyValueFactory<>("Description"));
            locCol.setCellValueFactory(new PropertyValueFactory<>("Location"));
            contCol.setCellValueFactory(new PropertyValueFactory<>("ContactName"));
            typeCol.setCellValueFactory(new PropertyValueFactory<>("Type"));
            dateCol.setCellValueFactory(new PropertyValueFactory<>("LocalDate"));
            startCol.setCellValueFactory(new PropertyValueFactory<>("StartTime"));
            endCol.setCellValueFactory(new PropertyValueFactory<>("EndTime"));
            customerIdCol.setCellValueFactory(new PropertyValueFactory<>("CustomerId"));
            userIdCol.setCellValueFactory(new PropertyValueFactory<>("UserId"));

        }
        catch(Exception e){
            messageLabel.setText("There are currently no appointments");
            System.out.println(e.getMessage());
            System.out.println(e.getStackTrace());
        }
    }

    /**
     * This method will filter all appointments by week. When the radio button is fired, the tableview will be changed
     * to display all appointments within the next 7 days.
     * @param actionEvent
     * @throws SQLException
     */
    public void onWeekViewRadioButton(ActionEvent actionEvent) throws SQLException {
        messageLabel.setText(null);
        ObservableList<Appointment> weeklyAppointments = Utilities.filterAppointments(LocalDateTime.now().plusDays(7));

        if(weeklyAppointments.isEmpty()){
            appointmentsTableView.setItems(weeklyAppointments);
            messageLabel.setText("No appointments this week");
        }
        else{
            appointmentsTableView.setItems(weeklyAppointments);
        }

    }

    /**
     * This method will filter all appointments by month. When the radio button is fired, the tableview will be changed
     * to display all appointments within the next month.
     * @param actionEvent
     * @throws SQLException
     */
    public void onMonthViewRadioButton(ActionEvent actionEvent) throws SQLException{
        messageLabel.setText(null);
        appointmentsTableView.setItems(Utilities.filterAppointments(LocalDateTime.now().plusMonths(1)));
        messageLabel.setText(null);
        ObservableList<Appointment> monthlyAppointments = Utilities.filterAppointments(LocalDateTime.now().plusMonths(1));

        if(monthlyAppointments.isEmpty()){
            appointmentsTableView.setItems(null);
            messageLabel.setText("No appointments this month");
        }
        else{
            appointmentsTableView.setItems(monthlyAppointments);
        }
    }

    /**
     * This method will display all appointments. When the radio button is fired, the tableview will be changed
     * to display all appointments.
     * @param actionEvent
     * @throws SQLException
     */
    public void onAllAppointmentsRadioButton(ActionEvent actionEvent) throws Exception {
        messageLabel.setText(null);
        appointmentsTableView.setItems(AppointmentDao.getAll());
    }

    /**
     * This method changes the form. When the Add Appointment button is interacted with, the from will be changed to the
     * Add Appointment form.
     * @param actionEvent
     * @throws IOException
     */
    public void onAddButtonClick(ActionEvent actionEvent) throws IOException {
        ControllerHelper.changeScene(actionEvent, "addAppointment.fxml", 732, 515);
    }

    /**
     * This method changes the form. When the Update Appointment button is interacted with, the from will be changed to the
     * Update Appointment form.
     * @param actionEvent
     * @throws IOException
     */
    public void onUpdateButtonClick(ActionEvent actionEvent) throws Exception {

            Appointment selectedAppointment = appointmentsTableView.getSelectionModel().getSelectedItem();
            if(selectedAppointment != null){
                ControllerHelper.changeScene(actionEvent, "updateAppointment.fxml", 732, 515);

                FXMLLoader fxmlLoader = ControllerHelper.getFxmlLoader();
                UpdateAppointmentController UAController = fxmlLoader.getController();
                UAController.sendAppointment(selectedAppointment);
            }
            else{
                messageLabel.setText("Please select an appointment first");
            }
    }

    /**
     * This method will remove a selected appointment. When the cancel button is interacted with, A selected
     * appointment from the table will be removed.
     * @param actionEvent
     * @throws SQLException
     */
    public void onCancelButtonClick(ActionEvent actionEvent) throws SQLException {
        Appointment selectedAppointment = appointmentsTableView.getSelectionModel().getSelectedItem();

        if(selectedAppointment != null){
            messageLabel.setText(null);
            if(ControllerHelper.confirmationAlert("Are you sure you want to delete appointment?") == ButtonType.YES){
                AppointmentDao.delete(selectedAppointment);
                ControllerHelper.messageDisplay("Appointment Canceled","Appointment with ID, " +
                        selectedAppointment.getAppointmentId() +
                        ", and Type, " + selectedAppointment.getType() + ", has been canceled");
                appointmentsTableView.setItems(AppointmentDao.getAll());
            }
        }
        else {
            messageLabel.setText("Please make a selection");
        }

    }

    /**
     * This method changes the form. When the Customers button is interacted with, the from will be changed to the
     * Customers form.
     * @param actionEvent
     * @throws IOException
     */
    public void onCustomersButtonClick(ActionEvent actionEvent) throws IOException {
        ControllerHelper.changeScene(actionEvent, "customer.fxml", 970, 631);
    }

    /**
     * This method closes the program. When Exit button is interacted with, the application will be closed.
     * @param actionEvent
     */
    public void onExitButtonClick(ActionEvent actionEvent) {
        if(ControllerHelper.confirmationAlert("Are you sure you want to exit?") == ButtonType.YES){
            System.exit(0);
        }
    }

    /**
     * This method changes the form. When the Reports button is interacted with, the from will be changed to the
     * Reports form.
     * @param actionEvent
     * @throws IOException
     */
    public void onReportsButtonClick(ActionEvent actionEvent) throws IOException {
        ControllerHelper.changeScene(actionEvent, "reports.fxml", 696, 427);
    }
}
