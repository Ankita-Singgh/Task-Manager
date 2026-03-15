package com.example.taskmanager.service;

import com.example.taskmanager.entity.Task;
import com.example.taskmanager.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    @Autowired
    private TaskRepository repository;

    // Add task
    public Task addTask(Task task){
        return repository.save(task);
    }

    // Get all tasks
    public List<Task> getAllTasks(){
        return repository.findAll();
    }

    // Mark task as completed
    public Task updateTask(Long id, Task updatedTask){

        Task task = repository.findById(id).orElse(null);

        if(task != null){
            task.setTitle(updatedTask.getTitle());
            task.setCompleted(updatedTask.isCompleted());
            return repository.save(task);
        }

        return null;
    }

    // Delete task
    public void deleteTask(Long id){
        repository.deleteById(id);
    }

}