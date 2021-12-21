package bg.tu_varna.sit.library.presentation.controllers;

import bg.tu_varna.sit.library.buisness.services.UserService;
import bg.tu_varna.sit.library.common.Constants;
import bg.tu_varna.sit.library.presentation.models.UserListModel;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
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

    public HomePageAdminController() {
    }

    public HomePageAdminController(Stage stage) {
        s = stage;
    }

    UserService service = new UserService();

    @FXML
    public void logOut() {
        try {
            s.close();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(Constants.View.SAMPLE));
            Stage stage = new Stage();
            fxmlLoader.setController(new SampleController(stage));
            Parent root2 = fxmlLoader.load();
            stage.setScene(new Scene(root2));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @FXML
    public void  addNewBook() {
        try {
            s.close();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(Constants.View.ADD_BOOKS));
            Stage stage = new Stage();
            fxmlLoader.setController(new AddNewBookController(stage));
            Parent root2 = fxmlLoader.load();
            stage.setScene(new Scene(root2));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @FXML
    public void  PromoteToOperatorPage() {
        try {
            s.close();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(Constants.View.PROMOTE_TO_OPERATOR));
            Stage stage = new Stage();
            fxmlLoader.setController(new PromoteToOperatorController(stage));
            Parent root2 = fxmlLoader.load();
            stage.setScene(new Scene(root2));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void  archiveBookPage() {
        try {
            s.close();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(Constants.View.ARCHIVE_OLD_BOOK));
            Stage stage = new Stage();
            fxmlLoader.setController(new ArchiveOldBooksController(stage));
            Parent root2 = fxmlLoader.load();
            stage.setScene(new Scene(root2));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}


