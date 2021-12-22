package bg.tu_varna.sit.library.presentation.controllers;

import bg.tu_varna.sit.library.common.Constants;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class HomePageOperatorController {

    @FXML
    private Button buttonO_lend_book;
    @FXML
    private Button buttonO_return_book;
    @FXML
    private Button buttonO_search_books;
    @FXML
    private Button buttonO_user_rating;
    @FXML
    private Button buttonO_logout;
    @FXML
    private Button button_create_user;

    Stage s;
    public HomePageOperatorController()
    {}
    public HomePageOperatorController(Stage stage)
    {
        s = stage;
    }

    public void  LendBook()
    {
        try
        {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(Constants.View.LEND_BOOK));
            Stage stage = new Stage();
            fxmlLoader.setController(new SearchBooksController(stage));
            Parent root2 = fxmlLoader.load();
            stage.setScene(new Scene(root2));
            stage.show();
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }


    public void  ReturnBook()
    {
        try
        {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(Constants.View.RETURN_BOOK));
            Stage stage = new Stage();
            fxmlLoader.setController(new ReturnBookController(stage));
            Parent root2 = fxmlLoader.load();
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
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(Constants.View.SEARCH_BOOK));
            Stage stage = new Stage();
            fxmlLoader.setController(new SearchBooksController(stage));
            Parent root2 = fxmlLoader.load();
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
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(Constants.View.USER_RATINGS));
            Stage stage = new Stage();
            fxmlLoader.setController(new UserRatingController(stage));
            Parent root2 = fxmlLoader.load();
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
    @FXML
    public void createUserPage() {
        try {
            s.close();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(Constants.View.CREATE_USER));
            Stage stage = new Stage();
            fxmlLoader.setController(new CreateUserController(stage));
            Parent root2 = fxmlLoader.load();
            stage.setScene(new Scene(root2));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @FXML
    public void deleteUserPage() {
        try {
            s.close();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(Constants.View.DELETE_USER));
            Stage stage = new Stage();
            fxmlLoader.setController(new DeleteUserController(stage));
            Parent root2 = fxmlLoader.load();
            stage.setScene(new Scene(root2));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @FXML
    public void formsPage() {
        try {
            s.close();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(Constants.View.FORMS));
            Stage stage = new Stage();
            fxmlLoader.setController(new FormsController(stage));
            Parent root2 = fxmlLoader.load();
            stage.setScene(new Scene(root2));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
