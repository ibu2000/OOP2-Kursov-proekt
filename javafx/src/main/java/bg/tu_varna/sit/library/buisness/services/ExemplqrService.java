package bg.tu_varna.sit.library.buisness.services;

import bg.tu_varna.sit.library.data.entities.*;
import bg.tu_varna.sit.library.data.repositories.EksemplqriRepository;
import bg.tu_varna.sit.library.data.repositories.StateOfBooksRepository;
import bg.tu_varna.sit.library.presentation.models.BookListModel;
import bg.tu_varna.sit.library.presentation.models.ExemplqrModel;
import bg.tu_varna.sit.library.presentation.models.UserListModel;
import bg.tu_varna.sit.library.buisness.services.BookService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;

import java.util.ArrayList;
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
                        a.getIsbnUnikalenNomer(),a.getIdBook(), a.isIsitArchived(), a.getExsemplqri_stateOfBooks(),a.isIsitAvailable()
                )).collect(Collectors.toList()));
        return  copylist;
    }


    public ObservableList<ExemplqrModel> getAllDamagedCopies()
    {
        List<Eksemplqri> copies = repositoryExemplqri.getAll();
        ObservableList<ExemplqrModel> copylist = FXCollections.observableList(
                copies.stream().map(a -> new ExemplqrModel(
                        a.getIsbnUnikalenNomer(),a.getIdBook(), a.getExsemplqri_stateOfBooks()
                )).collect(Collectors.toList()));
        return  copylist;
    }




    public Eksemplqri listviewToEntity(ExemplqrModel a)
    {
       Eksemplqri temp = new Eksemplqri(a.getIsbnUnikalenNomer());
        List<Eksemplqri> copies = repositoryExemplqri.getAll();
        for(Eksemplqri u: copies)
        {
            if(u.getIsbnUnikalenNomer()==(temp.getIsbnUnikalenNomer()))
            {
                return u;
            }
        }
        return  null;
    }

    public boolean AddCopy(ExemplqrModel addCopy) {
        List<Eksemplqri> copies = repositoryExemplqri.getAll();
        Eksemplqri copy = new Eksemplqri(addCopy.getIsbnUnikalenNomer(),addCopy.getIdBook(),addCopy.getExsemplqri_stateOfBooks(),addCopy.isIsitArchived(), addCopy.isIsitAvailable());
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

  public ExemplqrModel GetCopy(ExemplqrModel a)
    {    ObservableList<ExemplqrModel> allCopies = getAllCopies();
        for(ExemplqrModel b : allCopies)
        {
            if(b.equals(a))
            {
                return b;
            }
        }
        return null;

    }


    public  ObservableList<ExemplqrModel> getBookCopyWhereDamaged()
    {
        StateOfBooks state = new StateOfBooks(3, "damaged");
        Eksemplqri e = new Eksemplqri( state,false);
        ObservableList<ExemplqrModel> allCopies = getAllCopies();
        ObservableList<ExemplqrModel> copies = FXCollections.observableArrayList();
        for(ExemplqrModel copy : allCopies)
        {
            if(copy.getExsemplqri_stateOfBooks().getStateOfBooks().equals(e.getExsemplqri_stateOfBooks().getStateOfBooks()) && !(copy.isIsitArchived()))
            {
                copies.add(copy);
            }
        }
        return copies;
    }


    public boolean ArchiveCopy(ExemplqrModel b) {
        List<Eksemplqri> copies = repositoryExemplqri.getAll();
        Eksemplqri copy = new Eksemplqri(b.getIsbnUnikalenNomer(), b.getIdBook(), b.getExsemplqri_stateOfBooks(), b.isIsitArchived(),b.isIsitAvailable());
        for(Eksemplqri u : copies)
        {
            if(u.getIsbnUnikalenNomer() == copy.getIsbnUnikalenNomer())
            {
                u.setIsitArchived(true);
                repositoryExemplqri.update(u);
                return true;
            }
        }
        return true;
    }


    public boolean DeleteCopy(ExemplqrModel addUser) {
        List<Eksemplqri> users = repositoryExemplqri.getAll();
        Eksemplqri user = new Eksemplqri(addUser.getIsbnUnikalenNomer(),addUser.getIdBook(),addUser.getExsemplqri_stateOfBooks(),addUser.isIsitArchived(),addUser.isIsitAvailable());
        for(Eksemplqri u : users)
        {
            if(u.getIsbnUnikalenNomer()==(user.getIsbnUnikalenNomer()))
            {
                repositoryExemplqri.delete(u);
                return true;
            }
        }
        return false;
    }

}
