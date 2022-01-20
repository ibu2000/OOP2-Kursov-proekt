package bg.tu_varna.sit.library.presentation.controllers;

import bg.tu_varna.sit.library.buisness.services.UserService;
import bg.tu_varna.sit.library.common.Constants;
import bg.tu_varna.sit.library.data.entities.Books;
import bg.tu_varna.sit.library.data.entities.StateOfBooks;
import bg.tu_varna.sit.library.data.entities.USER;
import bg.tu_varna.sit.library.data.entities.UserType;
import bg.tu_varna.sit.library.presentation.models.ExemplqrModel;
import bg.tu_varna.sit.library.presentation.models.UserListModel;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class UserRatingController implements Initializable {
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
    private TableColumn<UserListModel, UserType> userType;

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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        username.setCellValueFactory(new PropertyValueFactory<>("userName"));
        rating.setCellValueFactory(new PropertyValueFactory<>("rating"));
        userType.setCellValueFactory(new PropertyValueFactory<>("USERTYEPE_idUserType"));
        ObservableList<UserListModel> list = userService.getAllFields();
        userRating.getItems().clear();
            for(UserListModel u : list)
            {
                userRating.getItems().add(u);
            }
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


    @FXML
    public void Loyal()
    {
        username.setCellValueFactory(new PropertyValueFactory<>("userName"));
        rating.setCellValueFactory(new PropertyValueFactory<>("rating"));
        userType.setCellValueFactory(new PropertyValueFactory<>("USERTYEPE_idUserType"));
        ObservableList<UserListModel> list = userService.GetUsersByLoyalty("good");
        if(list.size()>0)
        {
            userRating.getItems().clear();
            for (UserListModel u : list) {
                userRating.getItems().add(u);
            }
        }
        else
        {
            Alert alert = new Alert(Alert.AlertType.ERROR, "No user matches your search", ButtonType.OK);
            alert.show();
        }
    }

    @FXML
    public void Disloyal()
    {
        username.setCellValueFactory(new PropertyValueFactory<>("userName"));
        rating.setCellValueFactory(new PropertyValueFactory<>("rating"));
        userType.setCellValueFactory(new PropertyValueFactory<>("USERTYEPE_idUserType"));
        ObservableList<UserListModel> list = userService.GetUsersByLoyalty("bad");
        if(list.size()>0)
        {
            userRating.getItems().clear();
            for (UserListModel u : list) {
                userRating.getItems().add(u);
            }
        }
        else
        {
            Alert alert = new Alert(Alert.AlertType.ERROR, "No user matches your search", ButtonType.OK);
            alert.show();
        }
    }

}
