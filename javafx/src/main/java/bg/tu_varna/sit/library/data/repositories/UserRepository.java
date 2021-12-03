package bg.tu_varna.sit.library.data.repositories;

import bg.tu_varna.sit.library.data.entities.USER;
import org.apache.log4j.Logger;

import java.util.List;
import java.util.Optional;

public class UserRepository implements DAORepository<USER> {

    private static final Logger log = Logger.getLogger(UserRepository.class);

    private static UserRepository getInstance() {return UserRepository.UserRepositoryHolder.INSTANCE;}

    private static class UserRepositoryHolder {
        public static final UserRepository INSTANCE =new UserRepository() ;
    }

    @Override
    public void save(USER obj) {

    }

    @Override
    public void update(USER obj) {

    }

    @Override
    public void delete(USER obj) {

    }

    @Override
    public Optional<USER> getByIg(Long id) {
        return Optional.empty();
    }

    @Override
    public List<USER> getAll() {
        return null;
    }


}
