package com.company.service.impl;

import com.company.dao.entities.Status;
import com.company.dao.repository.TaskRepository;
import com.company.dto.request.StatusRequest;
import com.company.dto.response.StatusRepository;
import com.company.exceptions.MyExceptionHandler;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StatusService {
    private final StatusRepository statusRepository;
    private final TaskRepository taskRepository;

    public List<Status> getAllStatusById() {
        return statusRepository.findAll();
    }

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

    public List<Status> getDeletedStatusesForTask(List<Long> taskId) {
        return statusRepository.findByTaskIdInAndIsDeleted(taskId, true);
    }
    public List<Status> getArchiveStatusesForTask(List<Long> taskId) {
        return statusRepository.findByTaskIdInAndIsArchive(taskId, true);
    }
}
