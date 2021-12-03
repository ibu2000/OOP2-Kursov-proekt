package bg.tu_varna.sit.library.data.repositories;

import bg.tu_varna.sit.library.data.access.Connection;
import bg.tu_varna.sit.library.data.entities.UserType;
import bg.tu_varna.sit.library.data.entities.UserType;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;
import java.util.Optional;

public class UserTypeRepository implements DAORepository<UserType>{


    private static final Logger log = Logger.getLogger(UserTypeRepository.class);

    private static UserTypeRepository getInstance() {return UserTypeRepositoryHolder.INSTANCE;}

    private static class UserTypeRepositoryHolder {
        public static final UserTypeRepository INSTANCE =new UserTypeRepository();
    }


    @Override
    public void save(UserType obj) {
        Session session = Connection.openSession();
        Transaction transaction = session.beginTransaction();
        try{
            session.save(obj);
            log.info("User Type saved successfully");
        }catch (Exception e)
        {
            log.error("User Type save error" + e.getMessage());
        }finally {
            transaction.commit();
            session.close();
        }
    }

    @Override
    public void update(UserType obj) {
        Session session = Connection.openSession();
        Transaction transaction = session.beginTransaction();
        try{
            session.update(obj);
            log.info("User Type updated successfully");
        }catch (Exception e)
        {
            log.error("User Type update error" + e.getMessage());
        }finally {
            transaction.commit();
            session.close();
        }
    }

    @Override
    public void delete(UserType obj) {
        Session session = Connection.openSession();
        Transaction transaction = session.beginTransaction();
        try{
            session.delete(obj);
            log.info("User Type deleted successfully");
        }catch (Exception e)
        {
            log.error("User Type delete error" + e.getMessage());
        }finally
        {
            transaction.commit();
            session.close();
        }
    }

    @Override
    public Optional<UserType> getByIg(Long id) {
        return Optional.empty();
    }

    @Override
    public List<UserType> getAll() {
        return null;
    }

}
