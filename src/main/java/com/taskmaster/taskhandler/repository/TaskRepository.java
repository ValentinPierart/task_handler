package com.taskmaster.taskhandler.repository;

import com.taskmaster.taskhandler.model.Task;
import org.springframework.data.repository.CrudRepository;

public interface TaskRepository extends CrudRepository<Task, Long> {

    Task findById(long id);
}
