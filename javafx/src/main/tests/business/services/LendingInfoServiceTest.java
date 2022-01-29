package business.services;

import bg.tu_varna.sit.library.buisness.services.LendingInfoService;
import bg.tu_varna.sit.library.presentation.models.LendingInfoModel;
import javafx.collections.ObservableList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LendingInfoServiceTest {

    ObservableList<LendingInfoModel> getAllLendingInfo;
    LendingInfoService lendingInfoService = new LendingInfoService();
    LendingInfoModel addBook;


    @BeforeEach
    void setUp()
    {
        getAllLendingInfo = lendingInfoService.getAllLendingInfo();
        LendingInfoModel addBook = new LendingInfoModel();
    }

    @Test
    void getAllLendingInfo() {
        assertEquals(getAllLendingInfo, lendingInfoService.getAllLendingInfo());
    }


    @Test
    void AddLendInfo() {
        assertEquals(getAllLendingInfo, lendingInfoService.getAllLendingInfo());
    }


    @Test
    void listviewToEntity() {
        assertEquals(getAllLendingInfo, lendingInfoService.getAllLendingInfo());
    }





}
