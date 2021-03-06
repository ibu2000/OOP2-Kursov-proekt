package bg.tu_varna.sit.library.presentation.controllers;

import bg.tu_varna.sit.library.buisness.services.BookService;
import bg.tu_varna.sit.library.buisness.services.ExemplqrService;
import bg.tu_varna.sit.library.buisness.services.UserService;
import bg.tu_varna.sit.library.common.Constants;
import bg.tu_varna.sit.library.data.entities.Books;
import bg.tu_varna.sit.library.data.entities.Eksemplqri;
import bg.tu_varna.sit.library.data.entities.StateOfBooks;
import bg.tu_varna.sit.library.data.entities.USER;
import bg.tu_varna.sit.library.data.repositories.DAORepository;
import bg.tu_varna.sit.library.presentation.models.ExemplqrModel;
import bg.tu_varna.sit.library.presentation.models.UserListModel;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.net.URL;
import java.time.LocalDate;
import java.util.Date;
import java.util.ResourceBundle;

public class ArchiveOldBooksController implements Initializable {
    @FXML
    private Button buttonAOB_archive_old_book;
    @FXML
    private Button buttonAOB_home;
    @FXML
    private ComboBox combobox_bookName;
    @FXML
    private ComboBox<ExemplqrModel> combobox_copyOfBook;
    @FXML
    private TableView<ExemplqrModel> allDamagedBooks;
    @FXML
    private TableColumn<ExemplqrModel, Long> isbnCol;
    @FXML
    private TableColumn<ExemplqrModel, StateOfBooks> StateOfBookCol;
    @FXML
    private TableColumn<ExemplqrModel, Books> BookIdCol;
    @FXML
    private TableColumn<ExemplqrModel, LocalDate>  YearofpublishingCol;
    @FXML
    private DatePicker year_of_publishing;
    @FXML
    private Label iduser;

    LocalDate publishDate;
    BookService bookService = new BookService();
    ExemplqrService exemplqrService = new ExemplqrService();
    Stage s;

    public ArchiveOldBooksController() {
    }

    public ArchiveOldBooksController(Stage stage) {
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

    }


    @FXML
    public void getRow()
    {
        exemplqrModel = allDamagedBooks.getSelectionModel().getSelectedItem();
    }
    @FXML
    public void getDate()
    {
        publishDate  = year_of_publishing.getValue();
        allDamagedBooks.getItems().clear();
        ObservableList<ExemplqrModel> list= exemplqrService.getBookOldCopy(publishDate);
        for(ExemplqrModel u : list)
        {
            allDamagedBooks.getItems().add(u);
        }
    }
    ExemplqrModel exemplqrModel;
    boolean isitAvailable = true;
    boolean isArchived;

    public void showBooks()
    {
        isbnCol.setCellValueFactory(new PropertyValueFactory<>("isbnUnikalenNomer"));
        StateOfBookCol.setCellValueFactory(new PropertyValueFactory<>("exsemplqri_stateOfBooks"));
        BookIdCol.setCellValueFactory(new PropertyValueFactory<>("idBook"));
        YearofpublishingCol.setCellValueFactory(new PropertyValueFactory<>("copyDate"));
        LocalDate date =LocalDate.of(1970, 1, 1);
        ObservableList<ExemplqrModel> list= exemplqrService.getBookOldCopy(date);
        if(list.size()>0)
        {
            for (ExemplqrModel u : list) {
                allDamagedBooks.getItems().add(u);
            }
        }
        else
        {
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Currently there are no old books. If you want to archive other books you can do that by selecting a date", ButtonType.OK);
            alert.show();
        }
    }

    @FXML
    public void ArchiveOldBooks()
    {

        if(allDamagedBooks.getSelectionModel().getSelectedItems() != null)
        {
            isArchived = exemplqrService.ArchiveCopy(exemplqrModel);
            if (isArchived)
            {
              Alert alert = new Alert(Alert.AlertType.INFORMATION, "The copy has been archived!", ButtonType.OK);
                alert.show();
            }
            else
            {
               Alert alert = new Alert(Alert.AlertType.INFORMATION, "The copy has not been archived!", ButtonType.OK);
                alert.show();
            }

        }
        else
        {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Please fill all the fields!", ButtonType.OK);
            alert.show();


        }
        allDamagedBooks.getItems().clear();
        ObservableList<ExemplqrModel> list= exemplqrService.getBookOldCopy(publishDate);
        if(list.size()>0)
        {
            for (ExemplqrModel u : list) {
                allDamagedBooks.getItems().add(u);
            }
        }
        else
        {
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Currently there are no old books. If you want to archive other books you can do that by selecting a date", ButtonType.OK);
            alert.show();
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
