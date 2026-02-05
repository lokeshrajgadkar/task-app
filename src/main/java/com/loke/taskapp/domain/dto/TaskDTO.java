package com.loke.taskapp.domain.dto;

import com.loke.taskapp.domain.entity.TaskPriority;
import com.loke.taskapp.domain.entity.TaskStatus;

import java.time.LocalDate;
import java.util.UUID;

public record TaskDTO(
        UUID id,
        String title,
        String description,
        LocalDate dueDate,
        TaskPriority priority,
        TaskStatus status
) {
}
