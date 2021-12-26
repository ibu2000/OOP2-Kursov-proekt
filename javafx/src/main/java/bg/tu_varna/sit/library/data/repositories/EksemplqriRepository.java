package bg.tu_varna.sit.library.data.repositories;

import bg.tu_varna.sit.library.data.access.Connection;
import bg.tu_varna.sit.library.data.entities.Eksemplqri;
import bg.tu_varna.sit.library.data.entities.LENDINFO;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;
import java.util.Optional;

public class EksemplqriRepository implements DAORepository<Eksemplqri> {
    private static final Logger log = Logger.getLogger(EksemplqriRepository.class);

    public static EksemplqriRepository getInstance() {return EksemplqriRepository.EksemplqriRepositoryHolder.INSTANCE;}

    private static class EksemplqriRepositoryHolder {
        public static final EksemplqriRepository INSTANCE =new EksemplqriRepository() ;
    }

    @Override
    public void save(Eksemplqri obj) {

        Session session = Connection.openSession();
        Transaction transaction = session.beginTransaction();
        try{
            session.save(obj);
            log.info("Eksemplqri saved successfully");
        }catch (Exception e)
        {
            log.error("Eksemplqri save error" + e.getMessage());
        }finally {
            transaction.commit();
            session.close();
        }
    }

    @Override
    public void update(Eksemplqri obj) {
        Session session = Connection.openSession();
        Transaction transaction = session.beginTransaction();
        try{
            session.update(obj);
            log.info("Eksemplqri updated successfully");
        }catch (Exception e)
        {
            log.error("Eksemplqri update error" + e.getMessage());
        }finally {
            transaction.commit();
            session.close();
        }
    }

    @Override
    public void delete(Eksemplqri obj) {
        Session session = Connection.openSession();
        Transaction transaction = session.beginTransaction();
        try{
            session.delete(obj);
            log.info("Eksemplqri deleted successfully");
        }catch (Exception e)
        {
            log.error("Eksemplqri delete error" + e.getMessage());
        }finally
        {
            transaction.commit();
            session.close();
        }

    }

    @Override
    public Optional<Eksemplqri> getByIg(Long id) {
        return Optional.empty();
    }

    @Override
    public List<Eksemplqri> getAll() {
        return null;
    }
}