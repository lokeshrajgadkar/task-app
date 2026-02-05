package com.loke.taskapp.service.impl;

import com.loke.taskapp.domain.entity.Task;
import com.loke.taskapp.domain.entity.TaskStatus;
import com.loke.taskapp.domain.requests.CreateTaskRequest;
import com.loke.taskapp.repository.TaskRepository;
import com.loke.taskapp.service.TaskService;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
public class TaskServiceImpl implements TaskService {
    private final TaskRepository taskRepository;

    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public Task createTask(CreateTaskRequest request) {
        Instant now = Instant.now();
        Task task = new Task(
                null,
                request.title(),request.description(),request.dueDate(),
                TaskStatus.OPEN, request.priority(),now,now
        );
        return taskRepository.save(task);
    }
}
