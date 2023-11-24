package com.company.service.impl;

import com.company.dao.entities.Status;
import com.company.dao.entities.Task;
import com.company.dao.repository.TaskRepository;
import com.company.dto.request.StatusRequest;
import com.company.dto.response.StatusRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StatusServiceImpl {
    private final StatusRepository statusRepository;
    private final TaskRepository taskRepository;

    @Transactional
    public Status addStatus(Long taskId, StatusRequest statusRequest) {
        Task task = new Task();
        task.setId(taskId);
        statusRepository.deleteByTaskId(taskId);

        Status status = new Status();
        status.setIsDeleted(statusRequest.getIsDeleted());
        status.setIsArchive(statusRequest.getIsArchive());
        status.setIsImportant(statusRequest.getIsImportant());
        status.setIsComplete(statusRequest.getIsComplete());
        status.setIsTasks(statusRequest.getIsTasks());

        status.setTask(task);
        return statusRepository.save(status);
    }

    public List<Status> getDeletedStatusesForTask(List<Long> taskId) {
        return statusRepository.findByTaskIdInAndIsDeleted(taskId, true);
    }
    public List<Status> getArchiveStatusesForTask(List<Long> taskId) {
        return statusRepository.findByTaskIdInAndIsArchive(taskId, true);
    }
    public List<Status> getCompleteStatusesForTask(List<Long> taskId) {
        return statusRepository.findByTaskIdInAndIsComplete(taskId, true);
    }
    public List<Status> getImportantStatusesForTask(List<Long> taskId) {
        return statusRepository.findByTaskIdInAndIsImportant(taskId, true);
    }

    public List<Status> getTasksStatusesForTask(List<Long> taskId) {
        return statusRepository.findByTaskIdInAndIsTasks(taskId, true);
    }
}
