package controller;

import helper.ControllerHelper;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;

import java.io.IOException;

public class ResultController {
    public Label resultLabel;
    public TableView resultTableView;
    public Button toReportsButton;

    public void onToReportButtonClick(ActionEvent actionEvent) throws IOException {
        ControllerHelper.changeScene(actionEvent, "reports.fxml", 696, 427);
    }
}
