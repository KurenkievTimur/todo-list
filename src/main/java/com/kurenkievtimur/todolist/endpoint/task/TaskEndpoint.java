package com.kurenkievtimur.todolist.endpoint.task;

import com.kurenkievtimur.todolist.dto.task.CreateTaskDto;
import com.kurenkievtimur.todolist.dto.task.EditTaskDto;
import com.kurenkievtimur.todolist.dto.task.TaskDto;
import com.kurenkievtimur.todolist.exception.EntityNotFoundException;

import java.util.List;

public interface TaskEndpoint {
    List<TaskDto> getAll();

    TaskDto getById(Long id) throws EntityNotFoundException;

    TaskDto create(CreateTaskDto taskDto);

    TaskDto delete(Long id) throws EntityNotFoundException;

    TaskDto edit(Long id, EditTaskDto taskDto) throws EntityNotFoundException;
}
