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
        ObservableList<UserListModel> users = userService.getAllFields();
        assertEquals(users, userService.getAllFields());
    }
}
