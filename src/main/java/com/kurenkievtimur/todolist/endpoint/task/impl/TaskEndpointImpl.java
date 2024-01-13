package com.kurenkievtimur.todolist.endpoint.task.impl;

import com.kurenkievtimur.todolist.dto.task.CreateTaskDto;
import com.kurenkievtimur.todolist.dto.task.EditTaskDto;
import com.kurenkievtimur.todolist.dto.task.TaskDto;
import com.kurenkievtimur.todolist.endpoint.task.TaskEndpoint;
import com.kurenkievtimur.todolist.entity.Task;
import com.kurenkievtimur.todolist.exception.EntityNotFoundException;
import com.kurenkievtimur.todolist.mapper.task.TaskMapper;
import com.kurenkievtimur.todolist.service.task.TaskService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class TaskEndpointImpl implements TaskEndpoint {

    TaskService taskService;
    TaskMapper taskMapper;

    @Override
    @Transactional(readOnly = true)
    public List<TaskDto> getAll() {
        List<Task> tasks = taskService.getAll();
        return taskMapper.convertTaskToDto(tasks);
    }

    @Override
    @Transactional(readOnly = true)
    public TaskDto getById(Long id) throws EntityNotFoundException {
        Task task = taskService.getById(id)
                .orElseThrow(() -> new EntityNotFoundException("Task not found with id: %d".formatted(id)));
        return taskMapper.convertTaskToDto(task);
    }

    @Override
    @Transactional
    public TaskDto create(CreateTaskDto taskDto) {
        Task task = taskService.saveOrUpdate(taskMapper.convertTaskDtoToEntity(taskDto));
        return taskMapper.convertTaskToDto(task);
    }

    @Override
    @Transactional
    public TaskDto delete(Long id) throws EntityNotFoundException {
        Task task = taskService.getById(id)
                .orElseThrow(() -> new EntityNotFoundException("Task not found with id: %d".formatted(id)));
        taskService.delete(task);
        return taskMapper.convertTaskToDto(task);
    }

    @Override
    @Transactional
    public TaskDto edit(Long id, EditTaskDto taskDto) throws EntityNotFoundException {
        Task task = taskService.getById(id)
                .orElseThrow(() -> new EntityNotFoundException("Task not found with id: %d".formatted(id)));
        return taskMapper.convertTaskToDto(taskService.edit(task, taskDto));
    }
}
