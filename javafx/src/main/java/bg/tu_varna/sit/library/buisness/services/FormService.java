package bg.tu_varna.sit.library.buisness.services;

import bg.tu_varna.sit.library.data.entities.Eksemplqri;
import bg.tu_varna.sit.library.data.entities.FORM;
import bg.tu_varna.sit.library.data.entities.USER;
import bg.tu_varna.sit.library.data.repositories.EksemplqriRepository;
import bg.tu_varna.sit.library.data.repositories.FormRepository;
import bg.tu_varna.sit.library.presentation.models.BookListModel;
import bg.tu_varna.sit.library.presentation.models.ExemplqrModel;
import bg.tu_varna.sit.library.presentation.models.FormModel;
import bg.tu_varna.sit.library.presentation.models.UserListModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.List;
import java.util.stream.Collectors;

public class FormService {


    private final FormRepository formRepository = FormRepository.getInstance();

    public static FormService getInstance() {return FormService.FormServiceHolder.INSTANCE;}



    private static class  FormServiceHolder
    {
        public static final  FormService INSTANCE = new  FormService();
    }



    public ObservableList<FormModel> getAllCopies()
    {
        List<FORM> copies = formRepository.getAll();
        ObservableList<FormModel> copylist = FXCollections.observableList(
                copies.stream().map(a -> new FormModel(
                      a.getIdForm(), a.getSubmitionDate(), a.getUSER_idUser(),a.getContent(),a.getStatus()
                )).collect(Collectors.toList()));
        return  copylist;
    }


        public boolean AddForm(FORM addCopy) {
        List<FORM> copies = formRepository.getAll();
         for(FORM e : copies)
        {
            if(e.getUSER_idUser().equals(addCopy.getUSER_idUser()))
            {
                return false;
            }
        }
        formRepository.save(addCopy);
        return true;
    }



    public FORM listviewToEntity(FormModel a)
    {

        List<FORM> copies = formRepository.getAll();
        for(FORM u: copies)
        {
            if(u.getIdForm()==a.getIdForm())
            {
                return u;
            }
        }
        return  null;
    }

    public ObservableList<FormModel> GetFormsByStatus(String a)
    {
        ObservableList<FormModel> copies = FXCollections.observableArrayList();
        ObservableList<FormModel> allUsers = getAllCopies();
        for(FormModel b : allUsers)
        {
            if(b.getStatus().equals(a))
            {
                copies.add(b);
            }
        }
        return copies;

    }


    public FormModel GetForm(USER user)
    {
        ObservableList<FormModel> allForms = getAllCopies();
        for(FormModel b : allForms)
        {
            if(b.getUSER_idUser().getUserName().equals(user.getUserName()))
            {
                return b;
            }
        }
        return null;

    }



    public boolean UpdateForm(FormModel b) {
        List<FORM> copies = formRepository.getAll();
       for(FORM u : copies)
        {
            if(u.getUSER_idUser().getUserName().equals(b.getUSER_idUser().getUserName()))
            {
                u.setStatus("not pending");
                formRepository.update(u);
                return true;
            }
        }
        return false;
    }


    public boolean DeleteForm(FormModel b) {
        List<FORM> copies = formRepository.getAll();
        for(FORM u : copies)
        {
            if(u.getUSER_idUser().getUserName().equals(b.getUSER_idUser().getUserName()))
            {

                formRepository.delete(u);
                return true;
            }
        }
        return false;
    }

}
