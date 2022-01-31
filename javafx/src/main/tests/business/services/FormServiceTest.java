package business.services;

import bg.tu_varna.sit.library.buisness.services.FormService;
import bg.tu_varna.sit.library.buisness.services.UserService;
import bg.tu_varna.sit.library.data.entities.FORM;
import bg.tu_varna.sit.library.data.entities.USER;
import bg.tu_varna.sit.library.presentation.models.FormModel;
import bg.tu_varna.sit.library.presentation.models.UserListModel;
import javafx.collections.ObservableList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class FormServiceTest {

    UserService userService = new UserService();
    FormService formService = new FormService();
    ObservableList<FormModel> GetFormsByStatus;
    ObservableList<FormModel> getAllCopies;
    FORM form;
    FormModel GetForm;
    USER user;

    @BeforeEach
    void setUp()
    {
      getAllCopies = formService.getAllCopies();
      long a = 7;
      user =userService.getUserById(a);
      form = new FORM(LocalDate.now(), user,"content", "pending");
      GetForm = formService.GetForm(user);
      GetFormsByStatus = formService.GetFormsByStatus("pening");
    }

    @Test
    void  getAllCopies() {
        assertEquals(getAllCopies, formService.getAllCopies());
    }


    @Test
    void AddForm() {
        assertTrue(formService.AddForm(form));
    }


    @Test
    void listviewToEntity() {
        GetForm =formService.GetForm(user);
        assertNotNull(formService.listviewToEntity(GetForm));
    }


    @Test
    void GetFormsByStatus() {
        assertEquals(GetFormsByStatus, formService.GetFormsByStatus("pening"));
    }


    @Test
    void GetForm() {
        assertEquals(GetForm, formService.GetForm(user));
    }


    @Test
    void UpdateForm() {
        assertTrue(formService.UpdateForm(GetForm));
    }

    @Test
    void DeleteForm() {
        assertNotNull(formService.DeleteForm(GetForm));
    }


}
