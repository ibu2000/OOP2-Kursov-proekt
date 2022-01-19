package bg.tu_varna.sit.library.presentation.controllers;

import bg.tu_varna.sit.library.buisness.services.ExemplqrService;
import bg.tu_varna.sit.library.buisness.services.UserService;
import bg.tu_varna.sit.library.common.Constants;
import bg.tu_varna.sit.library.data.entities.Books;
import bg.tu_varna.sit.library.data.entities.StateOfBooks;
import bg.tu_varna.sit.library.data.entities.USER;
import bg.tu_varna.sit.library.presentation.models.ExemplqrModel;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import org.w3c.dom.Text;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class SearchBooksController implements Initializable {
    @FXML
    private Button buttonSB_home;
    @FXML
    private Button buttonSB_searchBook;
    @FXML
    private TextField text_field;
    @FXML
    private TableView<ExemplqrModel> allBooks;
    @FXML
    private TableColumn<ExemplqrModel, Long> isbn;
    @FXML
    private TableColumn<ExemplqrModel, StateOfBooks> stateOfBook;
    @FXML
    private TableColumn<ExemplqrModel, Books> book;
    @FXML
    private TableColumn<ExemplqrModel, LocalDate> yearOfRelease;
    @FXML
    private Label iduser;
    @FXML
    private RadioButton radion_button_new;
    @FXML
    private RadioButton radion_button_well_preserved;
    @FXML
    private RadioButton radion_button_damaged;

    Stage s;

    public SearchBooksController()
    {}
    public SearchBooksController(Stage stage)
    {
        s = stage;
    }

    ExemplqrService exemplqrService = new ExemplqrService();

    UserService userService = new UserService();

    USER userr;
    public void displayId (USER user)
    {
        iduser.setText( Long.toString(user.getIdUser()));
        userr = user;
    }



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        isbn.setCellValueFactory(new PropertyValueFactory<>("isbnUnikalenNomer"));
        book.setCellValueFactory(new PropertyValueFactory<>("idBook"));
        stateOfBook.setCellValueFactory(new PropertyValueFactory<>("exsemplqri_stateOfBooks"));
        yearOfRelease.setCellValueFactory(new PropertyValueFactory<>("copyDate"));
        ObservableList<ExemplqrModel> list = exemplqrService.getAllCopies();
        for(ExemplqrModel u : list)
        {
            allBooks.getItems().add(u);
        }
    }

    @FXML
    public void goToHomePage() {
        try {

            USER user = userService.FindUserByID(userr.getIdUser());
            long a = user.getUSERTYPE_idUserType().getIdUserType();


            if (a == 1)
            {
                s.close();
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(Constants.View.HOMEPAGE_USER));
                Stage stage = new Stage();
                fxmlLoader.setController(new HomePageUserController(stage));
                Parent root2 = fxmlLoader.load();
                HomePageUserController homePageUserController = fxmlLoader.getController();
                homePageUserController.displayId(user);
                stage.setScene(new Scene(root2));
                stage.show();
            } else if (a == 2)
            {

                s.close();
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(Constants.View.HOMEPAGE_OPERATOR));
                Stage stage = new Stage();
                fxmlLoader.setController(new HomePageOperatorController(stage));
                Parent root2 = fxmlLoader.load();
                HomePageOperatorController homePageOperatorController = fxmlLoader.getController();
                homePageOperatorController.displayId(user);
                stage.setScene(new Scene(root2));
                stage.show();
            } else if (a == 3)
            {
                s.close();
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(Constants.View.HOMEPAGE_ADMIN));
                Stage stage = new Stage();
                fxmlLoader.setController(new HomePageAdminController(stage));
                Parent root2 = fxmlLoader.load();
                HomePageAdminController homePageAdminController = fxmlLoader.getController();
                homePageAdminController.displayId(user);
                stage.setScene(new Scene(root2));
                stage.show();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void SearchBooks()
    {
        isbn.setCellValueFactory(new PropertyValueFactory<>("isbnUnikalenNomer"));
        book.setCellValueFactory(new PropertyValueFactory<>("idBook"));
        stateOfBook.setCellValueFactory(new PropertyValueFactory<>("exsemplqri_stateOfBooks"));
        yearOfRelease.setCellValueFactory(new PropertyValueFactory<>("copyDate"));

      if(radion_button_new.isSelected())
      {
          ObservableList<ExemplqrModel> copies = exemplqrService.getCopiesByBookNameandState(text_field.getText(),1);
          if(copies.size() > 0)
          {
              allBooks.getItems().clear();
              for (ExemplqrModel u : copies)
              {
                  allBooks.getItems().add(u);
              }
          }
          else
          {
              Alert alert = new Alert(Alert.AlertType.ERROR, "There are no matches for your search ", ButtonType.OK);
              alert.show();
          }
      }
      else if(radion_button_well_preserved.isSelected())
      {
          ObservableList<ExemplqrModel> copies = exemplqrService.getCopiesByBookNameandState(text_field.getText(),2);
          if(copies.size() > 0)
          {
              allBooks.getItems().clear();
              for (ExemplqrModel u : copies)
              {
                  allBooks.getItems().add(u);
              }
          }
          else
          {
              Alert alert = new Alert(Alert.AlertType.ERROR, "There are no matches for your search ", ButtonType.OK);
              alert.show();
          }
      }
      else if(radion_button_damaged.isSelected())
      {
          ObservableList<ExemplqrModel> copies = exemplqrService.getCopiesByBookNameandState(text_field.getText(),3);
          if(copies.size() > 0)
          {
              allBooks.getItems().clear();
              for (ExemplqrModel u : copies)
              {
                  allBooks.getItems().add(u);
              }
          }
          else
          {
              Alert alert = new Alert(Alert.AlertType.ERROR, "There are no matches for your search ", ButtonType.OK);
              alert.show();
          }
      }
      else
      {
          ObservableList<ExemplqrModel> copies = exemplqrService.getCopiesByBookName(text_field.getText());
          if(copies.size() > 0)
          {
              allBooks.getItems().clear();
              for (ExemplqrModel u : copies)
              {
                  allBooks.getItems().add(u);
              }
          }
          else
          {
              Alert alert = new Alert(Alert.AlertType.ERROR, "There are no matches for your search ", ButtonType.OK);
              alert.show();
          }
      }
    }



    @FXML
    public void getRow()
    {
        exemplqrModel = allBooks.getSelectionModel().getSelectedItem();
    }

    ExemplqrModel exemplqrModel;


}
