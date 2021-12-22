package bg.tu_varna.sit.library.presentation.controllers;

import bg.tu_varna.sit.library.common.Constants;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

public class SearchBooksController {
    @FXML
private Button buttonSB_home;
    Stage s;
    @FXML
    private TextArea text_area_search_books;
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
