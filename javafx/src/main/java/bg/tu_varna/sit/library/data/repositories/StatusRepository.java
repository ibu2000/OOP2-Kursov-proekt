package bg.tu_varna.sit.library.data.repositories;

import bg.tu_varna.sit.library.data.access.Connection;
import bg.tu_varna.sit.library.data.entities.Status;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;
import java.util.Optional;

public class StatusRepository implements DAORepository<Status> {

    private static final Logger log = Logger.getLogger(StatusRepository.class);

    private static StatusRepository getInstance() {return StatusRepositoryHolder.INSTANCE;}

    private static class StatusRepositoryHolder {
        public static final StatusRepository INSTANCE =new StatusRepository();
    }

    @FXML
    private Button button_log_in;

    @Override
    public void save(Status obj) {
        Session session = Connection.openSession();
        Transaction transaction = session.beginTransaction();
        try{
            session.save(obj);
            log.info("Status saved successfully");
        }catch (Exception e)
        {
            log.error("Status save error" + e.getMessage());
        }finally {
            transaction.commit();
            session.close();
        }
    }

    @Override
    public void update(Status obj) {
        Session session = Connection.openSession();
        Transaction transaction = session.beginTransaction();
        try{
            session.update(obj);
            log.info("Status updated successfully");
        }catch (Exception e)
        {
            log.error("Status update error" + e.getMessage());
        }finally {
            transaction.commit();
            session.close();
        }
    }

    @Override
    public void delete(Status obj) {
        Session session = Connection.openSession();
        Transaction transaction = session.beginTransaction();
        try{
            session.delete(obj);
            log.info("Status deleted successfully");
        }catch (Exception e)
        {
            log.error("Status delete error" + e.getMessage());
        }finally
        {
            transaction.commit();
            session.close();
        }
    }

    @Override
    public Optional<Status> getByIg(Long id) {
        return Optional.empty();
    }

    @Override
    public List<Status> getAll() {
        return null;
    }



}
