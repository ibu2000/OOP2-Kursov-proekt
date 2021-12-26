package bg.tu_varna.sit.library.buisness.services;

import bg.tu_varna.sit.library.data.entities.Books;
import bg.tu_varna.sit.library.data.entities.StateOfBooks;
import bg.tu_varna.sit.library.data.repositories.StateOfBooksRepository;
import bg.tu_varna.sit.library.data.repositories.UserRepository;
import bg.tu_varna.sit.library.presentation.models.BookListModel;
import bg.tu_varna.sit.library.presentation.models.StateOfBooksModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StateofBooksService {

    private final StateOfBooksRepository repositoryStateOfBooks = StateOfBooksRepository.getInstance();

    public static StateofBooksService getInstance() {return StateofBooksService.StateofBooksServiceHolder.INSTANCE;}

    private static class  StateofBooksServiceHolder
    {
        public static final StateofBooksService INSTANCE = new StateofBooksService();
    }



    public ObservableList<StateOfBooksModel> getAllBookStates()
    {
        List<StateOfBooks> stateOfBooks = repositoryStateOfBooks.getAll();
        ObservableList<StateOfBooksModel> stateofbooklist = FXCollections.observableList(
                stateOfBooks.stream().map(a -> new StateOfBooksModel(
                        a.getStateOfBooks()
                )).collect(Collectors.toList()));
        return  stateofbooklist;
    }



    public ArrayList<String> getBookStates()
    {
        ObservableList<StateOfBooksModel> allBooks = getAllBookStates();
        ArrayList<String> bookstate= new ArrayList<>();
        for(StateOfBooksModel state : allBooks)
        {
          bookstate.add(state.getStateOfBooks());
        }
        return bookstate;
    }
}
