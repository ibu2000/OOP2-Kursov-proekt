package bg.tu_varna.sit.library.presentation.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.*;

public class AddNewBookController {
   @FXML
private TextField tfANB_name_of_book;
   @FXML
    private TextField tfANB_author;
    @FXML
    private TextField tfANB_genre;
    @FXML
    private TextField tfANB_year_of_publishing;
    @FXML
    private TextField tfANB_isbn;
    @FXML
    private Button buttonANB_add_book;
    @FXML
    private Button buttonANB_add_copy;
    @FXML
    private Button buttonANB_home;
    @FXML
    private ComboBox combo_boxANB_name_of_book;
    @FXML
    private ComboBox combo_boxANB_state_of_book;
    @FXML
    private RadioButton radio_buttonANB_archived;
    @FXML
    private RadioButton radio_buttonANB_not_archived;
}
