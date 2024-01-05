package net.javaguides.springboot.service;

import lombok.AllArgsConstructor;
import net.javaguides.springboot.entity.Task;
import net.javaguides.springboot.repository.TaskRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.server.ResponseStatusException;

@Service
@AllArgsConstructor
public class TaskServiceImpl implements TaskService{
    private TaskRepository taskRepository;
    @Override
    public Task createTask(Task task){
        return taskRepository.save(task);
    }

    @Override
    public Task getTask(long id) {
         return taskRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND , "Task not found with id " + id));
    }
}
