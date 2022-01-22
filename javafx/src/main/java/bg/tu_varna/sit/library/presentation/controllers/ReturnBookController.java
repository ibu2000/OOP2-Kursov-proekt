package bg.tu_varna.sit.library.presentation.controllers;

import bg.tu_varna.sit.library.buisness.services.ExemplqrService;
import bg.tu_varna.sit.library.buisness.services.LendingBooksService;
import bg.tu_varna.sit.library.buisness.services.LendingInfoService;
import bg.tu_varna.sit.library.buisness.services.UserService;
import bg.tu_varna.sit.library.common.Constants;
import bg.tu_varna.sit.library.data.entities.*;
import bg.tu_varna.sit.library.presentation.models.ExemplqrModel;
import bg.tu_varna.sit.library.presentation.models.LendingBooksModel;
import bg.tu_varna.sit.library.presentation.models.LendingInfoModel;
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

public class ReturnBookController  implements Initializable {

    @FXML
    private Button buttonRAB_return_book;
    @FXML
    private Button home_button;
    @FXML
    private Button extend_lend_period_button;
    @FXML
    private Button show_lend_books_period;
    @FXML
    private TableView<ExemplqrModel> books;
    @FXML
    private TableColumn<ExemplqrModel, Long> isbn;
    @FXML
    private TableColumn<ExemplqrModel, Books> bookId;
    @FXML
    private TableColumn<ExemplqrModel, StateOfBooks> stateOfBook;
    @FXML
    private Label iduser;

    Stage s;

    public ReturnBookController() {
    }

    public ReturnBookController(Stage stage) {
        s = stage;
    }

    UserService userService = new UserService();
    LendingBooksService lendingBooksService = new LendingBooksService();
    LendingInfoService lendingInfoService = new LendingInfoService();
    ExemplqrService exemplqrService = new ExemplqrService();
    USER userr;

    public void displayId(USER user) {
        iduser.setText(Long.toString(user.getIdUser()));
        userr = user;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }

    ExemplqrModel exemplqrModel;

    @FXML
    public void showbooks() {
        books.getItems().clear();
        isbn.setCellValueFactory(new PropertyValueFactory<>("isbnUnikalenNomer"));
        bookId.setCellValueFactory(new PropertyValueFactory<>("idBook"));
        USER user = userService.FindUserByID(userr.getIdUser());
        LENDBOOKS lendingBooksModel = lendingBooksService.getLendingBooksByUser(user);
        if(lendingBooksModel == null)
        {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "You have not lent any books", ButtonType.OK);
            alert.show();
        }
        else {
            ObservableList<LendingInfoModel> lendingInfoModels = lendingInfoService.getLendingInfoByLendBook(lendingBooksModel);
            ObservableList<ExemplqrModel> exemplqrModels = exemplqrService.getLendInfoCopies(lendingInfoModels);
            for (ExemplqrModel u : exemplqrModels) {
                books.getItems().add(u);
            }
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




    @FXML
    public void ReturnBook() {
        exemplqrModel = books.getSelectionModel().getSelectedItem();
        if (exemplqrModel == null)
        {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Please select a book", ButtonType.OK);
        }
        else
        {
            Eksemplqri eksemplqr = exemplqrService.listviewToEntity(exemplqrModel);
            LendingInfoModel lendingInfoModel = lendingInfoService.getLendingInfoByExemplqr(eksemplqr);
            LENDINFO lendinfo = lendingInfoService.listviewToEntity(lendingInfoModel);
            LENDBOOKS lendbooks = lendinfo.getLENDBOOKS_idLendBook();
            if (lendingInfoService.Deleteinfo(lendinfo)) {
                exemplqrService.MakeAvailable(exemplqrModel);
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "book has been returned", ButtonType.OK);
                alert.show();
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR, "book has not been returned", ButtonType.OK);
                alert.show();
            }
            showbooks();
            if (books.getItems().size() == 0) {
                String a = iduser.getText();
                long b = Long.parseLong(a);
                USER user = userService.getUserById(b);
                boolean late = lendingBooksService.BooksNotReturnedOnTime(user);
                if (late) {
                    userService.MakeLoyal(user);

                } else {
                }
                if (lendingBooksService.DeleteLendBook(lendbooks)) {
                } else {
                    Alert alert = new Alert(Alert.AlertType.ERROR, "lend book has not been deleted", ButtonType.OK);
                    alert.show();
                }
            }
        }
    }

    @FXML
    public void getRow() {
        exemplqrModel = books.getSelectionModel().getSelectedItem();
    }


}


