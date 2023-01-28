package controller;

import dao.CountryDao;
import dao.CustomerDao;
import dao.FirstLevelDivisionDao;
import helper.ControllerHelper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Country;
import model.Customer;
import model.FirstLevelDivision;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.ResourceBundle;

public class CustomerController implements Initializable {
    public Label messageLabel;
    public Button saveButton;
    public Button backButton;
    public Button deleteButton;
    public RadioButton addRadioButton;
    public RadioButton updateRadioButton;
    public TextField customerIdTextField;
    public TextField nameTextField;
    public TextField addressTextField;
    public TextField postTextField;
    public TextField phoneTextField;
    public ComboBox<Country> countryComboBox;
    public ComboBox<FirstLevelDivision> firstLevelComboBox;
    public TableView<Customer> customerTableView;
    public TableColumn<Customer, Integer> customerIdCol;
    public TableColumn<Customer, String> nameCol;
    public TableColumn<Customer, String> addressCol;
    public TableColumn<Customer, String> postalCol;
    public TableColumn<Customer, String> phoneCol;
    public TableColumn<Customer, String> countryCol;
    public TableColumn<Customer, String> firstLevelCol;



    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            customerTableView.setItems(CustomerDao.getAll());
            customerIdCol.setCellValueFactory(new PropertyValueFactory<>("CustomerId"));
            nameCol.setCellValueFactory(new PropertyValueFactory<>("CustomerName"));
            addressCol.setCellValueFactory(new PropertyValueFactory<>("Address"));
            postalCol.setCellValueFactory(new PropertyValueFactory<>("PostalCode"));
            phoneCol.setCellValueFactory(new PropertyValueFactory<>("Phone"));
            countryCol.setCellValueFactory(new PropertyValueFactory<>("Country"));
            firstLevelCol.setCellValueFactory(new PropertyValueFactory<>("Division"));

            countryComboBox.getItems();
            countryComboBox.setItems(CountryDao.getAll());
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            messageLabel.setText("There was a problem loading data");
        }
    }


    public void onCountryComboSelection(ActionEvent actionEvent) throws SQLException{
        Country country = countryComboBox.getValue();

        ObservableList<FirstLevelDivision> firstLevelDivision = FXCollections.observableArrayList();
        for(FirstLevelDivision fLD : FirstLevelDivisionDao.getAll()){
            if(country.getCountryId() == fLD.getCountryId()){
                firstLevelDivision.add(fLD);
            }
        }
        firstLevelComboBox.setItems(firstLevelDivision);
    }

    public void onDeleteButtonClick(ActionEvent actionEvent) throws SQLException{
        Customer selectedCustomer = customerTableView.getSelectionModel().getSelectedItem();

        if(selectedCustomer != null){
            messageLabel.setText(null);
            if(ControllerHelper.confirmationAlert("Are you sure? " +
                    "Deleting customer will also remove associated appointments!") == ButtonType.YES){
                CustomerDao.delete(selectedCustomer);
                ControllerHelper.messageDisplay("Customer Deleted","Customer with ID, " +
                        selectedCustomer.getCustomerId() +
                        ", and name, " + selectedCustomer.getCustomerName() + ", has been deleted");
                customerTableView.setItems(CustomerDao.getAll());
            }
        }
        else {
            messageLabel.setText("Please make a selection");
        }
    }

    public void onAddRadioButtonClick(ActionEvent actionEvent) {
        customerIdTextField.clear();
        nameTextField.clear();
        addressTextField.clear();
        postTextField.clear();
        phoneTextField.clear();

        saveButton.setText("Save");
    }

    public void onUpdateRadioButtonClick(ActionEvent actionEvent) throws Exception {
        messageLabel.setText(null);


        try {
            customerIdTextField.setText(String.valueOf(customerTableView.getSelectionModel().getSelectedItem().getCustomerId()));
            nameTextField.setText(customerTableView.getSelectionModel().getSelectedItem().getCustomerName());
            addressTextField.setText(customerTableView.getSelectionModel().getSelectedItem().getAddress());
            postTextField.setText(customerTableView.getSelectionModel().getSelectedItem().getPostalCode());
            phoneTextField.setText(customerTableView.getSelectionModel().getSelectedItem().getPhone());
            countryComboBox.setValue(customerTableView.getSelectionModel().getSelectedItem().getCountry());
            firstLevelComboBox.setValue(customerTableView.getSelectionModel().getSelectedItem().getDivision());

            saveButton.setText("Update");
        }
        catch(Exception e){
            messageLabel.setText("Please select a customer first");
            addRadioButton.fire();
        }



    }

    public void onSaveButtonClick(ActionEvent actionEvent) throws SQLException {
        try {
            String name = nameTextField.getText();
            String address = addressTextField.getText();
            String postal = postTextField.getText();
            String phone = phoneTextField.getText();
            Country country = countryComboBox.getValue();
            FirstLevelDivision firstLevel = firstLevelComboBox.getValue();

            if (name.isEmpty() || name.isBlank() || address.isEmpty() || address.isBlank() || postal.isEmpty()
                    || postal.isBlank() || phone.isEmpty() || phone.isBlank()
                    || countryComboBox.getValue() == null || firstLevelComboBox.getValue() == null) {
                messageLabel.setText("Please make sure all fields are completed");
            } else {
                if (customerIdTextField.getText().isBlank() || customerIdTextField.getText().isEmpty()) {
                    Customer customer = new Customer(0, name, address, postal, phone, firstLevel.getDivisionId());
                    CustomerDao.insert(customer);
                } else {
                    int customerId = Integer.parseInt(customerIdTextField.getText());
                    Customer customer = new Customer(customerId, name, address, postal, phone, firstLevel.getDivisionId());
                    CustomerDao.update(customer);
                }
                customerIdTextField.clear();
                nameTextField.clear();
                addressTextField.clear();
                postTextField.clear();
                phoneTextField.clear();
            }
            customerTableView.setItems(CustomerDao.getAll());
        }
        catch(SQLException e){
            messageLabel.setText("All fields must be completed and text fields have character limits");
        }

    }


    public void onBackButtonClick(ActionEvent actionEvent) throws IOException {
        ControllerHelper.changeScene(actionEvent, "mainWindow.fxml", 964, 570);
    }
}
