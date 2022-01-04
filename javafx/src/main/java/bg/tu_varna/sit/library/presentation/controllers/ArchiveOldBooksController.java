package bg.tu_varna.sit.library.presentation.controllers;

import bg.tu_varna.sit.library.buisness.services.BookService;
import bg.tu_varna.sit.library.buisness.services.ExemplqrService;
import bg.tu_varna.sit.library.common.Constants;
import bg.tu_varna.sit.library.data.entities.Books;
import bg.tu_varna.sit.library.data.entities.Eksemplqri;
import bg.tu_varna.sit.library.data.entities.StateOfBooks;
import bg.tu_varna.sit.library.data.repositories.DAORepository;
import bg.tu_varna.sit.library.presentation.models.ExemplqrModel;
import bg.tu_varna.sit.library.presentation.models.UserListModel;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class ArchiveOldBooksController implements Initializable {
    @FXML
    private Button buttonAOB_archive_old_book;
    @FXML
    private Button buttonAOB_home;
    @FXML
    private ComboBox combobox_bookName;
    @FXML
    private ComboBox<ExemplqrModel> combobox_copyOfBook;
    @FXML
    private TableView<ExemplqrModel> allDamagedBooks;
    @FXML
    private TableColumn<ExemplqrModel, Long> isbnCol;
    @FXML
    private TableColumn<ExemplqrModel, StateOfBooks> StateOfBookCol;
    @FXML
    private TableColumn<ExemplqrModel, Books> BookIdCol;


    BookService bookService = new BookService();
    ExemplqrService exemplqrService = new ExemplqrService();
    Stage s;

    public ArchiveOldBooksController() {
    }

    public ArchiveOldBooksController(Stage stage) {
        s = stage;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
   

        isbnCol.setCellValueFactory(new PropertyValueFactory<>("isbnUnikalenNomer"));

        StateOfBookCol.setCellValueFactory(new PropertyValueFactory<>("exsemplqri_stateOfBooks"));
        BookIdCol.setCellValueFactory(new PropertyValueFactory<>("idBook"));

        ObservableList<ExemplqrModel> list= exemplqrService.getBookCopyWhereDamaged();
        for(ExemplqrModel u : list)
        {
            allDamagedBooks.getItems().add(u);
        }
    }

    @FXML
    public void  goToHomePage() {
        try {
            s.close();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(Constants.View.HOMEPAGE_ADMIN));
            Stage stage = new Stage();
            fxmlLoader.setController(new HomePageAdminController(stage));
            Parent root2 = fxmlLoader.load();
            stage.setScene(new Scene(root2));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    boolean isitAvailable = true;
    boolean isArchived;
    @FXML
    public void ArchiveOldBooks()
    {
        ExemplqrModel copyname = new ExemplqrModel((combobox_copyOfBook.getValue()).getIsbnUnikalenNomer(),(combobox_copyOfBook.getValue()).getIdBook(),(combobox_copyOfBook.getValue()).isIsitArchived(),(combobox_copyOfBook.getValue()).getExsemplqri_stateOfBooks(),isitAvailable);
       // ExemplqrModel b = exemplqrService.GetCopy(copyname);
       /* ObservableList<ExemplqrModel> productsInPeriod = productService.getAllProductsByStatInPeriod(myFromDate, myToDate, isAvailable);
        allProdByStatTable.setItems(productsInPeriod);*/
        if(combobox_copyOfBook.equals(""))
        {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Please fill all the fields!", ButtonType.OK);
            alert.show();
        }
        else
        {
            isArchived = exemplqrService.ArchiveCopy(copyname);

            if (isArchived)
            {
                Alert alert = new Alert(Alert.AlertType.INFORMATION, "The copy has been archived!", ButtonType.OK);
                alert.show();
            }
            else
            {
                Alert alert = new Alert(Alert.AlertType.INFORMATION, "The copy has not been archived!", ButtonType.OK);
                alert.show();
            }
        }
    }



}
