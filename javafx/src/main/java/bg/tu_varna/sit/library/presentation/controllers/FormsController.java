package bg.tu_varna.sit.library.presentation.controllers;

import bg.tu_varna.sit.library.common.Constants;
import bg.tu_varna.sit.library.data.entities.Books;
import bg.tu_varna.sit.library.data.entities.USER;
import bg.tu_varna.sit.library.data.entities.UserType;
import bg.tu_varna.sit.library.presentation.models.FormModel;
import bg.tu_varna.sit.library.presentation.models.UserListModel;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

import java.time.LocalDate;

public class FormsController {
    @FXML
    private Button pending;
    @FXML
    private Button notPending;
    @FXML
    private Button buttonF_home;

    @FXML
    private TableView<FormModel> form;
    @FXML
    private TableColumn<UserListModel, Long> idForm;
    @FXML
    private TableColumn<UserListModel, LocalDate> submitionDate;
    @FXML
    private TableColumn<UserListModel, String> content;
    @FXML
    private TableColumn<UserListModel, USER> idUser;
    @FXML
    private TableColumn<UserListModel, String> status;

    Stage s;

    public FormsController() {
    }

    public FormsController(Stage stage) {
        s = stage;
    }

    @FXML
    public void  goToHomePage() {
        try {
            s.close();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(Constants.View.HOMEPAGE_OPERATOR));
            Stage stage = new Stage();
            fxmlLoader.setController(new HomePageOperatorController(stage));
            Parent root2 = fxmlLoader.load();
            stage.setScene(new Scene(root2));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
