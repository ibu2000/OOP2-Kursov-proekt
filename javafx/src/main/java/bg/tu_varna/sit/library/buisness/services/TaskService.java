package bg.tu_varna.sit.library.buisness.services;

import bg.tu_varna.sit.library.data.entities.Task;
import bg.tu_varna.sit.library.data.repositories.TaskRepository;

import java.util.List;

public class TaskService {
    private final TaskRepository repository = TaskRepository.getInstance();

    public static TaskService getInstance() {
        return TaskServiceHolder.INSTANCE;
    }


    private static class TaskServiceHolder {
        public static final TaskService INSTANCE = new TaskService();
    }
    public List<Task> getAllTask(){
        List<Task> tasks = repository.getAll();
        return tasks;
    }
}
