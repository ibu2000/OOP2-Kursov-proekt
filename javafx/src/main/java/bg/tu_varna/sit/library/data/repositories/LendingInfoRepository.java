package bg.tu_varna.sit.library.data.repositories;

import bg.tu_varna.sit.library.data.entities.LENDBOOKS;
import bg.tu_varna.sit.library.data.entities.LENDINFO;
import org.apache.log4j.Logger;

import java.util.List;
import java.util.Optional;

public class LendingInfoRepository implements DAORepository<LENDINFO> {
    private static final Logger log = Logger.getLogger(LendingInfoRepository.class);

    private static LendingInfoRepository getInstance() {return LendingInfoRepository.LendingInfoRepositoryHolder.INSTANCE;}

    private static class LendingInfoRepositoryHolder {
        public static final LendingInfoRepository INSTANCE =new LendingInfoRepository() ;
    }

    @Override
    public void save(LENDINFO obj) {

    }

    @Override
    public void update(LENDINFO obj) {

    }

    @Override
    public void delete(LENDINFO obj) {

    }

    @Override
    public Optional<LENDINFO> getByIg(Long id) {
        return Optional.empty();
    }

    @Override
    public List<LENDINFO> getAll() {
        return null;
    }
}


