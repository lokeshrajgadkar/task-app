package com.loke.taskapp.service;

import com.loke.taskapp.domain.entity.Task;
import com.loke.taskapp.domain.requests.CreateTaskRequest;

public interface TaskService {
    Task createTask(CreateTaskRequest request);
}
