package bg.tu_varna.sit.library.presentation.controllers;

import bg.tu_varna.sit.library.common.Constants;
import bg.tu_varna.sit.library.data.entities.Books;
import bg.tu_varna.sit.library.data.entities.StateOfBooks;
import bg.tu_varna.sit.library.presentation.models.ExemplqrModel;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

public class ReturnBookController {

@FXML
private Button buttonRAB_return_book;
@FXML
private Button buttonRAB_home;

@FXML
private TableView<ExemplqrModel> books;
@FXML
private TableColumn<ExemplqrModel, Long> isbn;
@FXML
private TableColumn<ExemplqrModel, Books> bookId;
@FXML
private TableColumn<ExemplqrModel, StateOfBooks> stateOfBook;

    Stage s;
    public ReturnBookController()
    {}
    public ReturnBookController(Stage stage)
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
