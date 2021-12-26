package bg.tu_varna.sit.library.buisness.services;

import bg.tu_varna.sit.library.data.entities.Books;
import bg.tu_varna.sit.library.data.entities.USER;
import bg.tu_varna.sit.library.data.repositories.BooksRepository;
import bg.tu_varna.sit.library.presentation.models.BookListModel;
import bg.tu_varna.sit.library.presentation.models.UserListModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BookService {


    private final BooksRepository repositoryBook = BooksRepository.getInstance();

    public static BookService getInstance() {return BookService.BookServiceHolder.INSTANCE;}



    private static class BookServiceHolder
    {
        public static final BookService INSTANCE = new BookService();
    }

    public ObservableList<BookListModel> getAllBooks()
    {
        List<Books> books = repositoryBook.getAll();
        ObservableList<BookListModel> booklist = FXCollections.observableList(
                books.stream().map(a -> new BookListModel(
                        a.getBookName()
                )).collect(Collectors.toList()));
        return  booklist;
    }

    public ArrayList<String> getBookNames()
    {
        ObservableList<BookListModel> allBooks = getAllBooks();
        ArrayList<String> booknames = new ArrayList<>();
        for(BookListModel book : allBooks)
        {
           booknames.add(book.getBookName());
        }
        return booknames;
    }

    public ArrayList<String> getBookStates()
    {
        ObservableList<BookListModel> allBooks = getAllBooks();
        ArrayList<String> bookstate= new ArrayList<>();
        for(BookListModel book : allBooks)
        {
            bookstate.add(book.getB);
        }
        return bookstate;
    }
    public boolean AddBook(BookListModel addBook) {
        List<Books> books = repositoryBook.getAll();
        Books book = new Books(addBook.getBookName(), addBook.getAuthor(), addBook.getGenre(), addBook.getYearOfPublishing());
        for(Books b : books)
        {
            if(b.equals(book))
            {
                return false;
            }
        }
        repositoryBook.save(book);
        return true;
    }

}
