package bg.tu_varna.sit.library.data.repositories;

import bg.tu_varna.sit.library.data.entities.LENDBOOKS;
import bg.tu_varna.sit.library.data.entities.UserInfo;
import org.apache.log4j.Logger;

import java.util.List;
import java.util.Optional;

public class LendBooksRepository implements DAORepository<LENDBOOKS>{
    private static final Logger log = Logger.getLogger(LendBooksRepository.class);

    private static LendBooksRepository getInstance() {return LendBooksRepository.LendBooksRepositoryHolder.INSTANCE;}

    private static class LendBooksRepositoryHolder {
        public static final LendBooksRepository INSTANCE =new LendBooksRepository() ;
    }

    @Override
    public void save(LENDBOOKS obj) {

    }

    @Override
    public void update(LENDBOOKS obj) {

    }

    @Override
    public void delete(LENDBOOKS obj) {

    }

    @Override
    public Optional<LENDBOOKS> getByIg(Long id) {
        return Optional.empty();
    }

    @Override
    public List<LENDBOOKS> getAll() {
        return null;
    }
}
