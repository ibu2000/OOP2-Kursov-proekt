package bg.tu_varna.sit.library.presentation.controllers;

import bg.tu_varna.sit.library.buisness.services.UserInfoService;
import bg.tu_varna.sit.library.buisness.services.UserService;
import bg.tu_varna.sit.library.common.Constants;
import bg.tu_varna.sit.library.data.entities.USER;
import bg.tu_varna.sit.library.presentation.models.UserInfoListModel;
import bg.tu_varna.sit.library.presentation.models.UserListModel;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class DeleteUserController implements Initializable {
    @FXML
    private Button buttonDU_delete_user;
    @FXML
    private Button buttonDU_home;
    @FXML
    private ComboBox combobox_deleteUser;
    @FXML
    private Label iduser;
    Stage s;
    UserService userService = new UserService();
    UserInfoService userInfoService = new UserInfoService();
    public DeleteUserController()
    {}

    public DeleteUserController(Stage stage)
    {
        s = stage;
    }


    USER userr;
    public void displayId (USER user)
    {
        iduser.setText( Long.toString(user.getIdUser()));
        userr = user;
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
       combobox_deleteUser.getItems().clear();
       combobox_deleteUser.getItems().addAll(userService.getOnlyUserForComboBox());

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

    boolean isDeletedUser;
    boolean isDeletedInfo;
    @FXML
    public void DeleteUser()
    {
        String username=combobox_deleteUser.getValue().toString();
        UserListModel b = userService.GetUser(username);
        UserInfoListModel a = userInfoService.getUserInfo(b);
        if(combobox_deleteUser.equals(""))
        {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Please fill all the fields!", ButtonType.OK);
            alert.show();
        }
        else
        {
            isDeletedInfo = userInfoService.DeleteUserInfo(a);
            isDeletedUser = userService.DeleteUser(b);


            if (isDeletedUser && isDeletedInfo)
            {
                Alert alert = new Alert(Alert.AlertType.INFORMATION, "The user has been deleted!", ButtonType.OK);
                alert.show();
            }
            else
            {
                Alert alert = new Alert(Alert.AlertType.INFORMATION, "The user has not been deleted!", ButtonType.OK);
                alert.show();
            }
        }
    }


}
