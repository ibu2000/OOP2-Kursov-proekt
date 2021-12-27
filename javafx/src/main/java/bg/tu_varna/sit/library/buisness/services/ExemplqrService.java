package bg.tu_varna.sit.library.buisness.services;

import bg.tu_varna.sit.library.data.entities.Books;
import bg.tu_varna.sit.library.data.entities.Eksemplqri;
import bg.tu_varna.sit.library.data.repositories.EksemplqriRepository;
import bg.tu_varna.sit.library.data.repositories.StateOfBooksRepository;
import bg.tu_varna.sit.library.presentation.models.BookListModel;
import bg.tu_varna.sit.library.presentation.models.ExemplqrModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.List;
import java.util.stream.Collectors;

public class ExemplqrService {

    private final EksemplqriRepository repositoryExemplqri = EksemplqriRepository.getInstance();

    public static ExemplqrService getInstance() {return ExemplqrService.ExemplqrServiceHolder.INSTANCE;}

    private static class  ExemplqrServiceHolder
    {
        public static final  ExemplqrService INSTANCE = new  ExemplqrService();
    }


    public ObservableList<ExemplqrModel> getAllCopies()
    {
        List<Eksemplqri> copies = repositoryExemplqri.getAll();
        ObservableList<ExemplqrModel> copylist = FXCollections.observableList(
                copies.stream().map(a -> new ExemplqrModel(
                        a.getIsbnUnikalenNomer(),a.getIdBook(), a.isIsitArchived(), a.getExsemplqri_stateOfBooks()
                )).collect(Collectors.toList()));
        return  copylist;
    }


    public boolean AddCopy(ExemplqrModel addCopy) {
        List<Eksemplqri> copies = repositoryExemplqri.getAll();
        Eksemplqri copy = new Eksemplqri(addCopy.getIsbnUnikalenNomer(),addCopy.getIdBook(),addCopy.getExsemplqri_stateOfBooks(),addCopy.isIsitArchived());
        for(Eksemplqri e : copies)
        {
            if(e.equals(copy))
            {
                return false;
            }
        }
        repositoryExemplqri.save(copy);
        return true;
    }

}
