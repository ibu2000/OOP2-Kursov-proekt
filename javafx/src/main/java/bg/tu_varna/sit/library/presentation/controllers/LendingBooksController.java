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

public class LendingBooksController {

    @FXML
    private ComboBox combo_boxLB_username;
    @FXML
    private Button buttonLB_lend_book;
    @FXML
    private Button buttonLB_home;
    @FXML
    private RadioButton radio_button_reading_room;
    @FXML
    private RadioButton radio_button_read_at_home;

    @FXML
    private TableView<ExemplqrModel> allBooks;
    @FXML
    private TableColumn<ExemplqrModel, Long> isbnAll;
    @FXML
    private TableColumn<ExemplqrModel, Books> bookIdAll;
    @FXML
    private TableColumn<ExemplqrModel, StateOfBooks> stateOfBookAll;

    @FXML
    private TableView<ExemplqrModel> lendBooks;
    @FXML
    private TableColumn<ExemplqrModel, Long> isbnLend;
    @FXML
    private TableColumn<ExemplqrModel, Books> bookIdLend;
    @FXML
    private TableColumn<ExemplqrModel, StateOfBooks> stateOfBookLend;


    Stage s;
    public LendingBooksController() {}
    public LendingBooksController(Stage stage)
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

    @FXML
    public void getRow()
    {
        exemplqrModel = allBooks.getSelectionModel().getSelectedItem();
    }

    ExemplqrModel exemplqrModel;



}
