package com.baruchv.controller;

import com.baruchv.model.Task;
import com.baruchv.service.TaskService;
import org.springframework.web.bind.annotation.*;

@RestController
//@RequestMapping("/tasks")
public class TaskController {

    private TaskService service;

    public TaskController(TaskService service) {
        this.service = service;
    }

    // all tasks
    @GetMapping("/list")
    public Iterable<Task> list() {
        return service.list();
    }

    //new task
    @PostMapping("/tasks")
    Task newEmployee(@RequestBody Task newTask) {
        return service.saveNewTask(newTask);
    }

    // Task by Uid
    @GetMapping("/tasks/{uid}")
    Task oneTask(@PathVariable String uid) {
        return service.findTask(uid);
    }

    //Update Date of task
    @PutMapping("/tasks/{uid}")
    Task updateTask(@RequestBody Task newTask, @PathVariable String uid) {
        return service.updateDateTask(newTask,uid);
    }

    // delete by Uid
    @DeleteMapping("/tasks{uid}")
    public void delete(@PathVariable String uid) {
        service.deleteTask(uid);
    }
}

