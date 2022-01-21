package bg.tu_varna.sit.library.presentation.controllers;

import bg.tu_varna.sit.library.buisness.services.BookService;
import bg.tu_varna.sit.library.buisness.services.FormService;
import bg.tu_varna.sit.library.buisness.services.UserService;
import bg.tu_varna.sit.library.common.Constants;
import bg.tu_varna.sit.library.data.entities.Books;
import bg.tu_varna.sit.library.data.entities.USER;
import bg.tu_varna.sit.library.presentation.models.BookListModel;
import bg.tu_varna.sit.library.presentation.models.ExemplqrModel;
import bg.tu_varna.sit.library.presentation.models.FormModel;
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
    @FXML
    private Label iduser;
    UserService userService = new UserService();
    Stage s;
    UserService  UserService= new UserService();
    FormService formService = new FormService();

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


    USER userr;
    public void displayId (USER user)
    {
        iduser.setText( Long.toString(user.getIdUser()));
        userr = user;
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
                USER user = userService.GetUserByName(username);
                FormModel form = formService.GetForm(user);
                formService.UpdateForm(form);
                Alert alert = new Alert(Alert.AlertType.INFORMATION, "The user has been created!", ButtonType.OK);
                alert.show();
            }
            else
            {
                Alert alert = new Alert(Alert.AlertType.INFORMATION, "The user has not been created!", ButtonType.OK);
                alert.show();
            }
        }

        combo_boxCAU_create_a_user.getItems().clear();
        combo_boxCAU_create_a_user.getItems().addAll(UserService.getUserForApproval());
    }

    @FXML
    public void goToHomePage() {
        try {

            USER user = userService.FindUserByID(userr.getIdUser());
            long a = user.getUSERTYPE_idUserType().getIdUserType();


            if (a == 1)
            {
                s.close();
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(Constants.View.HOMEPAGE_USER));
                Stage stage = new Stage();
                fxmlLoader.setController(new HomePageUserController(stage));
                Parent root2 = fxmlLoader.load();
                HomePageUserController homePageUserController = fxmlLoader.getController();
                homePageUserController.displayId(user);
                stage.setScene(new Scene(root2));
                stage.show();
            } else if (a == 2)
            {

                s.close();
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(Constants.View.HOMEPAGE_OPERATOR));
                Stage stage = new Stage();
                fxmlLoader.setController(new HomePageOperatorController(stage));
                Parent root2 = fxmlLoader.load();
                HomePageOperatorController homePageOperatorController = fxmlLoader.getController();
                homePageOperatorController.displayId(user);
                stage.setScene(new Scene(root2));
                stage.show();
            } else if (a == 3)
            {
                s.close();
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(Constants.View.HOMEPAGE_ADMIN));
                Stage stage = new Stage();
                fxmlLoader.setController(new HomePageAdminController(stage));
                Parent root2 = fxmlLoader.load();
                HomePageAdminController homePageAdminController = fxmlLoader.getController();
                homePageAdminController.displayId(user);
                stage.setScene(new Scene(root2));
                stage.show();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }






}
