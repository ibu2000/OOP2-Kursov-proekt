package bg.tu_varna.sit.library.presentation.controllers;

import bg.tu_varna.sit.library.buisness.services.UserService;
import bg.tu_varna.sit.library.common.Constants;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class PromoteToOperatorController  implements Initializable {
    @FXML
    private ComboBox combo_box_users_to_promote_to_operator;
    @FXML
    private Button buttonPTO_promote_to_operator;
    @FXML
    private Button buttonPTO_home;

    Stage s;
    UserService userService = new UserService();
    public PromoteToOperatorController() {
    }

    public PromoteToOperatorController(Stage stage) {
        s = stage;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        combo_box_users_to_promote_to_operator.getItems().clear();
        combo_box_users_to_promote_to_operator.getItems().addAll(userService.getUserForComboBox());
    }


    @FXML
    public void goToHomePage() {
        try {
            s.close();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(Constants.View.HOMEPAGE_ADMIN));
            Stage stage = new Stage();
            fxmlLoader.setController(new HomePageAdminController(stage));
            Parent root2 = fxmlLoader.load();
            stage.setScene(new Scene(root2));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



}
