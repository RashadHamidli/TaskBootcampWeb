package com.company.dto.response;

import com.company.dao.entities.Status;
import com.company.dao.entities.Task;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class TaskRespons {
    private Long id;
    private String taskName;
    private Date deadline;
    private String taskText;
    private Long userId;

    public TaskRespons(Task task) {
        this.id = task.getId();
        this.taskName = task.getTaskName();
        this.deadline = task.getDedline();
        this.taskText = task.getTaskText();
        this.userId = task.getUser().getId();
    }
}
