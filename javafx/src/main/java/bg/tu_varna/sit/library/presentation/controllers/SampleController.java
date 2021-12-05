package bg.tu_varna.sit.library.presentation.controllers;

import bg.tu_varna.sit.library.buisness.services.SampleServices;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class SampleController {

    @FXML
    private Button button_log_in;

    @FXML
    private Button cancelButton;

    public void button_log_inOnAction(ActionEvent e)
    {
        Stage stage = (Stage) button_log_in.getScene().getWindow();
        stage.close();
    }

    public void cancelButtonOnAction(ActionEvent e)
    {
        Stage stage = (Stage) button_log_in.getScene().getWindow();
        stage.close();
    }
}
