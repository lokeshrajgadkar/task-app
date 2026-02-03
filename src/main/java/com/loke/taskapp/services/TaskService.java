package com.loke.taskapp.services;

import com.loke.taskapp.domain.entity.Task;
import com.loke.taskapp.domain.requests.CreateTaskRequest;

public interface TaskService {
    public Task createTask(CreateTaskRequest request);
}
