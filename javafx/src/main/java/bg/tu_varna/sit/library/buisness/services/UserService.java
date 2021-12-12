package bg.tu_varna.sit.library.buisness.services;

import bg.tu_varna.sit.library.data.entities.USER;
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
        return FXCollections.observableList(
                users.stream().map(a -> new UserListModel(
                        a.getUserName(),
                        a.getPassword()
                )).collect(Collectors.toList()));
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



}
