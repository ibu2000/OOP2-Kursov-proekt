package bg.tu_varna.sit.library.buisness.services;

import bg.tu_varna.sit.library.data.entities.USER;
import bg.tu_varna.sit.library.data.entities.UserType;
import bg.tu_varna.sit.library.data.repositories.UserRepository;
import bg.tu_varna.sit.library.presentation.models.UserListModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

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
                        a.getUserName(),
                        a.getPassword()
                )).collect(Collectors.toList()));
        return  userlist;
    }
<<<<<<< Updated upstream
    public int FindUserType(UserListModel a)
    {
        int type;
        ObservableList<UserListModel> allUsers = getAllUsers();
        for(UserListModel user : allUsers)
        {
            if(user.equals(a))
            {
                return type = getUserType();
            }
        }
        return type = 146853 ;
    }

    private int getUserType(USER a) {
        List<USER> users = repositoryUser.getAll();
        USER temp = new USER();
        for(USER gr:users)
        {
            if(gr.getUserType().equals(a))
            {
                return gr;
            }
        }

    }
=======
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


>>>>>>> Stashed changes

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




}
