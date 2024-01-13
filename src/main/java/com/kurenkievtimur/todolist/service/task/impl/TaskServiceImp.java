package com.kurenkievtimur.todolist.service.task.impl;

import com.kurenkievtimur.todolist.dto.task.EditTaskDto;
import com.kurenkievtimur.todolist.entity.Task;
import com.kurenkievtimur.todolist.repository.TaskRepository;
import com.kurenkievtimur.todolist.service.BaseCrudService;
import com.kurenkievtimur.todolist.service.task.TaskService;
import com.kurenkievtimur.todolist.util.enums.TaskStatus;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class TaskServiceImp extends BaseCrudService<Task, Long> implements TaskService {

    public TaskServiceImp(TaskRepository repository) {
        super(repository);
    }

    @Override
    @Transactional
    public Task edit(Task task, EditTaskDto taskDto) {
        task.setTitle(taskDto.getTitle());
        task.setDescription(taskDto.getDescription());
        task.setStatus(TaskStatus.valueOf(taskDto.getStatus()));

        return repository.save(task);
    }
}