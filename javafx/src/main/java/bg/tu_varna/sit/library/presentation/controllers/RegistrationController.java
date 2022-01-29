package bg.tu_varna.sit.library.presentation.controllers;

import bg.tu_varna.sit.library.buisness.services.FormService;
import bg.tu_varna.sit.library.buisness.services.UserInfoService;
import bg.tu_varna.sit.library.buisness.services.UserService;
import bg.tu_varna.sit.library.common.Constants;
import bg.tu_varna.sit.library.data.entities.FORM;
import bg.tu_varna.sit.library.data.entities.Status;
import bg.tu_varna.sit.library.data.entities.USER;
import bg.tu_varna.sit.library.data.entities.UserType;
import bg.tu_varna.sit.library.presentation.models.BookListModel;
import bg.tu_varna.sit.library.presentation.models.FormModel;
import bg.tu_varna.sit.library.presentation.models.UserInfoListModel;
import bg.tu_varna.sit.library.presentation.models.UserListModel;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

public class RegistrationController {
    @FXML
    private TextField tf_RName;
    @FXML
    private TextField tf_RUsername;
    @FXML
    private PasswordField tf_RPassword;
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
    UserService userService = new UserService();
    UserInfoService userInfoService = new UserInfoService();
    FormService formService = new FormService();



    boolean userAlreadyExists;
    boolean userInfoAlreadyExists;
    @FXML
    public void addUser()
    {
        UserType userType = new UserType(1, "type1");
        String rating = "no rating yet";
        Status status = new Status(1, "pending");
        LocalDate localDate = LocalDate.now();


        if(tf_RUsername.equals("") || tf_RPassword.equals("") || tf_RName.equals("") || tf_RE_mail.equals("") || tf_RPhone_number.equals(""))
        {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Please fill all the fields!", ButtonType.OK);
            alert.show();
        }
        else
        {
            UserListModel addUser = new UserListModel(tf_RUsername.getText(), tf_RPassword.getText(),localDate, rating, userType, status);
            userAlreadyExists =  userService.AddUser(addUser);

            if(userAlreadyExists)
            {

            } else
            {
                Alert alert = new Alert(Alert.AlertType.ERROR, "User already exists!", ButtonType.OK);
                alert.show();
            }

            USER user = userService.listviewToEntity(addUser);
            UserInfoListModel addUserInfo = new UserInfoListModel(user, tf_RName.getText(), tf_RPhone_number.getText(), tf_RE_mail.getText());
            userInfoAlreadyExists = userInfoService.AddUserInfo(addUserInfo);

            if(userInfoAlreadyExists)
            {
            }
            else
            {
                Alert alert1 = new Alert(Alert.AlertType.INFORMATION, "The Userinfo already exists!", ButtonType.OK);
                alert1.show();
            }

            String content = addUserInfo.toString();
            String status1 = "pending";
            FORM form = new FORM(localDate, user, content, status1);
            boolean addform = formService.AddForm(form);
            if(addform)
            {
                Alert alert1 = new Alert(Alert.AlertType.INFORMATION, "Your form has been submited successfully", ButtonType.OK);
                alert1.show();
            }
            else
            {
                Alert alert1 = new Alert(Alert.AlertType.INFORMATION, "Your form wasn't submited", ButtonType.OK);
                alert1.show();
            }
        }
    }


    @FXML
    public void goBack() {
        try {
            s.close();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(Constants.View.SAMPLE));
            Stage stage = new Stage();
            fxmlLoader.setController(new SampleController(stage));
            Parent root2 = fxmlLoader.load();
            stage.setScene(new Scene(root2));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}