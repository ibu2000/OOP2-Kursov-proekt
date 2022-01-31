package business.services;

import bg.tu_varna.sit.library.buisness.services.LendingBooksService;
import bg.tu_varna.sit.library.buisness.services.UserService;
import bg.tu_varna.sit.library.data.entities.*;
import bg.tu_varna.sit.library.presentation.models.BookListModel;
import bg.tu_varna.sit.library.presentation.models.ExemplqrModel;
import bg.tu_varna.sit.library.presentation.models.LendingBooksModel;
import bg.tu_varna.sit.library.presentation.models.LendingInfoModel;
import javafx.collections.ObservableList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class LendingBooksServiceTest {

    LendingBooksService lendingBooksService = new LendingBooksService();
    ObservableList<LendingBooksModel> getAllLendingBooks;
    LENDBOOKS listviewToEntity;
    LendingBooksModel lendingBooksModel;
    LendingBooksModel lendingBooksModel1;
    UserService userService = new UserService();


    @BeforeEach
    void setUp()
    {
        getAllLendingBooks = lendingBooksService.getAllLendingBooks();
        lendingBooksModel = getAllLendingBooks.get(1);
        listviewToEntity = lendingBooksService.listviewToEntity(lendingBooksModel);
        lendingBooksModel1 = lendingBooksModel;
        long a =7;
        USER user = userService.getUserById(a);
        lendingBooksModel1.setUSER_idUser(user);
        lendingBooksService.AddLendBook(lendingBooksModel1);

    }

    @Test
    void getAllLendingBooks() {
        assertNotNull(lendingBooksService.getAllLendingBooks());
    }

    @Test
    void listviewToEntity() {
        assertNotNull(lendingBooksService.listviewToEntity(lendingBooksModel));
    }

    @Test
    void AddLendBook() {
        assertTrue(lendingBooksService.AddLendBook(lendingBooksModel1));
    }

    @Test
    void DeleteLendBook() {
        LENDBOOKS lendbooks = lendingBooksService.listviewToEntity(lendingBooksModel1);
        assertTrue(lendingBooksService.DeleteLendBook(lendbooks));
    }

    @Test
    void getLendingBooksByUser() {
        USER user = lendingBooksModel.getUSER_idUser();
        assertNotNull(lendingBooksService.getLendingBooksByUser(user));
    }

    @Test
    void  BooksNotReturnedOnTime() {
        USER user = lendingBooksModel1.getUSER_idUser();
        assertTrue(lendingBooksService.BooksNotReturnedOnTime(user));
    }



}
