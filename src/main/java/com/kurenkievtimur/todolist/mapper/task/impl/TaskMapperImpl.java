package com.kurenkievtimur.todolist.mapper.task.impl;

import com.kurenkievtimur.todolist.dto.task.CreateTaskDto;
import com.kurenkievtimur.todolist.dto.task.TaskDto;
import com.kurenkievtimur.todolist.entity.Task;
import com.kurenkievtimur.todolist.mapper.task.TaskMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

import static com.kurenkievtimur.todolist.util.enums.TaskStatus.NOT_COMPLETED;

@Component
public class TaskMapperImpl implements TaskMapper {
    @Override
    public List<TaskDto> convertTaskToDto(List<Task> tasks) {
        return tasks.stream().map(this::convertTaskToDto).collect(Collectors.toList());
    }

    @Override
    public TaskDto convertTaskToDto(Task task) {
        return TaskDto.builder()
                .id(task.getId())
                .title(task.getTitle())
                .description(task.getDescription())
                .status(task.getStatus())
                .build();
    }

    @Override
    public Task convertTaskDtoToEntity(CreateTaskDto taskDto) {
        return Task.builder()
                .title(taskDto.getTitle())
                .description(taskDto.getDescription())
                .status(NOT_COMPLETED)
                .build();
    }
}
