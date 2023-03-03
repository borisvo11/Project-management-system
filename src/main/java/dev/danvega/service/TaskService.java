package dev.danvega.service;

import dev.danvega.model.Task;
import dev.danvega.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    private final TaskRepository repository;

    public TaskService(TaskRepository repository) {
        this.repository = repository;
    }

    public Iterable<Task> list() {
        return repository.findAll();
    }

    public Task save(Task task) {
        return repository.save(task);
    }

    public void save(List<Task> tasks) {
        repository.saveAll(tasks);
    }
}




