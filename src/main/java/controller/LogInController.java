package controller;

import dao.UserDao;
import helper.ControllerHelper;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import model.User;

import java.io.IOException;

public class LogInController {


    public TextField userNameTextField;
    public TextField passwordTextField;
    public Button loginButton;
    public Button exitButton;
    public Label zoneIdLabel;
    public Label errorLabel;

    /**
     * This method logs a user into system. When the user interacts with the login button, the user will gain access
     * to the system if certain fields are correct.
     * @param actionEvent
     * @throws Exception
     */
    public void onLoginClick(ActionEvent actionEvent) throws Exception {
        String userName = userNameTextField.getText();
        String password = passwordTextField.getText();

        if (UserDao.get(userName) != null) {
            if (password.equals(UserDao.get(userName).getPassword())){
                ControllerHelper.changeScene(actionEvent, "mainWindow.fxml", 964, 570);
            }
            else {
                errorLabel.setText("Please enter a valid password");
            }

        } else {
            errorLabel.setText("Please enter a valid user name and password");
        }
    }

    public void onExitButtonClick(ActionEvent actionEvent) {System.exit(0);}
}