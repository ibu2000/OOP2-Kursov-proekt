package bg.tu_varna.sit.library.presentation.controllers;

import bg.tu_varna.sit.library.buisness.services.SampleServices;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class SampleController {
    Stage s;

    public SampleController(Stage stage)
    {
        s=stage;
    }

//    private final SampleServices sampleServices = SampleServices.getInstance();

    @FXML
   private Button button_log_in;

}
