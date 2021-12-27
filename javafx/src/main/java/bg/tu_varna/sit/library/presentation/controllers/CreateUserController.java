package bg.tu_varna.sit.library.presentation.controllers;

import bg.tu_varna.sit.library.buisness.services.BookService;
import bg.tu_varna.sit.library.buisness.services.UserService;
import bg.tu_varna.sit.library.common.Constants;
import bg.tu_varna.sit.library.data.entities.Books;
import bg.tu_varna.sit.library.presentation.models.BookListModel;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.fxml.Initializable;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class CreateUserController implements Initializable{

    @FXML
    private ComboBox combo_boxCAU_create_a_user;


    Stage s;
    UserService  UserService= new UserService();




    public CreateUserController() {
    }

    public CreateUserController(Stage stage) {
        s = stage;
    }


    @Override
    public void initialize(URL url, ResourceBundle rb) {

        combo_boxCAU_create_a_user.getItems().clear();
        combo_boxCAU_create_a_user.getItems().addAll(UserService.getUserForComboBox());
    }

    @FXML
    public void  goToHomePage() {
        try {
            s.close();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(Constants.View.HOMEPAGE_OPERATOR));
            Stage stage = new Stage();
            fxmlLoader.setController(new HomePageOperatorController(stage));
            Parent root2 = fxmlLoader.load();
            stage.setScene(new Scene(root2));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }




}
