package net.javaguides.springboot.service;

import net.javaguides.springboot.entity.Task;
import org.springframework.stereotype.Service;


public interface TaskService {
    Task createTask(Task task);
    Task getTask(long id);

    Task updateTask(Task task);

    void deleteTask(long id);

}
