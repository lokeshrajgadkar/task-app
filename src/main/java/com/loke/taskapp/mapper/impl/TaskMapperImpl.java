package com.loke.taskapp.mapper.impl;

import com.loke.taskapp.domain.dto.CreateTaskRequestDTO;
import com.loke.taskapp.domain.dto.TaskDTO;
import com.loke.taskapp.domain.dto.UpdateTaskRequestDTO;
import com.loke.taskapp.domain.entity.Task;
import com.loke.taskapp.domain.requests.CreateTaskRequest;
import com.loke.taskapp.domain.requests.UpdateTaskRequest;
import com.loke.taskapp.mapper.TaskMapper;
import org.springframework.stereotype.Component;

@Component
public class TaskMapperImpl implements TaskMapper {
    @Override
    public CreateTaskRequest fromDto(CreateTaskRequestDTO dto) {
        return new CreateTaskRequest(dto.title(), dto.description(), dto.dueDate(), dto.priority());
    }

    @Override
    public UpdateTaskRequest fromDto(UpdateTaskRequestDTO dto) {
        return new UpdateTaskRequest(dto.title(),dto.description(),dto.dueDate(),dto.status(),dto.priority());
    }

    @Override
    public TaskDTO toDto(Task task) {
        return new TaskDTO(task.getId(), task.getTitle(), task.getDescription(), task.getDueDate(),
                task.getPriority(), task.getStatus());
    }
}
