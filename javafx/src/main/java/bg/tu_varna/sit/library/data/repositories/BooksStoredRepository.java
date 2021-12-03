package bg.tu_varna.sit.library.data.repositories;

import bg.tu_varna.sit.library.data.entities.BOOKSSTORED;
import bg.tu_varna.sit.library.data.entities.Eksemplqri;
import org.apache.log4j.Logger;

import java.util.List;
import java.util.Optional;

public class BooksStoredRepository implements DAORepository<BOOKSSTORED> {
    private static final Logger log = Logger.getLogger(BooksStoredRepository.class);

    private static BooksStoredRepository getInstance() {return BooksStoredRepository.BooksStoredRepositoryHolder.INSTANCE;}

    private static class BooksStoredRepositoryHolder {
        public static final BooksStoredRepository INSTANCE =new BooksStoredRepository() ;
    }

    @Override
    public void save(BOOKSSTORED obj) {

    }

    @Override
    public void update(BOOKSSTORED obj) {

    }

    @Override
    public void delete(BOOKSSTORED obj) {

    }

    @Override
    public Optional<BOOKSSTORED> getByIg(Long id) {
        return Optional.empty();
    }

    @Override
    public List<BOOKSSTORED> getAll() {
        return null;
    }
}
