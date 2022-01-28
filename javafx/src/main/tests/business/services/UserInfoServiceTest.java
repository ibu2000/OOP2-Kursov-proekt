package business.services;


import bg.tu_varna.sit.library.buisness.services.UserInfoService;
import bg.tu_varna.sit.library.buisness.services.UserService;
import bg.tu_varna.sit.library.data.entities.Status;
import bg.tu_varna.sit.library.data.entities.USER;
import bg.tu_varna.sit.library.data.entities.UserType;
import bg.tu_varna.sit.library.presentation.models.UserInfoListModel;
import bg.tu_varna.sit.library.presentation.models.UserListModel;
import javafx.collections.ObservableList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

public class UserInfoServiceTest {

    UserService userService = new UserService();
    UserInfoService userInfoService = new UserInfoService();
    ObservableList<UserInfoListModel> getAllUserInfo;
    private UserInfoListModel getUserInfo;
    private UserInfoListModel addUserInfo;
    private UserListModel userListModel;
    private UserListModel userListModel1;
    private UserType userType;
    private Status status;

    @BeforeEach
    void setUp()
    {
        getAllUserInfo = userInfoService.getAllUserInfo();
        userType = new UserType(1,"user");
        status = new Status(2,"not pending");
        userListModel = new UserListModel(1, "u1", "pas1", LocalDate.now(), "bad", userType, status);
        getUserInfo = userInfoService.getUserInfo(userListModel);
        userListModel1 = userService.GetUser("u1");
        USER user = userService.listviewToEntity(userListModel1);
        addUserInfo = new UserInfoListModel(user,"u1", "0897074658", "mail");
    }

    @Test
    void getAllUserInfo() {
        assertEquals(getUserInfo,userInfoService.getUserInfo(userListModel));
    }


    @Test
    void  AddUserInfo() {
        assertTrue(userInfoService.AddUserInfo(addUserInfo));
    }


    @Test
    void  DeleteUserInfo() {
        assertTrue(userInfoService.DeleteUserInfo(addUserInfo));
    }




}
