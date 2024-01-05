package net.javaguides.springboot.controller;

import lombok.AllArgsConstructor;
import net.javaguides.springboot.entity.Task;
import net.javaguides.springboot.service.TaskService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class TaskController {

    private TaskService taskService;

    @PostMapping("/api/saveTask")
    public ResponseEntity<Task> addTask(@RequestBody Task task){
        Task savedTask = taskService.createTask(task);
        return new ResponseEntity<>(savedTask , HttpStatus.CREATED);
    }

    @GetMapping("api/getTask/{id}")
    public ResponseEntity<Task> getTask(@PathVariable long id){
        Task task = taskService.getTask(id);
        return new ResponseEntity<>(task , HttpStatus.OK);
    }

    @PutMapping("api/updateTask/{id}")
    public ResponseEntity<Task> updateTask(@PathVariable Long id,@RequestBody Task task){

        task.setId(id);
        Task updatedTask = taskService.updateTask(task);
        return new ResponseEntity<>(updatedTask , HttpStatus.OK);
    }

    @DeleteMapping("api/deleteTask/{id}")
    public ResponseEntity<String> deleteTask(@PathVariable long id){
        taskService.deleteTask(id);

        return new ResponseEntity<>("Task is successfully deleted !!" , HttpStatus.OK);
    }
}
