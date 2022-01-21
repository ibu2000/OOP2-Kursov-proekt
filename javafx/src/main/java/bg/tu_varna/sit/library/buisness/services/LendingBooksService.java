package bg.tu_varna.sit.library.buisness.services;
import bg.tu_varna.sit.library.data.entities.Books;
import bg.tu_varna.sit.library.data.entities.LENDBOOKS;
import bg.tu_varna.sit.library.data.entities.LENDINFO;
import bg.tu_varna.sit.library.data.entities.USER;
import bg.tu_varna.sit.library.data.repositories.LendBooksRepository;
import bg.tu_varna.sit.library.presentation.models.BookListModel;
import bg.tu_varna.sit.library.presentation.models.LendingBooksModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class LendingBooksService {

private final LendBooksRepository repositoryLendingBooks = LendBooksRepository.getInstance();

public static LendingBooksService getInstance() {return LendingBooksService.LendingBooksServiceHolder.INSTANCE;}

    private static class LendingBooksServiceHolder
{
   public static final LendingBooksService INSTANCE = new LendingBooksService();
}


public ObservableList<LendingBooksModel> getAllLendingBooks()
{
    List<LENDBOOKS> lendbooks = repositoryLendingBooks.getAll();
    ObservableList<LendingBooksModel> booklist = FXCollections.observableList(
        lendbooks.stream().map(a -> new LendingBooksModel(
           a.getIdLendBook(),a.getDateOfTaking(), a.getUSER_idUser(), a.getDateOfreturn()
           )).collect(Collectors.toList()));
        return  booklist;
}


    public LENDBOOKS listviewToEntity(LendingBooksModel a)
    {
        LENDBOOKS temp = new LENDBOOKS(a.getDateOfTaking(),a.getUSER_idUser(),a.getDateOfreturn());
        List<LENDBOOKS> books = repositoryLendingBooks.getAll();
        for(LENDBOOKS b: books)
        {
            if(b.getDateOfTaking().equals(temp.getDateOfTaking()) && b.getUSER_idUser().equals(temp.getUSER_idUser())
            && b.getDateOfreturn().equals(temp.getDateOfreturn()))
            {
                return b;
            }
        }
        return  null;
    }

    public boolean AddLendBook(LendingBooksModel addBook) {
        List<LENDBOOKS> books = repositoryLendingBooks.getAll();
        LENDBOOKS book = new LENDBOOKS(addBook.getIdLendBook(), addBook.getDateOfTaking(),addBook.getUSER_idUser(),addBook.getDateOfreturn());
        for(LENDBOOKS b : books)
        {
            if(b.equals(book))
            {
                return false;
            }
        }
        repositoryLendingBooks.save(book);
        return true;
    }

    public LENDBOOKS getLendingBooksByUser(USER user) {
        List<LENDBOOKS> books = repositoryLendingBooks.getAll();
        for(LENDBOOKS b : books)
        {
            if(b.getUSER_idUser().getIdUser()==(user.getIdUser()))
            {
                return b;
            }
        }
        return null;
    }

    public boolean DeleteLendBook(LENDBOOKS lendbooks) {
        List<LENDBOOKS> users =repositoryLendingBooks.getAll();
        for(LENDBOOKS u : users)
        {
            if(u.getIdLendBook()==(lendbooks.getIdLendBook()))
            {
                repositoryLendingBooks.delete(u);
                return true;
            }
        }
        return false;
    }



}
