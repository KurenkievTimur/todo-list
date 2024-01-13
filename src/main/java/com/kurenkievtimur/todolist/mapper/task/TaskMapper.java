package com.kurenkievtimur.todolist.mapper.task;

import com.kurenkievtimur.todolist.dto.task.CreateTaskDto;
import com.kurenkievtimur.todolist.dto.task.TaskDto;
import com.kurenkievtimur.todolist.entity.Task;

import java.util.List;

public interface TaskMapper {
    List<TaskDto> convertTaskToDto(List<Task> tasks);

    TaskDto convertTaskToDto(Task task);

    Task convertTaskDtoToEntity(CreateTaskDto taskDto);
}
