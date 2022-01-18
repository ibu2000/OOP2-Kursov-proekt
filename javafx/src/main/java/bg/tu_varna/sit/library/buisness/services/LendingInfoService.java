package bg.tu_varna.sit.library.buisness.services;

import bg.tu_varna.sit.library.data.entities.Eksemplqri;
import bg.tu_varna.sit.library.data.entities.LENDBOOKS;
import bg.tu_varna.sit.library.data.entities.LENDINFO;
import bg.tu_varna.sit.library.data.repositories.LendBooksRepository;
import bg.tu_varna.sit.library.data.repositories.LendingInfoRepository;
import bg.tu_varna.sit.library.presentation.models.ExemplqrModel;
import bg.tu_varna.sit.library.presentation.models.LendingBooksModel;
import bg.tu_varna.sit.library.presentation.models.LendingInfoModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.util.List;
import java.util.stream.Collectors;

public class LendingInfoService {
    private final LendingInfoRepository repositoryLendingInfo = LendingInfoRepository.getInstance();

    public static LendingInfoService getInstance() {return LendingInfoService.LendingInfoServiceHolder.INSTANCE;}




    private static class LendingInfoServiceHolder
    {
        public static final LendingInfoService INSTANCE = new LendingInfoService();
    }

    public ObservableList<LendingInfoModel> getAllLendingInfo()
    {
        List<LENDINFO> lendinfo = repositoryLendingInfo.getAll();
        ObservableList<LendingInfoModel> booklist = FXCollections.observableList(
                lendinfo.stream().map(a -> new LendingInfoModel(
                 a.getIdLendInfo(), a.getBOOKS_idBook(),a.getLENDBOOKS_idLendBook(),a.getEksemplqri_isbnUnikalenNomer(),a.isInChitalnq()
                )).collect(Collectors.toList()));
        return  booklist;
    }

    public boolean AddLendInfo(LendingInfoModel addBook) {
        List<LENDINFO> books = repositoryLendingInfo.getAll();
        LENDINFO book = new LENDINFO(addBook.getBOOKS_idBook(),addBook.getLENDBOOKS_idLendBook(),addBook.getEksemplqri_isbnUnikalenNomer(),addBook.isInChitalnq());
        for(LENDINFO b : books)
        {
            if(b.equals(book))
            {
                return false;
            }
        }
        repositoryLendingInfo.save(book);
        return true;
    }

   public LENDINFO listviewToEntity(LendingInfoModel a)
    {
        LENDINFO temp = new LENDINFO(a.getEksemplqri_isbnUnikalenNomer());

        List<LENDINFO> books = repositoryLendingInfo.getAll();
        for(LENDINFO b: books)
        {
            if(b.getEksemplqri_isbnUnikalenNomer().getIsbnUnikalenNomer()==(temp.getEksemplqri_isbnUnikalenNomer().getIsbnUnikalenNomer()))
            {
                return b;
            }
        }
        return  null;
    }

    public LendingInfoModel GetlendInfo(LendingInfoModel a)
    {    ObservableList<LendingInfoModel> allCopies = getAllLendingInfo();
        for(LendingInfoModel b : allCopies)
        {
            if(b.getEksemplqri_isbnUnikalenNomer().equals(a.getEksemplqri_isbnUnikalenNomer()))
            {
                return b;
            }
        }
        return null;
    }

    public ObservableList<LendingInfoModel> getLendingInfoByLendBook(LENDBOOKS lendingBooksModel)
    {
        ObservableList<LendingInfoModel> allCopies = getAllLendingInfo();
        ObservableList<LendingInfoModel> lendInfo = FXCollections.observableArrayList();
        for(LendingInfoModel b : allCopies)
        {
            if(b.getLENDBOOKS_idLendBook().getIdLendBook()==(lendingBooksModel.getIdLendBook()))
            {
                lendInfo.add(b);
            }
        }
        return lendInfo;

    }


    public LendingInfoModel getLendingInfoByExemplqr(Eksemplqri eksemplqr)
    {
        ObservableList<LendingInfoModel> allCopies = getAllLendingInfo();
        for(LendingInfoModel b : allCopies)
        {
            if(b.getEksemplqri_isbnUnikalenNomer().getIsbnUnikalenNomer() ==(eksemplqr.getIsbnUnikalenNomer()))
            {
                return b;
            }
        }
        return null;

    }


    public boolean Deleteinfo(LENDINFO lend) {
        List<LENDINFO> users =repositoryLendingInfo.getAll();
        for(LENDINFO u : users)
        {
            if(u.getIdLendInfo()==(lend.getIdLendInfo()))
            {
                repositoryLendingInfo.delete(u);
                return true;
            }
        }
        return false;
    }





}
