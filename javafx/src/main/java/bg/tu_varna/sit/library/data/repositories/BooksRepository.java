package bg.tu_varna.sit.library.data.repositories;
import bg.tu_varna.sit.library.data.entities.Books;
import org.apache.log4j.Logger;

import java.util.List;
import java.util.Optional;

public class BooksRepository implements DAORepository<Books>{

    private static final Logger log = Logger.getLogger(BooksRepository.class);

    private static BooksRepository getInstance() {return BooksRepositoryHolder.INSTANCE;}

    private static class BooksRepositoryHolder {
        public static final BooksRepository INSTANCE = new BooksRepository();
    }

    @Override
   public void save(Books obj)
    {
    }

    @Override
    public void update(Books obj) {
    }

    @Override
    public void delete(Books obj) {

    }

    @Override
    public Optional<Books> getByIg(Long id) {
        return Optional.empty();
    }

    @Override
    public List<Books> getAll() {
        return null;
    }
}
