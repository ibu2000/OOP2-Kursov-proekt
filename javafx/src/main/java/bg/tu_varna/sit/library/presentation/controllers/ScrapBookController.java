package bg.tu_varna.sit.library.presentation.controllers;

import bg.tu_varna.sit.library.buisness.services.BookService;
import bg.tu_varna.sit.library.common.Constants;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class ScrapBookController implements Initializable {
    @FXML
    private ComboBox combo_box_scrap_book;
    @FXML
    private Button buttonScrapBook_scrap_book;
    @FXML
    private Button button_scrap_book;

    Stage s;
    BookService bookService = new BookService();
    public ScrapBookController() {}
    public ScrapBookController(Stage stage) {
            s = stage;
        }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        combo_box_scrap_book.getItems().clear();
        combo_box_scrap_book.getItems().addAll(bookService.getOnlyUserForComboBox());

    }
    public void ScrapBookHomeToAdmin()
    {
        try
        {
            s.close();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(Constants.View.HOMEPAGE_ADMIN));
            Stage stage = new Stage();
            fxmlLoader.setController(new HomePageAdminController(stage));
            Parent root2 = fxmlLoader.load();
            stage.setScene(new Scene(root2));
            stage.show();
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }


}