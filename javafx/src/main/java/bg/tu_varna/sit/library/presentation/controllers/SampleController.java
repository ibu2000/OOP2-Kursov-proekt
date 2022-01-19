package bg.tu_varna.sit.library.presentation.controllers;

import bg.tu_varna.sit.library.buisness.services.UserService;
import bg.tu_varna.sit.library.common.Constants;
import bg.tu_varna.sit.library.data.entities.Books;
import bg.tu_varna.sit.library.data.entities.USER;
import bg.tu_varna.sit.library.data.entities.UserType;
import bg.tu_varna.sit.library.presentation.models.UserListModel;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.effect.Bloom;
import javafx.scene.effect.Effect;
import javafx.scene.layout.Background;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.hibernate.service.Service;
import org.w3c.dom.events.MouseEvent;

import static bg.tu_varna.sit.library.common.Constants.View.SAMPLE;
import static bg.tu_varna.sit.library.common.Constants.View.HOMEPAGE_USER;


import java.io.IOException;
import java.security.Provider;
import java.util.List;

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

    @FXML
    private Button button_sign_up;

    public SampleController() {

    }


    public SampleController(Stage stage) {
        s = stage;
    }

    public static int userType = 2;

    UserService service = new UserService();

    @FXML
    public void userLogin() {
        if (tf_password.getText().equals("") || tf_username.equals("")) {

            loginMessageLabel.setText("Please fill in the info");

        } else if (!tf_password.getText().equals("") && !tf_username.equals(""))
        {
            UserListModel userfind = new UserListModel(tf_username.getText(), tf_password.getText());
            if (service.UserLogin(userfind)) {
                try {
                    long a = service.FindUserType(userfind);

                    if (a == 1) {
                        s.close();
                        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(Constants.View.HOMEPAGE_USER));
                        Stage stage = new Stage();
                        fxmlLoader.setController(new HomePageUserController(stage));
                        Parent root2 = fxmlLoader.load();
                        USER user = service.FindUser(userfind);
                        HomePageUserController homePageUserController = fxmlLoader.getController();
                        homePageUserController.displayId(user);
                        stage.setScene(new Scene(root2));
                        stage.show();
                    } else if (a == 2) {
                        s.close();
                        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(Constants.View.HOMEPAGE_OPERATOR));
                        Stage stage = new Stage();
                        fxmlLoader.setController(new HomePageOperatorController(stage));
                        Parent root2 = fxmlLoader.load();
                        USER user = service.FindUser(userfind);
                        HomePageOperatorController homePageOperatorController = fxmlLoader.getController();
                       homePageOperatorController.displayId(user);
                        stage.setScene(new Scene(root2));
                        stage.show();
                    } else if (a == 3) {
                        s.close();
                        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(Constants.View.HOMEPAGE_ADMIN));
                        Stage stage = new Stage();
                        fxmlLoader.setController(new HomePageAdminController(stage));
                        Parent root2 = fxmlLoader.load();
                        USER user = service.FindUser(userfind);
                        HomePageAdminController homePageAdminController = fxmlLoader.getController();
                        homePageAdminController.displayId(user);
                        stage.setScene(new Scene(root2));

                        stage.show();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            else
            {
                Alert alert = new Alert(Alert.AlertType.ERROR, "Wrong username or password!", ButtonType.OK);
                alert.show();
            }
        }

    }

    @FXML
    public void goToRegistration() {
        try {
            s.close();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(Constants.View.REGISTRATION));
            Stage stage = new Stage();
            fxmlLoader.setController(new RegistrationController(stage));
            Parent root2 = fxmlLoader.load();
            stage.setScene(new Scene(root2));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void cancelButtonOnAction(ActionEvent e) {
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }




}