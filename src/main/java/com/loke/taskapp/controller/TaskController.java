package com.loke.taskapp.controller;

import com.loke.taskapp.domain.dto.CreateTaskRequestDTO;
import com.loke.taskapp.domain.dto.TaskDTO;
import com.loke.taskapp.domain.entity.Task;
import com.loke.taskapp.domain.requests.CreateTaskRequest;
import com.loke.taskapp.mapper.TaskMapper;
import com.loke.taskapp.service.TaskService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    ){
        CreateTaskRequest createTaskRequest = taskMapper.fromDto(createTaskRequestDTO);
        Task task = taskService.createTask(createTaskRequest);
        TaskDTO createdtaskDto = taskMapper.toDto(task);
        return new ResponseEntity<>(createdtaskDto, HttpStatus.CREATED);
    }
}

