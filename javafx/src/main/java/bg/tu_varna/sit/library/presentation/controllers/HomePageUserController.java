package bg.tu_varna.sit.library.presentation.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class HomePageUserController {
    Stage s;
    @FXML
    private Button button_lend_book;
    @FXML
    private Button button_return_book;
    @FXML
    private Button button_search_books;
    @FXML
    private Button button_user_rating;

    public HomePageUserController()
    {}
    public HomePageUserController(Stage stage)
    {
        s = stage;
    }
}
