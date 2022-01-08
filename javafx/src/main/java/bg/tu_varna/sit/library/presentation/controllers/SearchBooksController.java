package bg.tu_varna.sit.library.presentation.controllers;

import bg.tu_varna.sit.library.common.Constants;
import bg.tu_varna.sit.library.data.entities.Books;
import bg.tu_varna.sit.library.data.entities.StateOfBooks;
import bg.tu_varna.sit.library.presentation.models.ExemplqrModel;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import org.w3c.dom.Text;

import java.time.LocalDate;

public class SearchBooksController {
    @FXML
    private Button buttonSB_home;
    @FXML
    private Button buttonSB_searchBook;
    @FXML
    private TextField tfSB_search_book;

    @FXML
    private TableView<ExemplqrModel> allBooks;
    @FXML
    private TableColumn<ExemplqrModel, Long> isbn;
    @FXML
    private TableColumn<ExemplqrModel, StateOfBooks> stateOfBook;
    @FXML
    private TableColumn<ExemplqrModel, String> author;
    @FXML
    private TableColumn<ExemplqrModel, String> genre;
    @FXML
    private TableColumn<ExemplqrModel, LocalDate> yearOfRelease;


    Stage s;

    public SearchBooksController()
    {}
    public SearchBooksController(Stage stage)
    {
        s = stage;
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
