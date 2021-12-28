package bg.tu_varna.sit.library.buisness.services;

import bg.tu_varna.sit.library.data.entities.Books;
import bg.tu_varna.sit.library.data.entities.USER;
import bg.tu_varna.sit.library.data.entities.UserInfo;
import bg.tu_varna.sit.library.data.repositories.UserInfoRepository;
import bg.tu_varna.sit.library.data.repositories.UserRepository;
import bg.tu_varna.sit.library.presentation.models.BookListModel;
import bg.tu_varna.sit.library.presentation.models.UserInfoListModel;
import bg.tu_varna.sit.library.presentation.models.UserListModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.List;
import java.util.stream.Collectors;

public class UserInfoService {

    private final UserInfoRepository repositoryUserInfo = UserInfoRepository.getInstance();

    public static UserInfoService getInstance() {return UserInfoService.UserInfoServiceHolder.INSTANCE;}

    private static class UserInfoServiceHolder
    {
        public static final UserInfoService INSTANCE = new UserInfoService();
    }

    public ObservableList<UserInfoListModel> getAllUserInfo()
    {
        List<UserInfo> userinfo = repositoryUserInfo.getAll();
        ObservableList<UserInfoListModel> userinfolist = FXCollections.observableList(
                userinfo.stream().map(a -> new UserInfoListModel(
                        a.getUser_idUser(), a.getName(), a.getPhone(), a.getEmail()
                )).collect(Collectors.toList()));
        return  userinfolist;
    }

    public boolean AddUserInfo(UserInfoListModel addUser) {
        List<UserInfo> userInfos = repositoryUserInfo.getAll();
        UserInfo userinfo = new UserInfo(addUser.getUser_idUser(),addUser.getName(), addUser.getPhone(), addUser.getEmail());
        for(UserInfo u : userInfos)
        {
            if(u.equals(userinfo))
            {
                return false;
            }
        }
        repositoryUserInfo.save(userinfo);
        return true;
    }



}
