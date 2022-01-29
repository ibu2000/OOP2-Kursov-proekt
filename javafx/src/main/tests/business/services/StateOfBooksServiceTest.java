package business.services;

import bg.tu_varna.sit.library.buisness.services.StateofBooksService;
import bg.tu_varna.sit.library.presentation.models.StateOfBooksModel;
import bg.tu_varna.sit.library.presentation.models.UserListModel;
import javafx.collections.ObservableList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class StateOfBooksServiceTest {

    StateofBooksService stateofBooksService = new StateofBooksService();
    ObservableList<StateOfBooksModel> getAllBookStates;
    ArrayList<String> getBookStates;
    long a;

    @BeforeEach
    void setUp()
    {
        getAllBookStates = stateofBooksService.getAllBookStates();
        getBookStates = stateofBooksService.getBookStates();
        a = stateofBooksService.getBookState("new");
    }

    @Test
    void getAllBookStates() {
        assertEquals(getAllBookStates, stateofBooksService.getAllBookStates());
    }

    @Test
    void getBookStates() {
        assertEquals(getBookStates, stateofBooksService.getBookStates());
    }

    @Test
    void getBookState() {
        assertEquals(a, stateofBooksService.getBookState("new"));
    }

}
