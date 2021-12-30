package bg.tu_varna.sit.library.presentation.controllers;

import bg.tu_varna.sit.library.buisness.services.UserInfoService;
import bg.tu_varna.sit.library.buisness.services.UserService;
import bg.tu_varna.sit.library.common.Constants;
import bg.tu_varna.sit.library.presentation.models.UserInfoListModel;
import bg.tu_varna.sit.library.presentation.models.UserListModel;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
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

    Stage s;
    UserService userService = new UserService();
    UserInfoService userInfoService = new UserInfoService();
    public DeleteUserController()
    {}

    public DeleteUserController(Stage stage)
    {
        s = stage;
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
       combobox_deleteUser.getItems().clear();
       combobox_deleteUser.getItems().addAll(userService.getOnlyUserForComboBox());

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
