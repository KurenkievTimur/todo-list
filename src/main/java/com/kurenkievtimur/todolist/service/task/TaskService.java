package com.kurenkievtimur.todolist.service.task;

import com.kurenkievtimur.todolist.dto.task.EditTaskDto;
import com.kurenkievtimur.todolist.entity.Task;
import com.kurenkievtimur.todolist.service.BaseService;

public interface TaskService extends BaseService<Task, Long> {
    Task edit(Task task, EditTaskDto taskDto);
}
