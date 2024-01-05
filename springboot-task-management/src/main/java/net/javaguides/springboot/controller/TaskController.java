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
        return new ResponseEntity<>(savedTask , HttpStatus.OK);
    }

    @GetMapping("api/getTask/{id}")
    public ResponseEntity<Task> getTask(@PathVariable long id){
        Task task = taskService.getTask(id);
        return new ResponseEntity<>(task , HttpStatus.OK);
    }

}
