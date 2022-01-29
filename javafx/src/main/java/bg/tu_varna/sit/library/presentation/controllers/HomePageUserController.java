package bg.tu_varna.sit.library.presentation.controllers;

import bg.tu_varna.sit.library.buisness.services.UserService;
import bg.tu_varna.sit.library.common.Constants;
import bg.tu_varna.sit.library.data.entities.USER;
import bg.tu_varna.sit.library.presentation.models.UserListModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class HomePageUserController {

    @FXML
    private Button button_lend_book;
    @FXML
    private Button button_return_book;
    @FXML
    private Button button_search_books;
    @FXML
    private Button button_user_rating;
    @FXML
    private Button buttonU_logout;
    @FXML
    private Label iduser;


    UserService userService = new UserService();
    Stage s;
    public HomePageUserController()
    {}
    public HomePageUserController(Stage stage)
    {
        s = stage;
    }


    USER userr;
    public void displayId (USER user)
    {
        iduser.setText( Long.toString(user.getIdUser()));
        userr = user;
    }

    public void Test(String a)
    {
        Alert alert = new Alert(Alert.AlertType.INFORMATION, a, ButtonType.OK);
        alert.show();
    }

    public void  LendBook()
    {
        try
        {
            s.close();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(Constants.View.LEND_BOOK));
            Stage stage = new Stage();
            fxmlLoader.setController(new LendingBooksController(stage));
            Parent root2 = fxmlLoader.load();
            USER user = userService.FindUserByID(userr.getIdUser());
            LendingBooksController lendingBooksController = fxmlLoader.getController();
            lendingBooksController.displayId(userr);
            stage.setScene(new Scene(root2));
            stage.show();
            lendingBooksController.showinfo();
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public void  ReturnBook()
    {
        try
        {
            s.close();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(Constants.View.RETURN_BOOK));
            Stage stage = new Stage();
            fxmlLoader.setController(new ReturnBookController(stage));
            Parent root2 = fxmlLoader.load();
            USER user = userService.FindUserByID(userr.getIdUser());
            ReturnBookController returnBookController = fxmlLoader.getController();
            returnBookController.displayId(userr);
            stage.setScene(new Scene(root2));
            stage.show();
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    public void  SearchBooks()
    {
        try
        {
            s.close();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(Constants.View.SEARCH_BOOK));
            Stage stage = new Stage();
            fxmlLoader.setController(new SearchBooksController(stage));
            Parent root2 = fxmlLoader.load();
            USER user = userService.FindUserByID(userr.getIdUser());
            SearchBooksController searchBooksController = fxmlLoader.getController();
            searchBooksController.displayId(userr);
            stage.setScene(new Scene(root2));
            stage.show();
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public void  UserRatings()
    {
        try
        {
            s.close();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(Constants.View.USER_RATINGS));
            Stage stage = new Stage();
            fxmlLoader.setController(new UserRatingController(stage));
            Parent root2 = fxmlLoader.load();
            USER user = userService.FindUserByID(userr.getIdUser());
            UserRatingController userRatingController = fxmlLoader.getController();
            userRatingController.displayId(userr);
            stage.setScene(new Scene(root2));
            stage.show();
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    @FXML
    public void logOut() {
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
