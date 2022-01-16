package bg.tu_varna.sit.library.presentation.controllers;

import bg.tu_varna.sit.library.buisness.services.*;
import bg.tu_varna.sit.library.common.Constants;
import bg.tu_varna.sit.library.data.entities.*;
import bg.tu_varna.sit.library.presentation.models.*;
import javafx.collections.FXCollections;
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
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.ResourceBundle;

public class LendingBooksController implements Initializable {

    @FXML
    private ComboBox combo_boxLB_username;
    @FXML
    private Label iduser;
    @FXML
    private Button buttonLB_lend_book;
    @FXML
    private Button button_Home;
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

    UserService userService = new UserService();
    ExemplqrService exemplqrService = new ExemplqrService();
    BookService bookService = new BookService();
    LendingBooksService lendingBooksService = new LendingBooksService();
    LendingInfoService lendingInfoService = new LendingInfoService();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        isbnAll.setCellValueFactory(new PropertyValueFactory<>("isbnUnikalenNomer"));
        bookIdAll.setCellValueFactory(new PropertyValueFactory<>("idBook"));

        ObservableList<ExemplqrModel> list = exemplqrService.getAvailableCopy();
        for(ExemplqrModel u : list)
        {
            allBooks.getItems().add(u);
        }
        combo_boxLB_username.getItems().clear();
        combo_boxLB_username.getItems().addAll(userService.getUserForComboBox());
    }

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

    USER userr;
    public void displayId (USER user)
    {
        iduser.setText( Long.toString(user.getIdUser()));
        userr = user;
    }


    @FXML
    public void getRow()
    {
        exemplqrModel = allBooks.getSelectionModel().getSelectedItem();
    }
    ExemplqrModel exemplqrModel;

    boolean isAvailable;

    @FXML
    public void addCopyToLendList()
    {   isbnLend.setCellValueFactory(new PropertyValueFactory<>("isbnUnikalenNomer"));
        bookIdLend.setCellValueFactory(new PropertyValueFactory<>("idBook"));
        ObservableList<ExemplqrModel> toBeTaken = FXCollections.observableArrayList();
        ExemplqrModel selectedItem = allBooks.getSelectionModel().getSelectedItem();
        toBeTaken.add(selectedItem);
        allBooks.getItems().remove(selectedItem);
        ObservableList<ExemplqrModel> list= exemplqrService.getAvailableCopy();
        for(ExemplqrModel u : toBeTaken)
        {
            lendBooks.getItems().add(u);
        }
    }


    LendingBooksModel lend;
    @FXML
    public void select()
    {/*
        LocalDate dateOfTaking = LocalDate.now();
        UserListModel u = userService.GetUser(combo_boxLB_username.getValue().toString());
        USER user = userService.listviewToEntity(u);
        lend = new LendingBooksModel(dateOfTaking,user,dateOfTaking.plusDays(20));*/
    }

    boolean inChitalnq;
    boolean notSaved;
    @FXML
    public void LendCopies() {
        if (radio_button_read_at_home.isSelected()) {
            inChitalnq = false;
        } else if (radio_button_reading_room.isSelected()) {
            inChitalnq = true;
        }
        LocalDate dateOfTaking = LocalDate.now();
        USER user = userService.FindUserByID(userr.getIdUser());
        lend = new LendingBooksModel(dateOfTaking,user,dateOfTaking.plusDays(20));
        lendingBooksService.AddLendBook(lend);
        LENDBOOKS le = lendingBooksService.listviewToEntity(lend);
        ObservableList<ExemplqrModel> listOfCopies = lendBooks.getItems();

        for (ExemplqrModel uu : listOfCopies)
        {
            Eksemplqri eks = exemplqrService.listviewToEntity(uu);
            LendingInfoModel lendingInfoModel = new LendingInfoModel(uu.getIdBook(), le, eks, inChitalnq);
            notSaved = lendingInfoService.AddLendInfo(lendingInfoModel);
            exemplqrService.MakeUnavailable(uu);
            if (!notSaved) {
                Alert alert = new Alert(Alert.AlertType.ERROR, "lend info has not been saved", ButtonType.OK);
                alert.show();
            }
        }
        Alert alert = new Alert(Alert.AlertType.ERROR, "lend info has been saved", ButtonType.OK);
        alert.show();

    }



    @FXML
    public void goToHomePage() {
        try {
            s.close();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(Constants.View.HOMEPAGE_USER));
            Stage stage = new Stage();
            fxmlLoader.setController(new HomePageUserController(stage));
            Parent root2 = fxmlLoader.load();
            USER user = userService.FindUserByID(userr.getIdUser());
            HomePageUserController homePageUserController = fxmlLoader.getController();
            homePageUserController.displayId(user);
            stage.setScene(new Scene(root2));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



}
