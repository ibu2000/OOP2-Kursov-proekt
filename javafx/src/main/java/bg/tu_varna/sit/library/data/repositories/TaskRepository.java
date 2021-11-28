package bg.tu_varna.sit.library.data.repositories;

import bg.tu_varna.sit.library.data.access.Connection;
import bg.tu_varna.sit.library.data.entities.Task;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class TaskRepository implements DAORepository<Task>{

    private static final Logger log = Logger.getLogger(TaskRepository.class);

    private static TaskRepository getInstance() {return TaskRepository.TaskRepositoryHolder.INSTANCE;}

    private static class TaskRepositoryHolder {
        public static final TaskRepository INSTANCE =new TaskRepository() ;
    }
    @Override
    public void save(Task obj) {

    }

    @Override
    public void update(Task obj) {

    }

    @Override
    public void delete(Task obj) {

    }

    @Override
    public Optional<Task> getByIg(Long id) {
        return Optional.empty();
    }

    @Override
    public List<Task> getAll() {
        Session session = Connection.openSession();
        Transaction transaction = session.beginTransaction();
        List<Task> tasks = new LinkedList<>();
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
