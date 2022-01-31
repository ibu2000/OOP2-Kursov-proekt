package business.services;

import bg.tu_varna.sit.library.buisness.services.BookService;
import bg.tu_varna.sit.library.presentation.models.BookListModel;
import javafx.collections.ObservableList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class BookServiceTest {

    BookService bookService = new BookService();
    ObservableList<BookListModel> getAllBooks;
    ArrayList<String> getBookNames;
    BookListModel a;

    @BeforeEach
    void setUp()
    {
        getAllBooks = bookService.getAllBooks();
        getBookNames = bookService.getBookNames();
        a = getAllBooks.get(1);
    }

    @Test
    void getAllBooks() {
        assertEquals( getAllBooks, bookService.getAllBooks());
    }

    @Test
    void getBookNames() {
        assertEquals(getBookNames, bookService.getBookNames());
    }

    @Test
    void listviewToEntity() {
        assertEquals( getAllBooks, bookService.getAllBooks());
    }

    @Test
    void AddBook() {
        assertTrue(bookService.AddBook(a));
    }

    @Test
    void GetBook() {
        assertNotEquals(a, bookService.GetBook("bName1"));
    }





}
