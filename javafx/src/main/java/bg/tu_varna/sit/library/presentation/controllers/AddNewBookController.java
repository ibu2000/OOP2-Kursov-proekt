package bg.tu_varna.sit.library.presentation.controllers;

import java.time.LocalDate;
import java.util.ResourceBundle;

import bg.tu_varna.sit.library.buisness.services.BookService;
import bg.tu_varna.sit.library.buisness.services.ExemplqrService;
import bg.tu_varna.sit.library.buisness.services.StateofBooksService;
import bg.tu_varna.sit.library.common.Constants;
import bg.tu_varna.sit.library.data.entities.Books;
import bg.tu_varna.sit.library.data.entities.StateOfBooks;
import bg.tu_varna.sit.library.presentation.models.BookListModel;
import bg.tu_varna.sit.library.presentation.models.ExemplqrModel;
import javafx.event.ActionEvent;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;
import org.apache.log4j.lf5.util.Resource;


import java.net.URL;

public class AddNewBookController implements Initializable {
    @FXML
    private Button buttonCU_create;
    @FXML
    private Button buttonUR_home;
    @FXML
    private TextField name_of_book;
    @FXML
    private TextField idBook;
    @FXML
    private TextField author;
    @FXML
    private DatePicker year_of_publishing;
    @FXML
    private TextField genre;
    @FXML
    private TextField tfANB_isbn;
    @FXML
    private Button buttonANB_add_book;
    @FXML
    private Button buttonANB_add_copy;
    @FXML
    private Button buttonANB_home;

    @FXML
    private ComboBox combo_boxANB_state_of_book;
    @FXML
    private ComboBox combo_boxANB_name_of_book;
    @FXML
    private RadioButton radio_buttonANB_archived;
    @FXML
    private RadioButton radio_buttonANB_not_archived;


    LocalDate publishDate;
     BookService BookService = new BookService();
     ExemplqrService ExemplqrService = new ExemplqrService();
     StateofBooksService stateOfBooksService = new StateofBooksService();

     Stage s;
     public AddNewBookController() {
     }

     public AddNewBookController(Stage stage) {
      s=stage;
     }

     @Override
        public void initialize(URL url, ResourceBundle rb) {

         combo_boxANB_name_of_book.getItems().clear();
         combo_boxANB_name_of_book.getItems().addAll(BookService. getBookNames());

         combo_boxANB_state_of_book.getItems().clear();
         combo_boxANB_state_of_book.getItems().addAll(stateOfBooksService.getBookStates());
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

     @FXML
     public void getDate()
     {
      publishDate = year_of_publishing.getValue();
     }


    boolean bookAlreadyExists;
     @FXML
     public void addBook()
     {

      BookListModel addBook = new BookListModel(name_of_book.getText(),author.getText(), genre.getText(), publishDate);
      if(name_of_book.equals("") || author.equals("") || genre.equals("") || publishDate.equals(""))
      {
       Alert alert = new Alert(Alert.AlertType.ERROR, "Please fill all the fields!", ButtonType.OK);
       alert.show();
      }
      else
      {
       bookAlreadyExists = BookService.AddBook(addBook);
       if(bookAlreadyExists)
       {
        Alert alert = new Alert(Alert.AlertType.INFORMATION, "The book has been added!", ButtonType.OK);
        alert.show();
       } else
         {
          Alert alert = new Alert(Alert.AlertType.ERROR, "Book already exists!", ButtonType.OK);
          alert.show();
         }
      }
         combo_boxANB_name_of_book.getItems().clear();
         combo_boxANB_name_of_book.getItems().addAll(BookService. getBookNames());
     }



     boolean isArchived;

    @FXML
    public void addCopy()
    {
        if(radio_buttonANB_archived.isSelected())
        {
            isArchived=true;
        }
       else if(radio_buttonANB_not_archived.isSelected())
        {
            isArchived=false;
        }
       String bookname=combo_boxANB_name_of_book.getValue().toString();
       BookListModel b = BookService.GetBook(bookname);
       Books book = BookService.listviewToEntity(b);
       StateOfBooks state = new StateOfBooks(1 ,combo_boxANB_state_of_book.getValue().toString());
        ExemplqrModel addBook = new ExemplqrModel(book, isArchived, state);
        if(combo_boxANB_name_of_book.equals("") || (!radio_buttonANB_archived.isSelected() && !radio_buttonANB_not_archived.isSelected())
                || combo_boxANB_state_of_book.equals(""))
        {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Please fill all the fields!", ButtonType.OK);
            alert.show();
        }
        else
        {
            bookAlreadyExists = ExemplqrService.AddCopy(addBook);
            if(bookAlreadyExists)
            {
                Alert alert = new Alert(Alert.AlertType.INFORMATION, "The copy has been added!", ButtonType.OK);
                alert.show();
            } else
            {
                Alert alert = new Alert(Alert.AlertType.ERROR, "Copy already exists!", ButtonType.OK);
                alert.show();
            }
        }

    }

    }
