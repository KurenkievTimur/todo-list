package com.kurenkievtimur.todolist.repository;

import com.kurenkievtimur.todolist.entity.Task;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends ListCrudRepository<Task, Long> {
}
