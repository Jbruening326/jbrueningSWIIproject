package helper;

import com.example.c195jbruening.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

import java.io.IOException;

public abstract class ControllerHelper {

    private static FXMLLoader fxmlLoader;
    public static void changeScene(ActionEvent actionEvent, String fxmlName, int width, int height) throws IOException {

        try {
            Stage stage;

            fxmlLoader = new FXMLLoader(Main.class.getResource(fxmlName));
            stage = (Stage) ((Button) actionEvent.getSource()).getScene().getWindow();
            Scene scene = new Scene(fxmlLoader.load(), width, height);
            stage.setTitle("Login Application");
            stage.setScene(scene);
            stage.show();
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }

    }
    public static FXMLLoader getFxmlLoader(){
        return fxmlLoader;
    }

    public static ButtonType confirmationAlert(String message) {
        Alert confirmation = new Alert(Alert.AlertType.CONFIRMATION, message, ButtonType.YES, ButtonType.CANCEL);
        confirmation.showAndWait();

        return confirmation.getResult();
    }

    public static void messageDisplay (String header, String message){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(header);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
