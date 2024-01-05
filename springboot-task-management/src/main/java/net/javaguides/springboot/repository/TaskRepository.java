package net.javaguides.springboot.repository;

import net.javaguides.springboot.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {

}
