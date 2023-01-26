package controller;

import dao.CustomerDao;
import helper.ControllerHelper;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Country;
import model.Customer;
import model.FirstLevelDivision;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class CustomerController implements Initializable {
    public Label messageLabel;
    public Button saveButton;
    public Button cancelButton;
    public Button deleteButton;
    public RadioButton addRadioButton;
    public RadioButton updateRadioButton;
    public TextField customerIdTextField;
    public TextField firstNameTextField;
    public TextField lastNameTextField;
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
            //countryCol.setCellValueFactory(new PropertyValueFactory<>());
            //firstLevelCol.setCellValueFactory(new PropertyValueFactory<>());
        }
        catch(Exception e){}
    }

    public void onCountryComboSelection(ActionEvent actionEvent) {
    }

    public void onDeleteButtonClick(ActionEvent actionEvent) {
    }

    public void onAddRadioButtonClick(ActionEvent actionEvent) {
        saveButton.setText("Save");

    }

    public void onUpdateRadioButtonClick(ActionEvent actionEvent) {
        customerIdTextField.setText(String.valueOf(customerTableView.getSelectionModel().getSelectedItem().getCustomerId()));
        firstNameTextField.setText(customerTableView.getSelectionModel().getSelectedItem().getCustomerName());
        lastNameTextField.setText(customerTableView.getSelectionModel().getSelectedItem().getCustomerName());
        addressTextField.setText(customerTableView.getSelectionModel().getSelectedItem().getAddress());
        postTextField.setText(customerTableView.getSelectionModel().getSelectedItem().getPostalCode());
        phoneTextField.setText(customerTableView.getSelectionModel().getSelectedItem().getPhone());

        saveButton.setText("Update");



    }

    public void onSaveButtonClick(ActionEvent actionEvent) throws Exception {
        String firstName = firstNameTextField.getText();
        String lastName = lastNameTextField.getText();
        String address = addressTextField.getText();
        String postal = postTextField.getText();
        String phone = phoneTextField.getText();
        String country = String.valueOf(countryComboBox.getValue());
        String firstLevel = String.valueOf(firstLevelComboBox.getValue());

        String fullName = firstName + " " + lastName;
        int divisionId = 1 ;

        Customer customer = new Customer(0, fullName, address, postal, phone, divisionId);
        CustomerDao.insert(customer);

        ControllerHelper.changeScene(actionEvent, "mainWindow.fxml", 964, 570);
    }

    public void onCancelButtonClick(ActionEvent actionEvent) throws IOException {
        ControllerHelper.changeScene(actionEvent, "mainWindow.fxml", 964, 570);
    }
}
