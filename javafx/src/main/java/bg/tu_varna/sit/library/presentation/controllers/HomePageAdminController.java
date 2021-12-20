package bg.tu_varna.sit.library.presentation.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class HomePageAdminController {
    @FXML
    private Button button_create_operator;
    @FXML
    private Button button_scrapping;
    @FXML
    private Button button_add_new_book;
    @FXML
    private Button button_archive_old_books;
    @FXML
    private Button buttonA_lend_book;
    @FXML
    private Button buttonA_return_book;
    @FXML
    private Button buttonA_search_books;
    @FXML
    private Button buttonA_user_rating;
    @FXML
    private Button buttonA_logout;

    Stage s;
    public HomePageAdminController()
    {}
    public HomePageAdminController(Stage stage)
    {
        s = stage;
    }


}
