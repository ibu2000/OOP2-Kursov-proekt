package bg.tu_varna.sit.library.presentation.controllers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class LoggedInController implements Initializable {
    Stage s = new Stage();
    @FXML
    private Button button_logout;
    @FXML
    private Label label_welcome;
    @FXML
    private Button button_log_in;
    @FXML
    private Label label_fav_channel;
    @Override
    public void initialize(URL location, ResourceBundle resources)
    {

    }

    public void setUserInformation(String username, String favChannel){
        label_welcome.setText("Welcome "+username+"?");
        label_fav_channel.setText("Your favorite YouTube channel is " + favChannel +"?");
    }
}
