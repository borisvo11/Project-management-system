package dev.danvega.controller;

import dev.danvega.model.Task;
import dev.danvega.service.TaskService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}

