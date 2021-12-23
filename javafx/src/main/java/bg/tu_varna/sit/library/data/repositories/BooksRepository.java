package bg.tu_varna.sit.library.data.repositories;
import bg.tu_varna.sit.library.data.access.Connection;
import bg.tu_varna.sit.library.data.entities.Books;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.locks.Condition;

public class BooksRepository implements DAORepository<Books>{

    private static final Logger log = Logger.getLogger(BooksRepository.class);

    public static BooksRepository getInstance() {return BooksRepositoryHolder.INSTANCE;}

    private static class BooksRepositoryHolder {
        public static final BooksRepository INSTANCE = new BooksRepository();
    }

  @Override
   public void save(Books obj)
    {    Session session = Connection.openSession();
        Transaction transaction = session.beginTransaction();
        try{
            session.save(obj);
            log.info("Book saved successfully");
            }catch (Exception e)
        {
            log.error("Book save error" + e.getMessage());
        }finally {
            transaction.commit();
            session.close();
        }
    }


    @Override
    public void update(Books obj) {
        Session session = Connection.openSession();
        Transaction transaction = session.beginTransaction();
        try{
            session.update(obj);
            log.info("Product updated successfully");
            }catch (Exception e)
            {
                log.error("Product update error" + e.getMessage());
            }finally {
                transaction.commit();
                session.close();
        }
    }

    @Override
    public void delete(Books obj) {

        Session session = Connection.openSession();
        Transaction transaction = session.beginTransaction();
        try{
            session.delete(obj);
            log.info("Product deleted successfully");
            }catch (Exception e)
            {
                log.error("Product delete error" + e.getMessage());
            }finally
            {
                transaction.commit();
                session.close();
            }
    }

    @Override
    public Optional<Books> getByIg(Long id) {
        return Optional.empty();
    }

    @Override
    public List<Books> getAll() {
        Session session = Connection.openSession();
        Transaction transaction = session.beginTransaction();
        List<Books> books = new LinkedList<>();
        try {
            String jpql = "SELECT t FROM Books t";
           books.addAll(session.createQuery(jpql, Books.class).getResultList());
            log.info("Get all books");
        }
        catch (Exception e)
        {
            log.error("Get book error: " + e.getMessage());
        }
        finally {
            transaction.commit();
        }
        return books;
    }
}

