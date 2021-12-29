package bg.tu_varna.sit.library.presentation.controllers;

import bg.tu_varna.sit.library.buisness.services.BookService;
import bg.tu_varna.sit.library.buisness.services.ExemplqrService;
import bg.tu_varna.sit.library.common.Constants;
import bg.tu_varna.sit.library.presentation.models.ExemplqrModel;
import bg.tu_varna.sit.library.presentation.models.UserListModel;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
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
    private ComboBox combobox_copyOfBook;

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
        combobox_copyOfBook.getItems().clear();
        combobox_copyOfBook.getItems().addAll(exemplqrService.getBookCopyWhereDamaged());
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



    boolean isArchived;
    @FXML
    public void ArchiveOldBooks()
    {
        ExemplqrModel copyname= (ExemplqrModel) combobox_copyOfBook.getValue();
        ExemplqrModel b = exemplqrService.GetCopy(copyname);
        if(combobox_copyOfBook.equals(""))
        {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Please fill all the fields!", ButtonType.OK);
            alert.show();
        }
        else
        {
            isArchived = exemplqrService.ArchiveCopy(b);

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
