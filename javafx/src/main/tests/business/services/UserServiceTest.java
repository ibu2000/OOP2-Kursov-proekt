package business.services;


import bg.tu_varna.sit.library.buisness.services.UserService;
import bg.tu_varna.sit.library.data.entities.Status;
import bg.tu_varna.sit.library.data.entities.USER;
import bg.tu_varna.sit.library.data.entities.UserType;
import bg.tu_varna.sit.library.presentation.models.UserListModel;
import javafx.collections.ObservableList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class UserServiceTest {

    private UserService userService;
    private UserListModel userListModel;
    private UserType userType;
    private Status status;
    private USER user;
    private long a;
    private ArrayList<String> arrayList;
    private ArrayList<String> userForApproval;
    private ArrayList<String> getonlyuser;
    ObservableList<UserListModel> users;
    ObservableList<UserListModel> notLoyal;
    private boolean true1 =true;

    @BeforeEach
    void setUp()
    {
        this.userService=UserService.getInstance();
        userType = new UserType(1,"user");
        status = new Status(2,"not pending");
        userListModel = new UserListModel(1, "u1", "pas1", LocalDate.now(), "bad", userType, status);
        user = userService.FindUser(userListModel);
        a=1;
        arrayList = userService.getOnlyUserForComboBox();
        userForApproval = userService.getUserForApproval();
        getonlyuser = userService.getOnlyUserForComboBox();
        notLoyal = userService.GetUsersByLoyalty("bad");
    }

    @Test
    void getAllUsers() {
        ObservableList<UserListModel> users = userService.getAllUsers();
        assertEquals(users, userService.getAllUsers());
    }

    @Test
    void getAllUserNames() {
        ObservableList<UserListModel> users = userService.getAllUserNames();
        assertEquals(users, userService.getAllUserNames());
    }

    @Test
    void getAllFields() {
        ObservableList<UserListModel> users = userService.getAllFields();
        assertEquals(users, userService.getAllFields());
    }

    @Test
    void FindUserType() {
        assertEquals(2, userService.FindUserType(userListModel));
    }


    @Test
    void FindUser() {
        assertEquals(user, userService.FindUser(userListModel));
    }


    @Test
    void FindUserByID() {
        assertEquals(user, userService.FindUserByID(user.getIdUser()));
    }


    @Test
    void listviewToEntity() {
        assertEquals(user, userService.listviewToEntity(userListModel));
    }


    @Test
    void getUserForComboBox() {
        ArrayList<String> list = userService.getOnlyUserForComboBox();
        assertEquals(arrayList, list);
    }

    @Test
    void getUserForApproval() {
        ArrayList<String> list = userService.getUserForApproval();
        assertEquals(userForApproval,list);
    }

    @Test
    void getOnlyUserForComboBox() {
        ArrayList<String> list = userService.getOnlyUserForComboBox();
        assertEquals(getonlyuser, list);
    }

    @Test
    void UserLogin() {
        assertTrue(userService.UserLogin(userListModel));
    }

    @Test
    void AddUser() {
        assertTrue(userService.AddUser(userListModel));
    }

    @Test
    void UpdateUser() {
        assertTrue(userService.UpdateUser(userListModel));
    }

    @Test
    void CreateUser() {
        userListModel = new UserListModel(1, "u1", "pas1", LocalDate.now(), "bad", userType, status);
        assertTrue(userService.CreateUser(userListModel));
    }

    @Test
    void DeleteUser() {
        userListModel = new UserListModel(1, "u111", "pas1", LocalDate.now(), "bad", userType, status);
        assertFalse(userService.DeleteUser(userListModel));
    }

    @Test
    void GetUser() {
        UserListModel u2 = userService.GetUser("u2");
        assertEquals(u2,userService.GetUser("u2"));
    }


    @Test
    void GetUserByName() {
        USER u1 = userService.GetUserByName("u1");
        assertEquals(user,u1);
    }


    @Test
    void getUserById() {
        assertEquals(user, userService.FindUserByID(user.getIdUser()));
    }


    @Test
    void GetUsersByLoyalty() {
        users = userService.GetUsersByLoyalty("bad");
        assertEquals(users, notLoyal);
    }

    @Test
    void  MakeDisloyal() {
        userService.MakeDisloyal(user);
        assertEquals("bad" ,userService.FindUserByID(a).getRating());
    }

    @Test
    void MakeLoyal() {
        userService.MakeLoyal(user);
        assertEquals("good" ,userService.FindUserByID(a).getRating());
    }

}
