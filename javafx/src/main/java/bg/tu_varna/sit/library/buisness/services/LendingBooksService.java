package bg.tu_varna.sit.library.buisness.services;
import bg.tu_varna.sit.library.data.entities.Books;
import bg.tu_varna.sit.library.data.entities.LENDBOOKS;
import bg.tu_varna.sit.library.data.repositories.LendBooksRepository;
import bg.tu_varna.sit.library.presentation.models.BookListModel;
import bg.tu_varna.sit.library.presentation.models.LendingBooksModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

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
        LENDBOOKS temp = new LENDBOOKS(a.getIdLendBook());
        List<LENDBOOKS> books = repositoryLendingBooks.getAll();
        for(LENDBOOKS b: books)
        {
            if(b.getIdLendBook()==(temp.getIdLendBook()))
            {
                return b;
            }
        }
        return  null;
    }

    public boolean AddLendBook(LENDBOOKS addBook) {
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




}
