package com.loke.taskapp.mapper;

import com.loke.taskapp.domain.dto.CreateTaskRequestDTO;
import com.loke.taskapp.domain.dto.TaskDTO;
import com.loke.taskapp.domain.dto.UpdateTaskRequestDTO;
import com.loke.taskapp.domain.entity.Task;
import com.loke.taskapp.domain.requests.CreateTaskRequest;
import com.loke.taskapp.domain.requests.UpdateTaskRequest;

public interface TaskMapper {

    CreateTaskRequest fromDto(CreateTaskRequestDTO dto);

    UpdateTaskRequest fromDto(UpdateTaskRequestDTO dto);

    TaskDTO toDto(Task task);
}
