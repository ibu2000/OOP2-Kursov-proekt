package bg.tu_varna.sit.library.buisness.services;

import bg.tu_varna.sit.library.data.entities.Task;
import bg.tu_varna.sit.library.data.repositories.TaskRepository;
import bg.tu_varna.sit.library.presentation.TaskListViewModel;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.List;
import java.util.stream.Collectors;

public class TaskService {
    private final TaskRepository repository = TaskRepository.getInstance();

    public static TaskService getInstance() {
        return TaskServiceHolder.INSTANCE;
    }


    private static class TaskServiceHolder {
        public static final TaskService INSTANCE = new TaskService();
    }
    public ObservableList<TaskListViewModel> getAllTask(){
        List<Task> tasks = repository.getAll();

        return FXCollections.observableList(
            tasks
                    .stream().map(t -> new TaskListViewModel(
                    t.getTitle(),
                t.getDescription(),
                t.getUser().getUserName()
            )).collect(Collectors.toList()));

    }
}
