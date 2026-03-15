package com.example.taskmanager.controller;

import com.example.taskmanager.entity.Task;
import com.example.taskmanager.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins="*")
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private TaskService service;

    // Add new task
    @PostMapping
    public Task addTask(@RequestBody Task task){
        return service.addTask(task);
    }

    // Get all tasks
    @GetMapping
    public List<Task> getTasks(){
        return service.getAllTasks();
    }

    // Update task
    @PutMapping("/{id}")
    public Task updateTask(@PathVariable Long id,
                           @RequestBody Task task){
        return service.updateTask(id, task);
    }

    // Delete task
    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id){
        service.deleteTask(id);
    }

}