package bg.tu_varna.sit.library.data.repositories;
import bg.tu_varna.sit.library.data.access.Connection;
import bg.tu_varna.sit.library.data.entities.UserType;
import bg.tu_varna.sit.library.data.entities.UserType;
import javafx.concurrent.Task;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.LinkedList;
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
    }

    @Override
    public void update(UserType obj) {
    }

    @Override
    public void delete(UserType obj) {
    }

    @Override
    public Optional<UserType> getByIg(Long id) {
        return Optional.empty();
    }

    @Override
    public List<UserType> getAll() {
        Session session = Connection.openSession();
        Transaction transaction = session.beginTransaction();
        List<UserType> tasks = new LinkedList<>();
        try {
            String jpql = "SELECT t FROM TASK t";
            tasks.addAll(session.createQuery(jpql, Task.class).getResultList());
            log.info("Get all tasks");
        }catch(Exception ex) {
            log.error("Get Task Error: " + ex.getMessage());
        }finally {
            transaction.commit();
        }
        return tasks;
    }
    }

}
