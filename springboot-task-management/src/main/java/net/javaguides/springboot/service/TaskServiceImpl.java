package net.javaguides.springboot.service;

import lombok.AllArgsConstructor;
import net.javaguides.springboot.entity.Task;
import net.javaguides.springboot.repository.TaskRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
@AllArgsConstructor
public class TaskServiceImpl implements TaskService{
    private TaskRepository taskRepository;
    @Override
    public Task createTask(Task task){
        return taskRepository.save(task);
    }
}
