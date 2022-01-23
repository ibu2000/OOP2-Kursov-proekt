package bg.tu_varna.sit.library.presentation.controllers;

import bg.tu_varna.sit.library.buisness.services.FormService;
import bg.tu_varna.sit.library.buisness.services.UserService;
import bg.tu_varna.sit.library.common.Constants;
import bg.tu_varna.sit.library.data.entities.Books;
import bg.tu_varna.sit.library.data.entities.USER;
import bg.tu_varna.sit.library.data.entities.UserType;
import bg.tu_varna.sit.library.presentation.models.FormModel;
import bg.tu_varna.sit.library.presentation.models.UserListModel;
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
import java.util.ResourceBundle;

public class FormsController implements Initializable {
    @FXML
    private Button pending;
    @FXML
    private Button notPending;
    @FXML
    private Button buttonF_home;

    @FXML
    private TableView<FormModel> form;
    @FXML
    private TableColumn<FormModel, Long> idForm;
    @FXML
    private TableColumn<FormModel, LocalDate> submitionDate;
    @FXML
    private TableColumn<FormModel, String> content;
    @FXML
    private TableColumn<FormModel, USER> idUser;
    @FXML
    private TableColumn<FormModel, String> status;
    @FXML
    private Label iduser;
    Stage s;
    FormService formService = new FormService();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        idForm.setCellValueFactory(new PropertyValueFactory<>("idForm"));
        submitionDate.setCellValueFactory(new PropertyValueFactory<>("submitionDate"));
        content.setCellValueFactory(new PropertyValueFactory<>("content"));
        idUser.setCellValueFactory(new PropertyValueFactory<>("USER_idUser"));
        status.setCellValueFactory(new PropertyValueFactory<>("status"));
        ObservableList<FormModel> list = formService.getAllCopies();
        form.getItems().clear();
        for(FormModel u : list)
        {
            form.getItems().add(u);
        }
    }

    public FormsController() {
    }

    UserService userService = new UserService();

    USER userr;

    public void displayId(USER user) {
        iduser.setText(Long.toString(user.getIdUser()));
        userr = user;
    }

    public FormsController(Stage stage) {
        s = stage;
    }


    @FXML
    public void ShowPending() {
        idForm.setCellValueFactory(new PropertyValueFactory<>("idForm"));
        submitionDate.setCellValueFactory(new PropertyValueFactory<>("submitionDate"));
        content.setCellValueFactory(new PropertyValueFactory<>("content"));
        idUser.setCellValueFactory(new PropertyValueFactory<>("USER_idUser"));
        status.setCellValueFactory(new PropertyValueFactory<>("status"));
        ObservableList<FormModel> list = formService.GetFormsByStatus("pending");
        if(list.size()>0)
        {
            form.getItems().clear();
            for (FormModel u : list)
            {
               form.getItems().add(u);
            }
        }
        else
        {
            Alert alert = new Alert(Alert.AlertType.ERROR, "No form matches your search", ButtonType.OK);
            alert.show();
        }

    }

    @FXML
    public void ShowNotPending() {

        idForm.setCellValueFactory(new PropertyValueFactory<>("idForm"));
        submitionDate.setCellValueFactory(new PropertyValueFactory<>("submitionDate"));
        content.setCellValueFactory(new PropertyValueFactory<>("content"));
        idUser.setCellValueFactory(new PropertyValueFactory<>("USER_idUser"));
        status.setCellValueFactory(new PropertyValueFactory<>("status"));
        ObservableList<FormModel> list = formService.GetFormsByStatus("not pending");
        if(list.size()>0)
        {
            form.getItems().clear();
            for (FormModel u : list)
            {
                form.getItems().add(u);
            }
        }
        else
        {
            Alert alert = new Alert(Alert.AlertType.ERROR, "No form matches your search", ButtonType.OK);
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
