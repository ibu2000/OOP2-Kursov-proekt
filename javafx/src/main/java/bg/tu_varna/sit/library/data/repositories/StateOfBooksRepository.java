package bg.tu_varna.sit.library.data.repositories;

import bg.tu_varna.sit.library.data.access.Connection;
import bg.tu_varna.sit.library.data.entities.StateOfBooks;
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
        Session session = Connection.openSession();
        Transaction transaction = session.beginTransaction();
        try{
            session.save(obj);
            log.info("State of Books saved successfully");
        }catch (Exception e)
        {
            log.error("State of Books save error" + e.getMessage());
        }finally {
            transaction.commit();
            session.close();
        }
    }

    @Override
    public void update(StateOfBooks obj) {
        Session session = Connection.openSession();
        Transaction transaction = session.beginTransaction();
        try{
            session.update(obj);
            log.info("State of Books updated successfully");
        }catch (Exception e)
        {
            log.error("State of Books update error" + e.getMessage());
        }finally {
            transaction.commit();
            session.close();
        }
    }

    @Override
    public void delete(StateOfBooks obj) {
        Session session = Connection.openSession();
        Transaction transaction = session.beginTransaction();
        try{
            session.delete(obj);
            log.info("State of Books deleted successfully");
        }catch (Exception e)
        {
            log.error("State of Books delete error" + e.getMessage());
        }finally
        {
            transaction.commit();
            session.close();
        }
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
