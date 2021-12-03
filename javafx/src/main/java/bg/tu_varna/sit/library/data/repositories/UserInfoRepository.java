package bg.tu_varna.sit.library.data.repositories;

import bg.tu_varna.sit.library.data.entities.USER;
import bg.tu_varna.sit.library.data.entities.UserInfo;
import org.apache.log4j.Logger;

import java.util.List;
import java.util.Optional;

public class UserInfoRepository implements DAORepository<UserInfo> {

    private static final Logger log = Logger.getLogger(UserInfoRepository.class);

    private static UserInfoRepository getInstance() {return UserInfoRepository.UserInfoRepositoryHolder.INSTANCE;}

    private static class UserInfoRepositoryHolder {
        public static final UserInfoRepository INSTANCE =new UserInfoRepository() ;
    }

    @Override
    public void save(UserInfo obj) {

    }

    @Override
    public void update(UserInfo  obj) {

    }

    @Override
    public void delete(UserInfo  obj) {

    }

    @Override
    public Optional<UserInfo> getByIg(Long id) {
        return Optional.empty();
    }

    @Override
    public List<UserInfo> getAll() {
        return null;
    }


}
