package business.services;

import bg.tu_varna.sit.library.buisness.services.*;
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

        StateOfBooks stateOfBooks = new StateOfBooks(1,"new");

        ExemplqrModel exemplqrModel = new ExemplqrModel(38,books,false,stateOfBooks,true, LocalDate.now());
        exemplqrService.AddCopy(exemplqrModel);
        Eksemplqri eksemplqri = exemplqrService.listviewToEntity(exemplqrModel);

        LendingBooksModel lendingBooksModel = new LendingBooksModel(LocalDate.now(),user,LocalDate.now().plusDays(20));
        lendingBooksService.AddLendBook(lendingBooksModel);

        LENDBOOKS lendbooks = lendingBooksService.getLendingBooksByUser(user);

         addBook = new LendingInfoModel(eksemplqri.getIdBook(), lendbooks, eksemplqri, true);


    }

    @Test
    void getAllLendingInfo() {
        assertNotEquals(getAllLendingInfo, lendingInfoService.getAllLendingInfo());
    }


    @Test
    void AddLendInfo() {
        assertFalse(lendingInfoService.AddLendInfo(addBook));
    }


    @Test
    void listviewToEntity() {
        assertNotNull(lendingInfoService.listviewToEntity(addBook));
    }





}
