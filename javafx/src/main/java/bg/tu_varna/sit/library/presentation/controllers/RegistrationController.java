package bg.tu_varna.sit.library.presentation.controllers;

import bg.tu_varna.sit.library.presentation.models.BookListModel;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class RegistrationController {
    @FXML
    private TextField tf_RName;
    @FXML
    private TextField tf_RUsername;
    @FXML
    private TextField tf_RPassword;
    @FXML
    private TextField tf_RE_mail;
    @FXML
    private TextField tf_RPhone_number;
    @FXML
    private Button button_RSign_up;

    Stage s;

    public RegistrationController() {
    }

    public RegistrationController(Stage stage) {
        s = stage;
    }


    boolean bookAlreadyExists;
    @FXML
    public void addUser()
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
        combo_boxANB_state_of_book.getItems().clear();
        combo_boxANB_state_of_book.getItems().addAll(stateOfBooksService.getBookStates());
    }

}
