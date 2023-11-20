package com.company.service.impl;

import com.company.dao.entities.Status;
import com.company.dao.entities.Task;
import com.company.dao.repository.TaskRepository;
import com.company.dto.request.StatusRequest;
import com.company.dto.request.TaskRequest;
import com.company.dto.response.StatusRepository;
import com.company.dto.response.TaskRespons;
import com.company.exceptions.MyExceptionHandler;
import com.company.service.inter.TaskService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StatusServie {
    private final StatusRepository statusRepository;
    private final TaskRepository taskRepository;

    @Transactional
    public Status isDelete(Long taskId, StatusRequest statusRequest) {
        return taskRepository.findById(taskId)
                .map(task -> {
                    Status status = new Status();
                    status.setIsDeleted(statusRequest.getIsDeleted());
                    status.setTask(task);
                    return statusRepository.save(status);
                })
                .orElseThrow(() -> new MyExceptionHandler("Task not found with ID: " + taskId));
    }

}
