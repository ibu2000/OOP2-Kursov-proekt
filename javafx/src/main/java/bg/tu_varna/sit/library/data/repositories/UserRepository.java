package bg.tu_varna.sit.library.data.repositories;

import bg.tu_varna.sit.library.data.access.Connection;
import bg.tu_varna.sit.library.data.entities.USER;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.Query;
import java.util.List;
import java.util.Optional;

public class UserRepository implements DAORepository<USER> {

    private static final Logger log = Logger.getLogger(UserRepository.class);

    private static UserRepository getInstance() {return UserRepository.UserRepositoryHolder.INSTANCE;}

    private static class UserRepositoryHolder {
        public static final UserRepository INSTANCE =new UserRepository() ;
    }

    @Override
    public void save(USER obj) {
        Session session = Connection.openSession();
        Transaction transaction = session.beginTransaction();
        try{
            session.save(obj);
            log.info("User saved successfully");
        }catch (Exception e)
        {
            log.error("User save error" + e.getMessage());
        }finally {
            transaction.commit();
            session.close();
        }
    }

    @Override
    public void update(USER obj) {
        Session session = Connection.openSession();
        Transaction transaction = session.beginTransaction();
        try{
            session.update(obj);
            log.info("User updated successfully");
        }catch (Exception e)
        {
            log.error("User update error" + e.getMessage());
        }finally {
            transaction.commit();
            session.close();
        }
    }

    @Override
    public void delete(USER obj) {
        Session session = Connection.openSession();
        Transaction transaction = session.beginTransaction();
        try{
            session.delete(obj);
            Query query = session.createQuery("select username FROM USER WHERE username =: un");
            query.setParameter("un","username1");
            query.executeUpdate();
            query.getResultList();
            log.info("User deleted successfully");
        }catch (Exception e)
        {
            log.error("User delete error" + e.getMessage());
        }finally
        {
            transaction.commit();
            session.close();
        }
    }

    @Override
    public Optional<USER> getByIg(Long id) {
        return Optional.empty();
    }

    @Override
    public List<USER> getAll() {
        return null;
    }


}
