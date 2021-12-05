package bg.tu_varna.sit.library.presentation.controllers;

import bg.tu_varna.sit.library.buisness.services.SampleServices;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class SampleController {

    @FXML
    private Button button_log_in;

    @FXML
    private Button cancelButton;

    @FXML
    private Label loginMessageLabel;


    public void button_log_inOnAction(ActionEvent e)
    {
       loginMessageLabel.setText("You try to login");
    }

    public void cancelButtonOnAction(ActionEvent e)
    {
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }
}
