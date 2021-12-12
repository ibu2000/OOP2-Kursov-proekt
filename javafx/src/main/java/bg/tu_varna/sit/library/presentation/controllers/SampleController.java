package bg.tu_varna.sit.library.presentation.controllers;

import bg.tu_varna.sit.library.buisness.services.UserService;
import bg.tu_varna.sit.library.common.Constants;
import bg.tu_varna.sit.library.presentation.models.UserListModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.hibernate.service.Service;

import static bg.tu_varna.sit.library.common.Constants.View.SAMPLE;
import static bg.tu_varna.sit.library.common.Constants.View.HOMEPAGE_USER;
import java.io.IOException;
import java.security.Provider;

public class SampleController {
    Stage s = new Stage();
    @FXML
    private Button button_log_in;

    @FXML
    private Button cancelButton;

    @FXML
    private Label loginMessageLabel;

    @FXML
    private TextField tf_username;

    @FXML
    private PasswordField tf_password;

    public SampleController()
    {}
    public SampleController(Stage stage)
    {
        s = stage;
    }

    UserService service = new UserService();
    @FXML
    public void userLogin() {
        if (tf_password.getText().equals("") || tf_username.equals("")) {
            loginMessageLabel.setText("Please fill in the info");
            }
        else if(!tf_password.getText().equals("") && !tf_username.equals(""))
        {
            loginMessageLabel.setText("not empty bruh");
            UserListModel userfind = new UserListModel(tf_username.getText(),tf_password.getText());
           if(service.UserLogin(userfind))
           {

            try {
                s.close();
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(Constants.View.HOMEPAGE_OPERATOR));
                Stage stage = new Stage();
                fxmlLoader.setController(new HomePageOperatorController(stage));
                Parent root2 = fxmlLoader.load();
                stage.setScene(new Scene(root2));
                stage.show();
            } catch (Exception e)
            {
                e.printStackTrace();
            }
           }
        }


    }




    public void cancelButtonOnAction(ActionEvent e)
    {
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }
}
