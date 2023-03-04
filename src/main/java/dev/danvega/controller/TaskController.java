package dev.danvega.controller;

import dev.danvega.model.Task;
import dev.danvega.service.TaskService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    private TaskService service;

    public TaskController(TaskService service) {
        this.service = service;
    }

    @GetMapping("/list")
    public Iterable<Task> list() {
        return service.list();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) {
        service.delete(id);
//        service.deleteTask(uid);
    }

}

