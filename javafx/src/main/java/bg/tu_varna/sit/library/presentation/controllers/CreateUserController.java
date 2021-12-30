package bg.tu_varna.sit.library.presentation.controllers;

import bg.tu_varna.sit.library.buisness.services.BookService;
import bg.tu_varna.sit.library.buisness.services.UserService;
import bg.tu_varna.sit.library.common.Constants;
import bg.tu_varna.sit.library.data.entities.Books;
import bg.tu_varna.sit.library.presentation.models.BookListModel;
import bg.tu_varna.sit.library.presentation.models.ExemplqrModel;
import bg.tu_varna.sit.library.presentation.models.UserListModel;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.fxml.Initializable;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.ResourceBundle;

public class CreateUserController implements Initializable{

    @FXML
    private ComboBox combo_boxCAU_create_a_user;

    UserService userService = new UserService();
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
        combo_boxCAU_create_a_user.getItems().addAll(UserService.getUserForApproval());
    }

    Date myDate = parseDate(java.time.LocalDate.now().toString());
    public static Date parseDate(String date)
    {
        try {
            return new SimpleDateFormat("yyyy-MM-dd").parse(date);
        } catch (ParseException e) {
            return null;
        }
    }

    boolean isCreated;
    @FXML
    public void createUser()
    {
        String username = combo_boxCAU_create_a_user.getValue().toString();
        UserListModel b = userService.GetUser(username);
        if(combo_boxCAU_create_a_user.equals(""))
        {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Please fill all the fields!", ButtonType.OK);
            alert.show();
        }
        else
        {
            isCreated = userService.CreateUser(b);

            if (isCreated)
            {
                Alert alert = new Alert(Alert.AlertType.INFORMATION, "The user has been create!", ButtonType.OK);
                alert.show();
            }
            else
            {
                Alert alert = new Alert(Alert.AlertType.INFORMATION, "The user has not been create!", ButtonType.OK);
                alert.show();
            }
        }

        combo_boxCAU_create_a_user.getItems().clear();
        combo_boxCAU_create_a_user.getItems().addAll(UserService.getUserForApproval());
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
