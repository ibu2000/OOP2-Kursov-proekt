package bg.tu_varna.sit.library.presentation.controllers;

import bg.tu_varna.sit.library.buisness.services.LendingBooksService;
import bg.tu_varna.sit.library.buisness.services.LendingInfoService;
import bg.tu_varna.sit.library.buisness.services.UserService;
import bg.tu_varna.sit.library.common.Constants;
import bg.tu_varna.sit.library.data.entities.*;
import bg.tu_varna.sit.library.presentation.models.ExemplqrModel;
import bg.tu_varna.sit.library.presentation.models.LendingInfoModel;
import bg.tu_varna.sit.library.presentation.models.UserInfoListModel;
import bg.tu_varna.sit.library.presentation.models.UserListModel;
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
import java.time.LocalDate;
import java.util.Date;
import java.util.ResourceBundle;

public class SearchUserInfoController  implements Initializable {

    @FXML
    private Label iduser;
    @FXML
    private TextField text_field;

    @FXML
    private TableView<UserListModel> userInfo;
    @FXML
    private TableColumn<UserListModel, String> username;
    @FXML
    private TableColumn<UserListModel, LocalDate> dateOfUserApproval;
    @FXML
    private TableColumn<UserListModel, String> rating;
    @FXML
    private TableColumn<UserListModel, UserType> usertype;

    @FXML
    private TableView<LendingInfoModel> lendInfo;
    @FXML
    private TableColumn<LendingInfoModel, Long> idLendInfo;
    @FXML
    private TableColumn<LendingInfoModel, LENDBOOKS> idLendBook;
    @FXML
    private TableColumn<LendingInfoModel, Eksemplqri> isbn;
    @FXML
    private TableColumn<LendingInfoModel, Books> idBook;

    UserService userService = new UserService();
    LendingBooksService lendingBooksService = new LendingBooksService();
    LendingInfoService lendingInfoService = new LendingInfoService();
    Stage s;

    public SearchUserInfoController()
    {}
    public SearchUserInfoController(Stage stage)
    {
        s = stage;
    }

    USER userr;
    public void displayId (USER user)
    {
        iduser.setText( Long.toString(user.getIdUser()));
        userr = user;
    }

    @FXML
    public void SearchUser()
    {
        username.setCellValueFactory(new PropertyValueFactory<>("userName"));
        dateOfUserApproval.setCellValueFactory(new PropertyValueFactory<>("dateOfUserApproval"));
        rating.setCellValueFactory(new PropertyValueFactory<>("rating"));
        usertype.setCellValueFactory(new PropertyValueFactory<>("USERTYEPE_idUserType"));
        USER user= userService.GetUserByName(text_field.getText());
        if(user == null)
        {
            Alert alert = new Alert(Alert.AlertType.ERROR, "No such user exists", ButtonType.OK);
            alert.show();
        }
        else {
            userInfo.getItems().clear();
            UserListModel userListModel = new UserListModel(user.getIdUser(), user.getUserName(), user.getPassword(), user.getDateOfUserApproval(), user.getRating(), user.getUSERTYPE_idUserType(), user.getSTATUS_idStatus());
            userInfo.getItems().add(userListModel);

            lendInfo.getItems().clear();
            isbn.setCellValueFactory(new PropertyValueFactory<>("eksemplqri_isbnUnikalenNomer"));
            idBook.setCellValueFactory(new PropertyValueFactory<>("BOOKS_idBook"));
            idLendInfo.setCellValueFactory(new PropertyValueFactory<>("idLendInfo"));
            idLendBook.setCellValueFactory(new PropertyValueFactory<>("LENDBOOKS_idLendBook"));

            LENDBOOKS lendbooks = lendingBooksService.getLendingBooksByUser(user);
            ObservableList<LendingInfoModel> lendInfos = lendingInfoService.getLendingInfoByLendBook(lendbooks);
            if(lendInfos.size() > 0)
            {
                lendInfo.getItems().clear();
                for (LendingInfoModel u : lendInfos) {
                    lendInfo.getItems().add(u);
                }
            }
            else
            {
                Alert alert = new Alert(Alert.AlertType.ERROR, "This user hasn't lend any books", ButtonType.OK);
                alert.show();
            }
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        username.setCellValueFactory(new PropertyValueFactory<>("userName"));
        dateOfUserApproval.setCellValueFactory(new PropertyValueFactory<>("dateOfUserApproval"));
        rating.setCellValueFactory(new PropertyValueFactory<>("rating"));
        usertype.setCellValueFactory(new PropertyValueFactory<>("USERTYEPE_idUserType"));
        ObservableList<UserListModel> list = userService.getAllFields();
        userInfo.getItems().clear();
        for (UserListModel u : list) {
            userInfo.getItems().add(u);
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
