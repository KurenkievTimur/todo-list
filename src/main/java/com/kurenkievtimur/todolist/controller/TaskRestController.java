package com.kurenkievtimur.todolist.controller;

import com.kurenkievtimur.todolist.dto.task.CreateTaskDto;
import com.kurenkievtimur.todolist.dto.task.EditTaskDto;
import com.kurenkievtimur.todolist.dto.task.TaskDto;
import com.kurenkievtimur.todolist.endpoint.task.TaskEndpoint;
import com.kurenkievtimur.todolist.exception.EntityNotFoundException;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/v1/tasks")
@RestController
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class TaskRestController {

    TaskEndpoint taskEndpoint;

    @GetMapping
    @Operation(summary = "Get all tasks")
    public ResponseEntity<List<TaskDto>> getTasks() {
        return ResponseEntity.ok().body(taskEndpoint.getAll());
    }

    @GetMapping(value = "/{id}")
    @Operation(summary = "Get task by ID")
    public ResponseEntity<TaskDto> getById(@PathVariable Long id) throws EntityNotFoundException {
        return ResponseEntity.ok().body(taskEndpoint.getById(id));
    }

    @PostMapping
    @Operation(summary = "Create task")
    public ResponseEntity<TaskDto> create(@RequestBody @Valid CreateTaskDto taskDto) {
        return ResponseEntity.ok().body(taskEndpoint.create(taskDto));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete task by ID")
    public ResponseEntity<TaskDto> delete(@PathVariable Long id) throws EntityNotFoundException {
        return ResponseEntity.ok().body(taskEndpoint.delete(id));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Edit task by ID")
    public ResponseEntity<TaskDto> edit(@PathVariable Long id, @RequestBody @Valid EditTaskDto taskDto) throws EntityNotFoundException {
        return ResponseEntity.ok().body(taskEndpoint.edit(id, taskDto));
    }
}
