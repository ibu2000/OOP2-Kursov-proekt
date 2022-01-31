package business.services;

import bg.tu_varna.sit.library.buisness.services.ExemplqrService;
import bg.tu_varna.sit.library.buisness.services.LendingInfoService;
import bg.tu_varna.sit.library.data.entities.FORM;
import bg.tu_varna.sit.library.presentation.models.ExemplqrModel;
import javafx.collections.ObservableList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class ExemplqrServiceTest {

    LendingInfoService lendingInfoService = new LendingInfoService();
    ExemplqrService exemplqrService = new ExemplqrService();
    ObservableList<ExemplqrModel> getAllCopies;
    ObservableList<ExemplqrModel> getAllDamagedCopies;
    ExemplqrModel exemplqrModel;
    ObservableList<ExemplqrModel> getBookOldCopy;
    ObservableList<ExemplqrModel> getAvailableCopy;
    ObservableList<ExemplqrModel> getBookCopyWhereDamaged;
    ObservableList<ExemplqrModel> getLendInfoCopies;
    ObservableList<ExemplqrModel> getBookArchivedCopies;
    ObservableList<ExemplqrModel> getBookUnArchivedCopies;
    ObservableList<ExemplqrModel> getCopiesByBookName;
    ObservableList<ExemplqrModel> getCopiesByBookNameandState;
    long s;

    @BeforeEach
    void setUp()
    {
        getAllCopies = exemplqrService.getAllCopies();
        getAllDamagedCopies = exemplqrService.getAllDamagedCopies();
        exemplqrModel = getAllCopies.get(1);
        getBookOldCopy = exemplqrService.getBookOldCopy(LocalDate.now().minusYears(50));
        getAvailableCopy = exemplqrService.getAvailableCopy();
        getBookCopyWhereDamaged = exemplqrService.getBookCopyWhereDamaged();
        getLendInfoCopies = exemplqrService.getLendInfoCopies(lendingInfoService.getAllLendingInfo());
        getBookArchivedCopies = exemplqrService.getBookArchivedCopies(getAllCopies);
        getBookUnArchivedCopies = exemplqrService.getBookUnArchivedCopies(getAllCopies);
        getCopiesByBookName = exemplqrService.getCopiesByBookName("bName1");
        s = 2;
        getCopiesByBookNameandState = exemplqrService.getCopiesByBookNameandState("bName1",s );
    }

    @Test
    void  getAllCopies() {
        assertNotEquals(getAllCopies, exemplqrService.getAllCopies());
    }


    @Test
    void getAllDamagedCopies() {
        assertNotEquals(getAllDamagedCopies, exemplqrService.getAllDamagedCopies());
    }


    @Test
    void  listviewToEntity() {
        assertNotNull(exemplqrService.listviewToEntity(exemplqrModel));
    }


    @Test
    void  AddCopy() {
        assertTrue(exemplqrService.AddCopy(exemplqrModel));
    }


    @Test
    void getBookOldCopy() {
        assertEquals( getBookOldCopy, exemplqrService.getBookOldCopy(LocalDate.now().minusYears(50)));
    }


    @Test
    void getAvailableCopy() {
        assertNotEquals(getAvailableCopy, exemplqrService.getAvailableCopy());
    }


    @Test
    void getBookCopyWhereDamaged() {
        assertEquals(getBookCopyWhereDamaged, exemplqrService.getBookCopyWhereDamaged());
    }


    @Test
    void ArchiveCopy() {
        assertTrue(exemplqrService.ArchiveCopy(exemplqrModel));
    }


    @Test
    void MakeAvailable() {
        assertTrue(exemplqrService.MakeAvailable(exemplqrModel));
    }


    @Test
    void getLendInfoCopies() {
        assertNotEquals(getLendInfoCopies, exemplqrService.getLendInfoCopies(lendingInfoService.getAllLendingInfo()));
    }

    @Test
    void MakeUnavailable() {
        assertTrue(exemplqrService.MakeUnavailable(exemplqrModel));
    }


    @Test
    void getBookArchivedCopies() {
        assertEquals(getBookArchivedCopies, exemplqrService.getBookArchivedCopies(getAllCopies));
    }


    @Test
    void getBookUnArchivedCopies() {
        assertEquals( getBookUnArchivedCopies,exemplqrService.getBookUnArchivedCopies(getAllCopies));
    }

    @Test
    void getCopiesByBookName() {
        assertNotEquals(getCopiesByBookName, exemplqrService.getCopiesByBookName("bName1"));
    }


    @Test
    void  getCopiesByBookNameandState() {
        assertNotEquals(getCopiesByBookNameandState, exemplqrService.getCopiesByBookNameandState("bName1",s ));
    }



}
