package bg.tu_varna.sit.library.presentation.controllers;

import bg.tu_varna.sit.library.buisness.services.UserService;
import bg.tu_varna.sit.library.common.Constants;
import bg.tu_varna.sit.library.data.entities.Books;
import bg.tu_varna.sit.library.data.entities.StateOfBooks;
import bg.tu_varna.sit.library.data.entities.USER;
import bg.tu_varna.sit.library.presentation.models.ExemplqrModel;
import bg.tu_varna.sit.library.presentation.models.UserListModel;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

public class UserRatingController {
    @FXML
    private Button button_loyal;
    @FXML
    private Button button_disloyal;
    @FXML
    private Button buttonUR_home;
    @FXML
    private Label iduser;
    @FXML
    private TableView<UserListModel> userRating;
    @FXML
    private TableColumn<UserListModel, Long> username;
    @FXML
    private TableColumn<UserListModel, Books> rating;
    @FXML
    private TableColumn<UserListModel, StateOfBooks> userType;

    Stage s;
    public UserRatingController()
    {}
    public UserRatingController(Stage stage)
    {
        s = stage;
    }

    UserService userService = new UserService();

    USER userr;
    public void displayId (USER user)
    {
        iduser.setText( Long.toString(user.getIdUser()));
        userr = user;
    }



    public void ReturnToHomePage()
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
}
