package com.loke.taskapp.domain.requests;

import com.loke.taskapp.domain.entity.TaskPriority;
import com.loke.taskapp.domain.entity.TaskStatus;

import java.time.LocalDate;

public record UpdateTaskRequest(
        String title,
        String description,
        LocalDate dueDate,
        TaskStatus status,
        TaskPriority priority
) {
}
