package bg.tu_varna.sit.library.data.repositories;

import bg.tu_varna.sit.library.data.access.Connection;
import bg.tu_varna.sit.library.data.entities.StateOfBooks;
import bg.tu_varna.sit.library.data.entities.UserType;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;
import java.util.Optional;

public class StateOfBooksRepository implements DAORepository<StateOfBooks>{

    private static final Logger log = Logger.getLogger(StateOfBooksRepository.class);

    private static StateOfBooksRepository getInstance() {return StateOfBooksRepositoryHolder.INSTANCE;}

    private static class StateOfBooksRepositoryHolder {
        public static final StateOfBooksRepository INSTANCE = new StateOfBooksRepository();
    }

    @Override
    public void save(StateOfBooks obj) {
    }

    @Override
    public void update(StateOfBooks obj) {

    }

    @Override
    public void delete(StateOfBooks obj) {

    }

    @Override
    public Optional<StateOfBooks> getByIg(Long id) {
        return Optional.empty();
    }

    @Override
    public List<StateOfBooks> getAll() {
        return null;
    }
}
