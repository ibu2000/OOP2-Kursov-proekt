package bg.tu_varna.sit.library.data.repositories;

import bg.tu_varna.sit.library.data.access.Connection;
import bg.tu_varna.sit.library.data.entities.StateOfBooks;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class StateOfBooksRepository implements DAORepository<StateOfBooks>{

    private static final Logger log = Logger.getLogger(StateOfBooksRepository.class);

    public static StateOfBooksRepository getInstance() {return StateOfBooksRepositoryHolder.INSTANCE;}

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

    public StateOfBooks getByID(int id) {
        Session session = Connection.openSession();
        Transaction transaction = session.beginTransaction();
        List<StateOfBooks> stateOfBooks = new LinkedList<>();
        try{
            String jpql = "SELECT a FROM StateOfBooks a WHERE idState ="+id;
            stateOfBooks.addAll(session.createQuery(jpql, StateOfBooks.class).getResultList());
            log.info("Successfully got  state!");
        }catch (Exception e){
            log.error("Get state of books error: " +e.getMessage());
        }finally {
            transaction.commit();
            session.close();
        }

        return stateOfBooks.get(0);
    }

    @Override
    public List<StateOfBooks> getAll() {
            Session session = Connection.openSession();
            Transaction transaction = session.beginTransaction();
            List<StateOfBooks> stateOfBooks = new LinkedList<>();
            try {
                String jpql = "SELECT t FROM StateOfBooks t";
                stateOfBooks.addAll(session.createQuery(jpql, StateOfBooks.class).getResultList());
                log.info("Get all states of books");
            }
            catch (Exception e)
            {
                log.error("Get book state error: " + e.getMessage());
            }
            finally {
                transaction.commit();
            }
            return stateOfBooks;

    }
}
