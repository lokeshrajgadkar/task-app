package com.loke.taskapp.controller;

import com.loke.taskapp.domain.dto.CreateTaskRequestDTO;
import com.loke.taskapp.domain.dto.TaskDTO;
import com.loke.taskapp.domain.dto.UpdateTaskRequestDTO;
import com.loke.taskapp.domain.entity.Task;
import com.loke.taskapp.domain.requests.CreateTaskRequest;
import com.loke.taskapp.domain.requests.UpdateTaskRequest;
import com.loke.taskapp.mapper.TaskMapper;
import com.loke.taskapp.service.TaskService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/tasks")
public class TaskController {
    private final TaskService taskService;
    private final TaskMapper taskMapper;

    public TaskController(TaskService taskService, TaskMapper taskMapper) {
        this.taskService = taskService;
        this.taskMapper = taskMapper;
    }

    @PostMapping
    public ResponseEntity<TaskDTO> createTask(
            @Valid @RequestBody CreateTaskRequestDTO createTaskRequestDTO
    ) {
        CreateTaskRequest createTaskRequest = taskMapper.fromDto(createTaskRequestDTO);
        Task task = taskService.createTask(createTaskRequest);
        TaskDTO createdtaskDto = taskMapper.toDto(task);
        return new ResponseEntity<>(createdtaskDto, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<TaskDTO>> listTasks() {
        List<Task> tasks = taskService.listTasks();
        List<TaskDTO> taskDTOS = tasks.stream().map(taskMapper::toDto).toList();
        return ResponseEntity.ok(taskDTOS);
    }

    @PutMapping(path = "/{taskId}")
    public ResponseEntity<TaskDTO> updateTask(
            @PathVariable UUID taskId,
            @Valid @RequestBody UpdateTaskRequestDTO updateTaskRequestDTO) {
        UpdateTaskRequest updateTaskRequest = taskMapper.fromDto(updateTaskRequestDTO);
        Task updatedTask = taskService.updateTask(taskId, updateTaskRequest);
        TaskDTO taskDTO = taskMapper.toDto(updatedTask);

        return ResponseEntity.ok(taskDTO);
    }

    @DeleteMapping(path = "/{taskId}")
    public ResponseEntity<Void> deleteTask(@PathVariable UUID taskId) {
        taskService.deleteTask(taskId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

