package bg.tu_varna.sit.library.presentation.controllers;

import bg.tu_varna.sit.library.common.Constants;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;

public class ScrapBookController {
    @FXML
    private ComboBox combo_box_scrap_book;
    @FXML
    private Button buttonScrapBook_scrap_book;
    @FXML
    private Button button_scrap_book;

    Stage s;

    public ScrapBookController() {}
    public ScrapBookController(Stage stage) {
            s = stage;
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