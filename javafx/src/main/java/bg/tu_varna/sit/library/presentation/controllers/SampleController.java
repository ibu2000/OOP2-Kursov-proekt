package bg.tu_varna.sit.library.presentation.controllers;

import bg.tu_varna.sit.library.common.Constants;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class SampleController {
    Stage s = new Stage();
    @FXML
    private Button button_log_in;

    @FXML
    private Button cancelButton;

    @FXML
    private Label loginMessageLabel;

    public void LoggedInController(Stage stage) {
        s = stage;
    }
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    public void userLogin() throws IOException
    {
        try
        {
            s.close();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(Constants.View.HOMEPAGE_USER));
            Stage stage = new Stage();
            fxmlLoader.setController(new HomePageUserController(stage));
            Parent root2 = fxmlLoader.load();
            stage.setScene(new Scene(root2));
            stage.show();
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }

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
