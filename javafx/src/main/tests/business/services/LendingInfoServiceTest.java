package business.services;

import bg.tu_varna.sit.library.buisness.services.*;
import bg.tu_varna.sit.library.data.entities.Books;
import bg.tu_varna.sit.library.data.entities.LENDBOOKS;
import bg.tu_varna.sit.library.data.entities.USER;
import bg.tu_varna.sit.library.presentation.models.BookListModel;
import bg.tu_varna.sit.library.presentation.models.ExemplqrModel;
import bg.tu_varna.sit.library.presentation.models.LendingBooksModel;
import bg.tu_varna.sit.library.presentation.models.LendingInfoModel;
import javafx.collections.ObservableList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LendingInfoServiceTest {

    ObservableList<LendingInfoModel> getAllLendingInfo;
    LendingInfoService lendingInfoService = new LendingInfoService();
    UserService userService = new UserService();
    ExemplqrService exemplqrService = new ExemplqrService();
    LendingBooksService lendingBooksService  = new LendingBooksService();
    BookService bookService = new BookService();
    LendingInfoModel addBook;


    @BeforeEach
    void setUp()
    {
        getAllLendingInfo = lendingInfoService.getAllLendingInfo();
        long a =2;
        USER user = userService.FindUserByID(a);

        BookListModel bookListModel = new BookListModel("bName5", "author5","genre5",LocalDate.now());
        bookService.AddBook(bookListModel);
        Books books = bookService.listviewToEntity(bookListModel);

        ExemplqrModel exemplqrModel = new ExemplqrModel();

        LendingBooksModel lendingBooksModel = new LendingBooksModel(LocalDate.now(),user,LocalDate.now().plusDays(20));
        lendingBooksService.AddLendBook(lendingBooksModel);

        LENDBOOKS lendbooks = lendingBooksService.getLendingBooksByUser(user);
        LendingInfoModel addBook = new LendingInfoModel(books, lendbooks, '43', '0');

    }

    @Test
    void getAllLendingInfo() {
        assertEquals(getAllLendingInfo, lendingInfoService.getAllLendingInfo());
    }


    @Test
    void AddLendInfo() {
        assertEquals(getAllLendingInfo, lendingInfoService.getAllLendingInfo());
    }


    @Test
    void listviewToEntity() {
        assertEquals(getAllLendingInfo, lendingInfoService.getAllLendingInfo());
    }





}
