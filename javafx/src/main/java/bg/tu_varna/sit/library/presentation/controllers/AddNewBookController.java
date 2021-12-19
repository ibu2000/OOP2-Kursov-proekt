package bg.tu_varna.sit.library.presentation.controllers;

import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.ComboBox;
import org.apache.log4j.lf5.util.Resource;


import java.net.URL;

public class AddNewBookController implements Initializable {
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

    ObservableList<String> list = FXCollections.observableArrayList("Nova","Zapazena","Povredena");

    @Override
    public void initialize(URL url, ResourceBundle rb) {
     combo_boxANB_state_of_book.setItems(list);
    }}
