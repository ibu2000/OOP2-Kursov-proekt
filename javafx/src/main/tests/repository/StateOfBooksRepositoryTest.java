package repository;

import bg.tu_varna.sit.library.buisness.services.StateofBooksService;
import bg.tu_varna.sit.library.data.entities.StateOfBooks;
import bg.tu_varna.sit.library.data.repositories.StateOfBooksRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.swing.plaf.nimbus.State;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class StateOfBooksRepositoryTest {
    StateofBooksService stateofBooksService;
    private StateOfBooks stateOfBooks;
    private StateOfBooksRepository stateOfBooksRepository;
    private List<StateOfBooks> stateOfBooksList;

    @BeforeEach
    void setUp() {
        this.stateOfBooks = new StateOfBooks( "testState");

        this.stateOfBooksRepository = StateOfBooksRepository.getInstance();
        this.stateOfBooksList = stateOfBooksRepository.getAll();

    }



    @Test
    void save() {
        List<StateOfBooks> stateOfBooksList = stateOfBooksRepository.getAll();
        stateOfBooksRepository.save(stateOfBooks);
        Assertions.assertNotEquals(stateOfBooksList,stateOfBooksRepository.getAll());
    }

    @Test
    void update() {
        List<StateOfBooks> stateOfBooksList = stateOfBooksRepository.getAll();
        StateOfBooks a = stateOfBooksRepository.getByID(10);
        a.setStateOfBooks("testState10");
        long b = stateofBooksService.getBookState("testState10");
        a.setIdState(b);
        stateOfBooksRepository.update(a);
        Assertions.assertNotEquals(stateOfBooksList, stateOfBooksRepository.getAll());
    }

    @Test
    void delete() {
        List<StateOfBooks> stateOfBooksList = stateOfBooksRepository.getAll();
        stateOfBooksRepository.delete(stateOfBooks);
        List<StateOfBooks> stateOfBooksList1 = stateOfBooksRepository.getAll();
        assertEquals(stateOfBooksList, stateOfBooksList1);
    }

    @Test
    void getByID() {
        StateOfBooks a1 = stateOfBooksRepository.getByID(10);
        StateOfBooks a2 = stateOfBooksRepository.getByID(10);
        Assertions.assertNotNull(a1);
    }

    @Test
    void getAll() {
        List<StateOfBooks> all = stateOfBooksRepository.getAll();
        Assertions.assertNotNull(all);
    }
}
