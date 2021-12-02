package bg.tu_varna.sit.library.data.repositories;

import bg.tu_varna.sit.library.data.access.Connection;
import bg.tu_varna.sit.library.data.entities.Status;
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

    @Override
    public void save(Status obj) {
    }

    @Override
    public void update(Status obj) {
    }

    @Override
    public void delete(Status obj) {
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
