package bg.tu_varna.sit.library.data.repositories;

import bg.tu_varna.sit.library.data.access.Connection;
import bg.tu_varna.sit.library.data.entities.LENDBOOKS;
import bg.tu_varna.sit.library.data.entities.LENDINFO;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class LendingInfoRepository implements DAORepository<LENDINFO> {
    private static final Logger log = Logger.getLogger(LendingInfoRepository.class);

    public static LendingInfoRepository getInstance() {return LendingInfoRepository.LendingInfoRepositoryHolder.INSTANCE;}

    private static class LendingInfoRepositoryHolder {
        public static final LendingInfoRepository INSTANCE =new LendingInfoRepository() ;
    }

    @Override
    public void save(LENDINFO obj) {
        Session session = Connection.openSession();
        Transaction transaction = session.beginTransaction();
        try{
            session.save(obj);
            log.info("Lend Info saved successfully");
        }catch (Exception e)
        {
            log.error("Lend Info save error" + e.getMessage());
        }finally {
            transaction.commit();
            session.close();
        }
    }

    @Override
    public void update(LENDINFO obj) {
        Session session = Connection.openSession();
        Transaction transaction = session.beginTransaction();
        try{
            session.update(obj);
            log.info("Lend Info updated successfully");
        }catch (Exception e)
        {
            log.error("Lend Info update error" + e.getMessage());
        }finally {
            transaction.commit();
            session.close();
        }
    }

    @Override
    public void delete(LENDINFO obj) {
        Session session = Connection.openSession();
        Transaction transaction = session.beginTransaction();
        try{
            session.delete(obj);
            log.info("Lend Info deleted successfully");
        }catch (Exception e)
        {
            log.error("Lend Info delete error" + e.getMessage());
        }finally
        {
            transaction.commit();
            session.close();
        }
    }

    @Override
    public Optional<LENDINFO> getByIg(Long id) {
        return Optional.empty();
    }

    @Override
    public List<LENDINFO> getAll() {

        Session session = Connection.openSession();
        Transaction transaction = session.beginTransaction();
        List<LENDINFO> books = new LinkedList<>();
        try {
            String jpql = "SELECT t FROM LENDINFO t";
            books.addAll(session.createQuery(jpql, LENDINFO.class).getResultList());
            log.info("Get all lend info");
        }
        catch (Exception e)
        {
            log.error("Get lend info error: " + e.getMessage());
        }
        finally {
            transaction.commit();
        }
        return books;
    }
}


