package bg.tu_varna.sit.library.buisness.services;

import bg.tu_varna.sit.library.data.entities.Books;
import bg.tu_varna.sit.library.data.entities.USER;
import bg.tu_varna.sit.library.data.entities.UserType;
import bg.tu_varna.sit.library.data.repositories.UserRepository;
import bg.tu_varna.sit.library.presentation.models.BookListModel;
import bg.tu_varna.sit.library.presentation.models.UserListModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class UserService {

    private final UserRepository repositoryUser = UserRepository.getInstance();

    public static UserService getInstance() {return UserService.UserServiceHolder.INSTANCE;}

    private static class UserServiceHolder
    {
        public static final UserService INSTANCE = new UserService();
    }


    public ObservableList<UserListModel> getAllUsers()
    {
        List<USER> users = repositoryUser.getAll();
        ObservableList<UserListModel> userlist = FXCollections.observableList(
                users.stream().map(a -> new UserListModel(
                        a.getUserName(), a.getPassword()
                )).collect(Collectors.toList()));
        return  userlist;
    }

    public ObservableList<UserListModel> getAllUserNames()
    {
        List<USER> users = repositoryUser.getAll();
        ObservableList<UserListModel> userlist = FXCollections.observableList(
                users.stream().map(a -> new UserListModel(
                        a.getUserName()
                )).collect(Collectors.toList()));
        return  userlist;
    }



    public long FindUserType(UserListModel a)
    {
        USER usr = new USER(a.getUserName(),a.getPassword());
        List<USER> users = repositoryUser.getAll();
        for(USER user : users)
        {
            if(user.equals(usr))
            {
             long b = user.getUSERTYPE_idUserType().getIdUserType();
             return b;
            }
        }

        return 0;
    }

    public USER listviewToEntity(UserListModel a)
    {
        USER temp = new USER(a.getUserName());
        List<USER> users = repositoryUser.getAll();
        for(USER u: users)
        {
            if(u.getUserName().equals(temp.getUserName()))
            {
                return u;
            }
        }
        return  null;
    }

    public ArrayList<String> getUserForComboBox()
    {
        ObservableList<UserListModel> allUsers = getAllUserNames();
        ArrayList<String> usernames = new ArrayList<>();
        for(UserListModel user : allUsers)
        {
            usernames.add(user.getUserName());
        }
        return usernames;
    }


    public boolean UserLogin(UserListModel a)
    {
        ObservableList<UserListModel> allUsers = getAllUsers();
        for(UserListModel user : allUsers)
        {
            if(user.equals(a))
            {
                return true;
            }
        }
        return false;
    }


    public boolean AddUser(UserListModel addUser) {
        List<USER> users = repositoryUser.getAll();
        USER user = new USER(addUser.getIdUser(),addUser.getUserName(),addUser.getPassword(),addUser.getDateOfUserApproval(),addUser.getRating(),addUser.getSTATUS_idStatus(),addUser.getUSERTYEPE_idUserType());
        for(USER u : users)
        {
            if(u.equals(user))
            {
                return false;
            }
        }
        repositoryUser.save(user);
        return true;
    }



}
