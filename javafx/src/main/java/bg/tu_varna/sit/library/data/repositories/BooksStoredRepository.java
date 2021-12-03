package bg.tu_varna.sit.library.data.repositories;

import bg.tu_varna.sit.library.data.access.Connection;
import bg.tu_varna.sit.library.data.entities.BOOKSSTORED;
import bg.tu_varna.sit.library.data.entities.Eksemplqri;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

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
        Session session = Connection.openSession();
        Transaction transaction = session.beginTransaction();
        try{
            session.save(obj);
            log.info("Books stored saved successfully");
        }catch (Exception e)
        {
            log.error("Books stored save error" + e.getMessage());
        }finally {
            transaction.commit();
            session.close();
        }
    }

    @Override
    public void update(BOOKSSTORED obj) {
        Session session = Connection.openSession();
        Transaction transaction = session.beginTransaction();
        try{
            session.update(obj);
            log.info("Books Stored updated successfully");
        }catch (Exception e)
        {
            log.error("Books Stored update error" + e.getMessage());
        }finally {
            transaction.commit();
            session.close();
        }

    }

    @Override
    public void delete(BOOKSSTORED obj) {

        Session session = Connection.openSession();
        Transaction transaction = session.beginTransaction();
        try{
            session.delete(obj);
            log.info("Books Stored deleted successfully");
        }catch (Exception e)
        {
            log.error("Books Stored delete error" + e.getMessage());
        }finally
        {
            transaction.commit();
            session.close();
        }
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
