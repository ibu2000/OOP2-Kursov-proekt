package bg.tu_varna.sit.library.presentation.controllers;

import bg.tu_varna.sit.library.buisness.services.UserService;
import bg.tu_varna.sit.library.common.Constants;
import bg.tu_varna.sit.library.data.entities.USER;
import bg.tu_varna.sit.library.presentation.models.UserListModel;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class HomePageAdminController {
    @FXML
    private Button button_create_operator;
    @FXML
    private Button button_scrapping;
    @FXML
    private Button button_add_new_book;
    @FXML
    private Button button_archive_old_books;
    @FXML
    private Button buttonA_lend_book;
    @FXML
    private Button buttonA_return_book;
    @FXML
    private Button buttonA_search_books;
    @FXML
    private Button buttonA_user_rating;
    @FXML
    private Button buttonA_logout;
    @FXML
    private Button buttonA_scrap_book;
    @FXML
    private Button buttonA_user_info;
    @FXML
    private Label iduser;
    @FXML
    private Button button_create_user;
    Stage s;

    public HomePageAdminController() {
    }

    public HomePageAdminController(Stage stage) {
        s = stage;
    }


    UserService userService = new UserService();

    USER userr;

    public void displayId(USER user) {
        iduser.setText(Long.toString(user.getIdUser()));
        userr = user;
    }


    @FXML
    public void logOut() {
        try {
            s.close();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(Constants.View.SAMPLE));
            Stage stage = new Stage();
            fxmlLoader.setController(new SampleController(stage));
            Parent root2 = fxmlLoader.load();
            stage.setScene(new Scene(root2));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void addNewBook() {
        try {
            s.close();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(Constants.View.ADD_BOOKS));
            Stage stage = new Stage();
            fxmlLoader.setController(new AddNewBookController(stage));
            Parent root2 = fxmlLoader.load();
            USER user = userService.FindUserByID(userr.getIdUser());
            AddNewBookController addNewBookController = fxmlLoader.getController();
            addNewBookController.displayId(userr);
            stage.setScene(new Scene(root2));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void PromoteToOperatorPage() {
        try {
            s.close();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(Constants.View.PROMOTE_TO_OPERATOR));
            Stage stage = new Stage();
            fxmlLoader.setController(new PromoteToOperatorController(stage));
            Parent root2 = fxmlLoader.load();
            USER user = userService.FindUserByID(userr.getIdUser());
           PromoteToOperatorController promoteToOperatorController = fxmlLoader.getController();
            promoteToOperatorController.displayId(userr);
            stage.setScene(new Scene(root2));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void archiveBookPage() {
        try {
            s.close();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(Constants.View.ARCHIVE_OLD_BOOK));
            Stage stage = new Stage();
            fxmlLoader.setController(new ArchiveOldBooksController(stage));
            Parent root2 = fxmlLoader.load();
            USER user = userService.FindUserByID(userr.getIdUser());
            ArchiveOldBooksController archiveOldBooksController = fxmlLoader.getController();
            archiveOldBooksController.displayId(userr);
            stage.setScene(new Scene(root2));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void ScrapBookPage() {
        try {
            s.close();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(Constants.View.SCRAP_BOOK));
            Stage stage = new Stage();
            fxmlLoader.setController(new ScrapBookController(stage));
            Parent root2 = fxmlLoader.load();
            USER user = userService.FindUserByID(userr.getIdUser());
            ScrapBookController scrapBookController = fxmlLoader.getController();
            scrapBookController.displayId(userr);
            stage.setScene(new Scene(root2));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @FXML
    public void createUserPage() {
        try {
            s.close();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(Constants.View.CREATE_USER));
            Stage stage = new Stage();
            fxmlLoader.setController(new CreateUserController(stage));
            Parent root2 = fxmlLoader.load();
            USER user = userService.FindUserByID(userr.getIdUser());
            CreateUserController createUserController = fxmlLoader.getController();
            createUserController.displayId(userr);
            stage.setScene(new Scene(root2));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void deleteUserPage() {
        try {
            s.close();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(Constants.View.DELETE_USER));
            Stage stage = new Stage();
            fxmlLoader.setController(new DeleteUserController(stage));
            Parent root2 = fxmlLoader.load();
            USER user = userService.FindUserByID(userr.getIdUser());
            DeleteUserController deleteUserController = fxmlLoader.getController();
            deleteUserController.displayId(userr);
            stage.setScene(new Scene(root2));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void formsPage() {
        try {
            s.close();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(Constants.View.FORMS));
            Stage stage = new Stage();
            fxmlLoader.setController(new FormsController(stage));
            Parent root2 = fxmlLoader.load();
            USER user = userService.FindUserByID(userr.getIdUser());
           FormsController formsController = fxmlLoader.getController();
            formsController.displayId(userr);
            stage.setScene(new Scene(root2));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @FXML
    public void LendBooks() {
        try {
            s.close();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(Constants.View.LEND_BOOK));
            Stage stage = new Stage();
            fxmlLoader.setController(new LendingBooksController(stage));
            Parent root2 = fxmlLoader.load();
            USER user = userService.FindUserByID(userr.getIdUser());
            LendingBooksController lendingBooksController = fxmlLoader.getController();
            lendingBooksController.displayId(userr);
            stage.setScene(new Scene(root2));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @FXML
    public void ReturnBook() {
        try {
            s.close();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(Constants.View.RETURN_BOOK));
            Stage stage = new Stage();
            fxmlLoader.setController(new ReturnBookController(stage));
            Parent root2 = fxmlLoader.load();
            USER user = userService.FindUserByID(userr.getIdUser());
            ReturnBookController returnBookController = fxmlLoader.getController();
            returnBookController.displayId(userr);
            stage.setScene(new Scene(root2));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void SearchBooks() {
        try {
            s.close();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(Constants.View.SEARCH_BOOK));
            Stage stage = new Stage();
            fxmlLoader.setController(new SearchBooksController(stage));
            Parent root2 = fxmlLoader.load();
            USER user = userService.FindUserByID(userr.getIdUser());
            SearchBooksController searchBooksController = fxmlLoader.getController();
            searchBooksController.displayId(userr);
            stage.setScene(new Scene(root2));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void UserRatings() {
        try {
            s.close();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(Constants.View.USER_RATINGS));
            Stage stage = new Stage();
            fxmlLoader.setController(new UserRatingController(stage));
            Parent root2 = fxmlLoader.load();
            USER user = userService.FindUserByID(userr.getIdUser());
            UserRatingController userRatingController = fxmlLoader.getController();
            userRatingController.displayId(userr);
            stage.setScene(new Scene(root2));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }

        }


    @FXML
    public void userInfo () {
        try {
            s.close();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(Constants.View.SEARCH_USER_INFO));
            Stage stage = new Stage();
            fxmlLoader.setController(new SearchUserInfoController(stage));
            Parent root2 = fxmlLoader.load();
            USER user = userService.FindUserByID(userr.getIdUser());
            SearchUserInfoController searchUserInfoController = fxmlLoader.getController();
            searchUserInfoController.displayId(userr);
            stage.setScene(new Scene(root2));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


