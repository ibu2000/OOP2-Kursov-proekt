package bg.tu_varna.sit.library.data.repositories;

import bg.tu_varna.sit.library.data.access.Connection;
import bg.tu_varna.sit.library.data.entities.Books;
import bg.tu_varna.sit.library.data.entities.LENDBOOKS;
import bg.tu_varna.sit.library.data.entities.UserInfo;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class LendBooksRepository implements DAORepository<LENDBOOKS>{
    private static final Logger log = Logger.getLogger(LendBooksRepository.class);

    public static LendBooksRepository getInstance() {return LendBooksRepository.LendBooksRepositoryHolder.INSTANCE;}

    private static class LendBooksRepositoryHolder {
        public static final LendBooksRepository INSTANCE =new LendBooksRepository() ;
    }

    @Override
    public void save(LENDBOOKS obj) {
        Session session = Connection.openSession();
        Transaction transaction = session.beginTransaction();
        try{
            session.save(obj);
            log.info("Lend Books saved successfully");
        }catch (Exception e)
        {
            log.error("Lend Books save error" + e.getMessage());
        }finally {
            transaction.commit();
            session.close();
    }}

    @Override
    public void update(LENDBOOKS obj) {
            Session session = Connection.openSession();
            Transaction transaction = session.beginTransaction();
            try{
                session.update(obj);
                log.info("Lend Books updated successfully");
            }catch (Exception e)
            {
                log.error("Lend Books update error" + e.getMessage());
            }finally {
                transaction.commit();
                session.close();
            }
    }

    @Override
    public void delete(LENDBOOKS obj) {

            Session session = Connection.openSession();
            Transaction transaction = session.beginTransaction();
            try{
                session.delete(obj);
                log.info("Lend Books deleted successfully");
            }catch (Exception e)
            {
                log.error("Lend Books delete error" + e.getMessage());
            }finally
            {
                transaction.commit();
                session.close();
            }
    }

    @Override
    public Optional<LENDBOOKS> getByIg(Long id) {
        return Optional.empty();
    }

    @Override
    public List<LENDBOOKS> getAll() {
        Session session = Connection.openSession();
        Transaction transaction = session.beginTransaction();
        List<LENDBOOKS> books = new LinkedList<>();
        try {
            String jpql = "SELECT t FROM LENDBOOKS t";
            books.addAll(session.createQuery(jpql, LENDBOOKS.class).getResultList());
            log.info("Get all lend books");
        }
        catch (Exception e)
        {
            log.error("Get lend books error: " + e.getMessage());
        }
        finally {
            transaction.commit();
        }
        return books;
    }
}
