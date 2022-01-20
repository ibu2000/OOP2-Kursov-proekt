package bg.tu_varna.sit.library.data.repositories;

import bg.tu_varna.sit.library.data.access.Connection;
import bg.tu_varna.sit.library.data.entities.FORM;
import bg.tu_varna.sit.library.data.entities.USER;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class FormRepository implements DAORepository<FORM> {

private static final Logger log = Logger.getLogger(FormRepository.class);

public static FormRepository getInstance() {return FormRepository.FormRepositoryHolder.INSTANCE;}

private static class FormRepositoryHolder {
    public static final FormRepository INSTANCE =new FormRepository() ;
}

    @Override
    public void save(FORM obj) {
        Session session = Connection.openSession();
        Transaction transaction = session.beginTransaction();
        try{
            session.save(obj);
            log.info("Form saved successfully");
        }catch (Exception e)
        {
            log.error("Form save error" + e.getMessage());
        }finally {
            transaction.commit();
            session.close();
        }
    }

    @Override
    public void update(FORM obj) {
        Session session = Connection.openSession();
        Transaction transaction = session.beginTransaction();
        try{
            session.update(obj);
            log.info("Form updated successfully");
        }catch (Exception e)
        {
            log.error("Form update error" + e.getMessage());
        }finally {
            transaction.commit();
            session.close();
        }
    }

    @Override
    public void delete(FORM obj) {
        Session session = Connection.openSession();
        Transaction transaction = session.beginTransaction();
        try{
            session.delete(obj);
            log.info("Form deleted successfully");
        }catch (Exception e)
        {
            log.error("Form delete error" + e.getMessage());
        }finally
        {
            transaction.commit();
            session.close();
        }
    }

    @Override
    public Optional<FORM> getByIg(Long id) {
        return Optional.empty();
    }

    @Override
    public List<FORM> getAll() {
        Session session = Connection.openSession();
        Transaction transaction = session.beginTransaction();
        List<FORM> users = new LinkedList<>();
        try {
            String jpql = "SELECT t FROM FORM t";
            users.addAll(session.createQuery(jpql, FORM.class).getResultList());
            log.info("Get all Forms");
        }
        catch (Exception e)
        {
            log.error("Get form error: " + e.getMessage());
        }
        finally {
            transaction.commit();
        }
        return users;
    }
}
