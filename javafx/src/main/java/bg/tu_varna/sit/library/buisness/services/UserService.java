package bg.tu_varna.sit.library.buisness.services;

import bg.tu_varna.sit.library.data.repositories.UserRepository;

public class UserService {

    private final UserRepository repositoryUser = UserRepository.getInstance();

    public static UserService getInstance() {return UserService.UserServiceHolder.INSTANCE;}

    private static class UserServiceHolder
    {
        public static final UserService INSTANCE = new UserService();
    }

}
