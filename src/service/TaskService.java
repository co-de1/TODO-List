package service;

import model.Status;
import model.Task;
import app.TaskRepository;
import java.util.List;

public class TaskService {
    private final TaskRepository repository = new TaskRepository();

    public void addTask(Task task) {
        repository.addTask(task);
    }

    public boolean deleteTask(String name) {
        return repository.removeTask(name);
    }

    public List<Task> listAll() {
        return repository.getAll();
    }

    public List<Task> listByCategory(String category) {
        return repository.getByCategory(category);
    }

    public List<Task> listByStatus(String status) {
        return repository.getByStatus(Status.valueOf(String.valueOf(Status.valueOf(status))));
    }

    public List<Task> listByPriority(int priority) {
        return repository.getByPriority(priority);
    }
}
