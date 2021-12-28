package bg.tu_varna.sit.library.presentation.controllers;

import bg.tu_varna.sit.library.buisness.services.UserService;
import bg.tu_varna.sit.library.data.entities.Status;
import bg.tu_varna.sit.library.data.entities.UserType;
import bg.tu_varna.sit.library.presentation.models.BookListModel;
import bg.tu_varna.sit.library.presentation.models.UserListModel;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.text.ParseException;
import java.text.SimpleDateFormat;
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

    public static Date parseDate(String date) {
        try {
            return new SimpleDateFormat("yyyy-MM-dd").parse(date);
        } catch (ParseException e) {
            return null;
        }
    }

    boolean userAlreadyExists;
    @FXML
    public void addUser()
    {
        UserType userType = new UserType(1, "type1");
        String rating = "no rating yet";
        Status status = new Status(1, "pending");
        Date myDate = parseDate("2000-11-04");
        UserListModel addUser = new UserListModel(tf_RUsername.getText(), tf_RPassword.getText(),myDate, rating, userType, status);

        if(tf_RUsername.equals("") || tf_RPassword.equals("") || tf_RName.equals("") || tf_RE_mail.equals("") || tf_RPhone_number.equals(""))
        {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Please fill all the fields!", ButtonType.OK);
            alert.show();
        }
        else
        {
           userAlreadyExists =  userService.AddUser(addUser);
            if(userAlreadyExists)
            {
                Alert alert = new Alert(Alert.AlertType.INFORMATION, "The book has been added!", ButtonType.OK);
                alert.show();
            } else
            {
                Alert alert = new Alert(Alert.AlertType.ERROR, "Book already exists!", ButtonType.OK);
                alert.show();
            }
        }
     /*   combo_boxANB_state_of_book.getItems().clear();
        combo_boxANB_state_of_book.getItems().addAll(stateOfBooksService.getBookStates());
        */
    }

}
