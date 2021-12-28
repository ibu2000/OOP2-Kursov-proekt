package bg.tu_varna.sit.library.data.repositories;

import bg.tu_varna.sit.library.data.access.Connection;
import bg.tu_varna.sit.library.data.entities.USER;
import bg.tu_varna.sit.library.data.entities.UserInfo;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class UserInfoRepository implements DAORepository<UserInfo> {

    private static final Logger log = Logger.getLogger(UserInfoRepository.class);

    public static UserInfoRepository getInstance() {return UserInfoRepository.UserInfoRepositoryHolder.INSTANCE;}

    private static class UserInfoRepositoryHolder {
        public static final UserInfoRepository INSTANCE =new UserInfoRepository() ;
    }

    @Override
    public void save(UserInfo obj) {
        Session session = Connection.openSession();
        Transaction transaction = session.beginTransaction();
        try{
            session.save(obj);
            log.info("User Info saved successfully");
        }catch (Exception e)
        {
            log.error("User Info save error" + e.getMessage());
        }finally {
            transaction.commit();
            session.close();
        }

    }

    @Override
    public void update(UserInfo  obj) {
        Session session = Connection.openSession();
        Transaction transaction = session.beginTransaction();
        try{
            session.update(obj);
            log.info("User Info updated successfully");
        }catch (Exception e)
        {
            log.error("User Info update error" + e.getMessage());
        }finally {
            transaction.commit();
            session.close();
        }
    }

    @Override
    public void delete(UserInfo  obj) {
        Session session = Connection.openSession();
        Transaction transaction = session.beginTransaction();
        try{
            session.delete(obj);
            log.info("User Info deleted successfully");
        }catch (Exception e)
        {
            log.error("User Info delete error" + e.getMessage());
        }finally
        {
            transaction.commit();
            session.close();
        }
    }

    @Override
    public Optional<UserInfo> getByIg(Long id) {
        return Optional.empty();
    }

    @Override
    public List<UserInfo> getAll() {
        Session session = Connection.openSession();
        Transaction transaction = session.beginTransaction();
        List<UserInfo> users = new LinkedList<>();
        try {
            String jpql = "SELECT t FROM UserInfo t";
            users.addAll(session.createQuery(jpql, UserInfo.class).getResultList());
            log.info("Get all userInfo");
        }
        catch (Exception e)
        {
            log.error("Get userInfo error: " + e.getMessage());
        }
        finally {
            transaction.commit();
        }
        return users;
    }


}
