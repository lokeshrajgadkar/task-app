package com.loke.taskapp.mapper;

import com.loke.taskapp.domain.dto.CreateTaskRequestDTO;
import com.loke.taskapp.domain.dto.TaskDTO;
import com.loke.taskapp.domain.entity.Task;
import com.loke.taskapp.domain.requests.CreateTaskRequest;

public interface TaskMapper {

    CreateTaskRequest fromDto(CreateTaskRequestDTO dto);

    TaskDTO toDto(Task task);
}
