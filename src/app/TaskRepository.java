package app;

import model.Status;
import model.Task;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class TaskRepository {
    private final List<Task> tasks = new ArrayList<>();

    public void addTask(Task task) {
        tasks.add(task);
        tasks.sort(Comparator.comparingInt(o -> task.getPriority()).reversed());
    }

    public boolean removeTask(String name) {
        if (tasks.isEmpty()) {
            return false;
        }
        return tasks.removeIf(task -> task.getName().equalsIgnoreCase(name));
    }

    public List<Task> getAll() {
        return new ArrayList<>(tasks);
    }

    public List<Task> getByCategory(String category) {
        if (category == null) return List.of();
        return tasks.stream()
                .filter(t -> t.getCategory().equalsIgnoreCase(category))
                .toList();
    }

    public List<Task> getByStatus(Status status) {
        if (status == null) return List.of();

        return tasks.stream()
                .filter(t -> t.getStatus() == status)
                .toList();
    }


    public List<Task> getByPriority(int priority) {
        return tasks.stream()
                .filter(t -> t.getPriority() == priority)
                .toList();
    }

    public List<Task> getOverdueTasks() {
        LocalDate today = LocalDate.now();
        return tasks.stream()
                .filter(t -> t.getDataTermino() != null &&
                        t.getDataTermino().isBefore(today) &&
                        t.getStatus() != Status.DONE)
                .toList();
    }

    public boolean containsTask(String name) {
        return tasks.stream()
                .anyMatch(t -> t.getName().equalsIgnoreCase(name));
    }

    public int getTotalTasks() {
        return tasks.size();
    }
}
