package bg.tu_varna.sit.library.buisness.services;

import bg.tu_varna.sit.library.data.entities.Eksemplqri;
import bg.tu_varna.sit.library.data.entities.FORM;
import bg.tu_varna.sit.library.data.repositories.EksemplqriRepository;
import bg.tu_varna.sit.library.data.repositories.FormRepository;
import bg.tu_varna.sit.library.presentation.models.ExemplqrModel;
import bg.tu_varna.sit.library.presentation.models.FormModel;
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
                      a.getIdForm(), a.getSubmitionDate(), a.getUSER_idUser(),a.getContent()
                )).collect(Collectors.toList()));
        return  copylist;
    }


        public boolean AddForm(FORM addCopy) {
        List<FORM> copies = formRepository.getAll();
         for(FORM e : copies)
        {
            if(e.equals(addCopy))
            {
                return false;
            }
        }
        formRepository.save(addCopy);
        return true;
    }



}
