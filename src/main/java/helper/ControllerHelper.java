package helper;

import com.example.c195jbruening.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public abstract class ControllerHelper {


    public static void changeScene(ActionEvent actionEvent, String fxmlName, int width, int height) throws IOException {

        Stage stage;

        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource(fxmlName));
        stage = (Stage)((Button)actionEvent.getSource()).getScene().getWindow();
        Scene scene = new Scene(fxmlLoader.load(), width, height);
        stage.setTitle("Login Application");
        stage.setScene (scene);
        stage.show();

    }
}
