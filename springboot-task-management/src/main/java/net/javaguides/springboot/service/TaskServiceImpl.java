package net.javaguides.springboot.service;

import jakarta.persistence.EntityNotFoundException;
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
    public boolean doesTaskExist(Long id) {
        return taskRepository.existsById(id);
    }
    @Override
    public Task updateTask(Task task) {
      long taskId = task.getId();

        Task existingTask = taskRepository.findById(task.getId()).orElseThrow(() -> new EntityNotFoundException("Task with id " + taskId + "not found"));

        existingTask.setTitle(task.getTitle());
        existingTask.setDescription(task.getDescription());

        Task updatedTask = taskRepository.save(existingTask);
        return updatedTask;

    }

    @Override
    public void deleteTask(long id) {
        taskRepository.deleteById(id);
    }


}
