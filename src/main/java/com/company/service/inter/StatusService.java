package com.company.service.inter;

import com.company.dao.entities.Status;
import com.company.dto.request.StatusRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StatusService {

    public Status addStatus(Long taskId, StatusRequest statusRequest);

    public List<Status> getDeletedStatusesForTask(List<Long> taskId);

    public List<Status> getArchiveStatusesForTask(List<Long> taskId);

    public List<Status> getCompleteStatusesForTask(List<Long> taskId);

    public List<Status> getImportantStatusesForTask(List<Long> taskId);

    public List<Status> getTasksStatusesForTask(List<Long> taskId);
}
