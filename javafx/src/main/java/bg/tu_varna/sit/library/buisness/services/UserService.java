package bg.tu_varna.sit.library.buisness.services;

import bg.tu_varna.sit.library.data.entities.*;
import bg.tu_varna.sit.library.data.repositories.UserInfoRepository;
import bg.tu_varna.sit.library.data.repositories.UserRepository;
import bg.tu_varna.sit.library.presentation.models.UserListModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.time.LocalDate;
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

    private final UserInfoRepository repositoryUserInfo = UserInfoRepository.getInstance();

    public ObservableList<UserListModel> getAllUsers()
    {
        List<USER> users = repositoryUser.getAll();
        ObservableList<UserListModel> userlist = FXCollections.observableList(
                users.stream().map(a -> new UserListModel(
                        a.getUserName(), a.getPassword()
                )).collect(Collectors.toList()));
        return  userlist;
    }

    public ObservableList<UserListModel> getAllUsersWithTypes()
    {
        List<USER> users = repositoryUser.getAll();
        ObservableList<UserListModel> userlist = FXCollections.observableList(
                users.stream().map(a -> new UserListModel(
                        a.getUserName(), a.getPassword(), a.getUSERTYPE_idUserType()
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

    public ObservableList<UserListModel> getAllFields()
    {
        List<USER> users = repositoryUser.getAll();
        ObservableList<UserListModel> userlist = FXCollections.observableList(
                users.stream().map(a -> new UserListModel(
                      a.getIdUser(), a.getUserName(),a.getPassword(), a.getDateOfUserApproval(),
                      a.getRating(), a.getUSERTYPE_idUserType(),a.getSTATUS_idStatus()
                )).collect(Collectors.toList()));
        return  userlist;
    }



    public long FindUserType(UserListModel a)
    {
        USER usr = new USER(a.getUserName(),a.getPassword());
        List<USER> users = repositoryUser.getAll();
        for(USER user : users)
        {
            if(user.getUserName().equals(usr.getUserName()) && user.getPassword().equals(usr.getPassword()))
            {
             long b = user.getUSERTYPE_idUserType().getIdUserType();
             return b;
            }
        }

        return 0;
    }
    public USER FindUser(UserListModel a)
    {
        USER usr = new USER(a.getUserName(),a.getPassword());
        List<USER> users = repositoryUser.getAll();
        for(USER user : users)
        {
            if(user.getUserName().equals(usr.getUserName()) && user.getPassword().equals(usr.getPassword()))
            {

                return user;
            }
        }

        return null;
    }
    public USER FindUserByID(Long a)
    {
        List<USER> users = repositoryUser.getAll();
        for(USER user : users)
        {
            if(user.getIdUser()==a)
            {

                return user;
            }
        }

        return null;
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

    public ArrayList<String> getUserForApproval()
    {
        Status status = new Status(1,"pending");
        UserListModel usr = new UserListModel(1,status);
        ObservableList<UserListModel> allUsers = getAllFields();
        ArrayList<String> usernames = new ArrayList<>();
        for(UserListModel user : allUsers)
        {
            if(user.getSTATUS_idStatus().getIdStatus()==(usr.getSTATUS_idStatus().getIdStatus())) {
                usernames.add(user.getUserName());
            }
        }
        return usernames;


    }


    public ArrayList<String> getOnlyUserForComboBox()
    {
        UserType type = new UserType(1, "user");
        ObservableList<UserListModel> allUsers = getAllUsersWithTypes();
        ArrayList<String> usernames = new ArrayList<>();
        for(UserListModel user : allUsers)
        {
           if((user.getUSERTYEPE_idUserType()).getUserType().equals(type.getUserType()))
           {
               usernames.add(user.getUserName());
           }
        }
        return usernames;
    }

    public boolean UserLogin(UserListModel a)
    {   Status status =new Status(2,"not pending");
        UserListModel b = new UserListModel(1, status);
        ObservableList<UserListModel> allUsers = getAllFields();
        for(UserListModel user : allUsers)
        {
            if(user.getUserName().equals(a.getUserName()) && (user.getPassword().equals(a.getPassword())))
            {
                if((user.getSTATUS_idStatus().getIdStatus()==(b.getSTATUS_idStatus().getIdStatus())))
                {
                    return true;
                }
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


    public boolean UpdateUser(UserListModel addUser) {
        List<USER> users = repositoryUser.getAll();
        USER user = new USER(addUser.getIdUser(),addUser.getUserName(),addUser.getPassword(),addUser.getDateOfUserApproval(),addUser.getRating(),addUser.getSTATUS_idStatus(),addUser.getUSERTYEPE_idUserType());
        for(USER u : users)
        {
            if(u.getUserName().equals(user.getUserName()))
            {
                UserType userType = new UserType(2, "operator");
                u.setUSERTYEPE_idUserType(userType);
                repositoryUser.update(u);
                return true;
            }
        }
        return true;
    }





    public boolean CreateUser(UserListModel addUser) {
        List<USER> users = repositoryUser.getAll();
        for(USER u : users)
        {
            if(u.getUserName().equals(addUser.getUserName()))
            {
                LocalDate myDate =  LocalDate.now();;
                Status status = new Status(2,"not pending");
                u.setSTATUS_idStatus(status);
                u.setDateOfUserApproval(myDate);
                repositoryUser.update(u);
                return true;
            }
        }
        return false;
    }


    public boolean DeleteUser(UserListModel addUser) {
        List<USER> users = repositoryUser.getAll();
        USER user = new USER(addUser.getIdUser(),addUser.getUserName(),addUser.getPassword(),addUser.getDateOfUserApproval(),addUser.getRating(),addUser.getSTATUS_idStatus(),addUser.getUSERTYEPE_idUserType());
        for(USER u : users)
        {
            if(u.getUserName().equals(user.getUserName()))
            {
                repositoryUser.delete(u);
                return true;
            }
        }
        return false;
    }

    public UserListModel GetUser(String a)
    {
        ObservableList<UserListModel> allUsers =getAllFields();
        for(UserListModel b : allUsers)
        {
            if(b.getUserName().equals(a))
            {
                return b;
            }
        }
        return null;

    }


    public USER GetUserByName(String a)
    {
        List<USER> allUsers =repositoryUser.getAll();
        for(USER b : allUsers)
        {
            if(b.getUserName().equals(a))
            {
                return b;
            }
        }
        return null;

    }


    public USER getUserById(Long a)
    {
        List<USER> allUsers =repositoryUser.getAll();
        for(USER b : allUsers)
        {
            if(b.getIdUser()==a)
            {
                return b;
            }
        }
        return null;

    }


    public ObservableList<UserListModel> GetUsersByLoyalty(String a)
    {
        ObservableList<UserListModel> copies = FXCollections.observableArrayList();
        ObservableList<UserListModel> allUsers = getAllFields();
        for(UserListModel b : allUsers)
        {
            if(b.getRating().equals(a))
            {
               copies.add(b);
            }
        }
       return copies;
    }


    public void MakeDisloyal(USER addUser)
    {
        List<USER> allUsers = repositoryUser.getAll();
        for (USER u : allUsers)
        {
            if(u.getIdUser()==addUser.getIdUser())
            {
                u.setRating("bad");
                repositoryUser.update(u);
            }
        }
    }
    public void MakeLoyal(USER addUser)
    {
        List<USER> allUsers = repositoryUser.getAll();
        for (USER u : allUsers)
        {
            if(u.getIdUser()==addUser.getIdUser())
            {
                u.setRating("good");
                repositoryUser.update(u);
            }
        }
    }



}
