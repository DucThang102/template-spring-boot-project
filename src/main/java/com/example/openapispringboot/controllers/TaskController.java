package com.example.openapispringboot.controllers;

import com.example.openapispringboot.entities.Task;
import com.example.openapispringboot.services.ThreadPoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("/tasks")
public class TaskController {

    @Autowired
    private ThreadPoolService threadPoolService;

    @PostMapping("")
    public Task addTask(@RequestBody Task task) {
        return threadPoolService.addTask(task);
    }

    @PostMapping("/kill/{id}")
    public boolean killTask(@PathVariable String id) {
        return threadPoolService.killTask(id);
    }
}
