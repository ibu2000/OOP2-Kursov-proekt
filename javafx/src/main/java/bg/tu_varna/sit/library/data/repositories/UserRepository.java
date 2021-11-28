package bg.tu_varna.sit.library.data.repositories;

import bg.tu_varna.sit.library.data.entities.User;
import org.apache.log4j.Logger;

import java.util.List;
import java.util.Optional;

public class UserRepository implements DAORepository<User> {

    private static final Logger log = Logger.getLogger(UserRepository.class);

    private static UserRepository getInstance() {return UserRepository.UserRepositoryGolder.INSTANCE;}

    private static class UserRepositoryGolder {
        public static final UserRepository INSTANCE =new UserRepository() ;
    }

    @Override
    public void save(User obk) {

    }

    @Override
    public void update(User obj) {

    }

    @Override
    public void delete(User obj) {

    }

    @Override
    public Optional<User> getByIg(Long id) {
        return Optional.empty();
    }

    @Override
    public List<User> getAll() {
        return null;
    }


}
