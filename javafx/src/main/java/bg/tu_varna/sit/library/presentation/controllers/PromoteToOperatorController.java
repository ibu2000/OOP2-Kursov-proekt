package bg.tu_varna.sit.library.presentation.controllers;

import bg.tu_varna.sit.library.buisness.services.UserService;
import bg.tu_varna.sit.library.common.Constants;
import bg.tu_varna.sit.library.data.entities.Books;
import bg.tu_varna.sit.library.data.entities.StateOfBooks;
import bg.tu_varna.sit.library.data.entities.USER;
import bg.tu_varna.sit.library.presentation.models.BookListModel;
import bg.tu_varna.sit.library.presentation.models.ExemplqrModel;
import bg.tu_varna.sit.library.presentation.models.UserListModel;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
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




    boolean isUpdated;

    @FXML
    public void promoteToOperator()
    {
        String username=combo_box_users_to_promote_to_operator.getValue().toString();
        UserListModel b = userService.GetUser(username);
        if(combo_box_users_to_promote_to_operator.equals(""))
        {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Please fill all the fields!", ButtonType.OK);
            alert.show();
        }
        else
        {
           isUpdated = userService.UpdateUser(b);

           if (isUpdated)
           {
               Alert alert = new Alert(Alert.AlertType.INFORMATION, "The user has been promoted to operator!", ButtonType.OK);
               alert.show();
           }
           else
           {
               Alert alert = new Alert(Alert.AlertType.INFORMATION, "The user has not been promoted to operator!", ButtonType.OK);
               alert.show();
           }
        }
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
