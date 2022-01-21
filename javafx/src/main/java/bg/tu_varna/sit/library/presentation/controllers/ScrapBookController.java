package bg.tu_varna.sit.library.presentation.controllers;

import bg.tu_varna.sit.library.buisness.services.BookService;
import bg.tu_varna.sit.library.buisness.services.ExemplqrService;
import bg.tu_varna.sit.library.buisness.services.UserService;
import bg.tu_varna.sit.library.common.Constants;
import bg.tu_varna.sit.library.data.entities.Books;
import bg.tu_varna.sit.library.data.entities.StateOfBooks;
import bg.tu_varna.sit.library.data.entities.USER;
import bg.tu_varna.sit.library.presentation.models.ExemplqrModel;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
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
    @FXML
    private TableView<ExemplqrModel> allDamagedBooks;
    @FXML
    private TableColumn<ExemplqrModel, Long> isbnCol;
    @FXML
    private TableColumn<ExemplqrModel, StateOfBooks> StateOfBookCol;
    @FXML
    private TableColumn<ExemplqrModel, Books> BookIdCol;

    @FXML
    private Label iduser;

    Stage s;
    ExemplqrService exemplqrService = new ExemplqrService();
    public ScrapBookController() {}
    public ScrapBookController(Stage stage) {
            s = stage;
        }


    UserService userService = new UserService();
    USER userr;
    public void displayId (USER user)
    {
        iduser.setText( Long.toString(user.getIdUser()));
        userr = user;
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


        isbnCol.setCellValueFactory(new PropertyValueFactory<>("isbnUnikalenNomer"));
        StateOfBookCol.setCellValueFactory(new PropertyValueFactory<>("exsemplqri_stateOfBooks"));
        BookIdCol.setCellValueFactory(new PropertyValueFactory<>("idBook"));

        ObservableList<ExemplqrModel> list= exemplqrService.getBookCopyWhereDamaged();
        for(ExemplqrModel u : list)
        {
            allDamagedBooks.getItems().add(u);
        }
    }

    ExemplqrModel exemplqrModel;
    @FXML
    public void getRow()
    {
        exemplqrModel = allDamagedBooks.getSelectionModel().getSelectedItem();
    }

    boolean isDeleted;
    @FXML
    public void DeleteOldBooks()
    {

        if(allDamagedBooks.getSelectionModel().getSelectedItems() != null)
        {
            isDeleted = exemplqrService.DeleteCopy(exemplqrModel);
            if (isDeleted)
            {
                Alert alert = new Alert(Alert.AlertType.INFORMATION, "The copy has been deleted!", ButtonType.OK);
                alert.show();
            }
            else
            {
                Alert alert = new Alert(Alert.AlertType.INFORMATION, "The copy has not been deleted!", ButtonType.OK);
                alert.show();
            }

        }
        else
        {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Please fill all the fields!", ButtonType.OK);
            alert.show();


        }
        allDamagedBooks.getItems().clear();
        ObservableList<ExemplqrModel> list= exemplqrService.getBookCopyWhereDamaged();
        for(ExemplqrModel u : list)
        {
            allDamagedBooks.getItems().add(u);
        }
    }

    @FXML
    public void goToHomePage() {
        try {

            USER user = userService.FindUserByID(userr.getIdUser());
            long a = user.getUSERTYPE_idUserType().getIdUserType();


            if (a == 1)
            {
                s.close();
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(Constants.View.HOMEPAGE_USER));
                Stage stage = new Stage();
                fxmlLoader.setController(new HomePageUserController(stage));
                Parent root2 = fxmlLoader.load();
                HomePageUserController homePageUserController = fxmlLoader.getController();
                homePageUserController.displayId(user);
                stage.setScene(new Scene(root2));
                stage.show();
            } else if (a == 2)
            {

                s.close();
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(Constants.View.HOMEPAGE_OPERATOR));
                Stage stage = new Stage();
                fxmlLoader.setController(new HomePageOperatorController(stage));
                Parent root2 = fxmlLoader.load();
                HomePageOperatorController homePageOperatorController = fxmlLoader.getController();
                homePageOperatorController.displayId(user);
                stage.setScene(new Scene(root2));
                stage.show();
            } else if (a == 3)
            {
                s.close();
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(Constants.View.HOMEPAGE_ADMIN));
                Stage stage = new Stage();
                fxmlLoader.setController(new HomePageAdminController(stage));
                Parent root2 = fxmlLoader.load();
                HomePageAdminController homePageAdminController = fxmlLoader.getController();
                homePageAdminController.displayId(user);
                stage.setScene(new Scene(root2));
                stage.show();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



}