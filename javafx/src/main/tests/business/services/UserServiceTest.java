package business.services;


import bg.tu_varna.sit.library.buisness.services.UserService;
import bg.tu_varna.sit.library.presentation.models.UserListModel;
import javafx.collections.ObservableList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UserServiceTest {

    private UserService userService;

    @BeforeEach
    void setUp()
    {
        this.userService=UserService.getInstance();
    }

    @Test
    void getAllUsers() {
        ObservableList<UserListModel> users = userService.getAllUsers();
        assertEquals(users, userService.getAllUsers());
    }
    @Test
    void getAllUserNames() {
        ObservableList<UserListModel> users = userService.getAllUsersWithTypes();
        assertEquals(users, userService.getAllUsersWithTypes());
    }
    @Test
    void getAllUsersWithTypes() {
        ObservableList<UserListModel> users = userService.getAllUsersWithTypes();
        assertEquals(users, userService.getAllUsersWithTypes());
    }    @Test
    void getAllUsersWithTypes() {
        ObservableList<UserListModel> users = userService.getAllUsersWithTypes();
        assertEquals(users, userService.getAllUsersWithTypes());
    }    @Test
    void getAllUsersWithTypes() {
        ObservableList<UserListModel> users = userService.getAllUsersWithTypes();
        assertEquals(users, userService.getAllUsersWithTypes());
    }



}
