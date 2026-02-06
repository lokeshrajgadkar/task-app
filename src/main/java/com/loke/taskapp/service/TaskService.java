package com.loke.taskapp.service;

import com.loke.taskapp.domain.entity.Task;
import com.loke.taskapp.domain.requests.CreateTaskRequest;
import com.loke.taskapp.domain.requests.UpdateTaskRequest;

import java.util.List;
import java.util.UUID;

public interface TaskService {
    Task createTask(CreateTaskRequest request);
    List<Task> listTasks();
    Task updateTask(UUID taskId, UpdateTaskRequest request);
    void deleteTask(UUID taskId);
}
