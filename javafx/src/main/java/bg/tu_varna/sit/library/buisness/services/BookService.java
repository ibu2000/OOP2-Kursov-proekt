package bg.tu_varna.sit.library.buisness.services;

import bg.tu_varna.sit.library.data.entities.Books;
import bg.tu_varna.sit.library.data.repositories.BooksRepository;
import bg.tu_varna.sit.library.data.repositories.UserRepository;
import bg.tu_varna.sit.library.presentation.models.BookListModel;

import java.util.List;

public class BookService {


    private final BooksRepository repositoryBook = BooksRepository.getInstance();

    public static BookService getInstance() {return BookService.BookServiceHolder.INSTANCE;}



    private static class BookServiceHolder
    {
        public static final BookService INSTANCE = new BookService();
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
