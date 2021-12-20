package bg.tu_varna.sit.library.presentation.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class RegistrationController {
    @FXML
    private TextField tf_RName;
    @FXML
    private TextField tf_RUsername;
    @FXML
    private TextField tf_RPassword;
    @FXML
    private TextField tf_RE_mail;
    @FXML
    private TextField tf_RPhone_number;
    @FXML
    private Button button_RSign_up;

    Stage s;

    public RegistrationController() {
    }

    public RegistrationController(Stage stage) {
        s = stage;
    }


}
