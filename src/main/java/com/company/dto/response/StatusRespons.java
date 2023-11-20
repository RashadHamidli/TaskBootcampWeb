package com.company.dto.response;

import com.company.dao.entities.Status;

public class StatusRespons {
    private Long id;
    private Boolean isTasks;
    private Boolean isDeleted;
    private Boolean isArchive;
    private Boolean isImportant;
    private Boolean isComplete;
    private Long taskId;

    public StatusRespons(Status status) {
        this.id = status.getId();
        this.isTasks = status.getIsTasks();
        this.isArchive = status.getIsArchive();
        this.isDeleted = status.getIsDeleted();
        this.isImportant = status.getIsImportant();
        this.isComplete = status.getIsComplete();
    }
}
