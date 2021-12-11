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
    private Button button_create_user;
    @FXML
    private Button button_delete_user;
    @FXML
    private Button button_forms;


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
            s.close();
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
            s.close();
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
            s.close();
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
            s.close();
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

}
