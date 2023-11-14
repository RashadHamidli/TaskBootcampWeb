package com.company.dto.request;

import com.company.dao.entities.Task;
import lombok.Data;

import java.sql.Date;


@Data
public class TaskRequest {
    private String taskName;
    private Date deadline;
    private String taskText;


    public Task taskRequestConverToTask(TaskRequest taskRequest) {
        Task task = new Task();
        task.setTaskName(taskRequest.taskName);
        task.setDedline(taskRequest.deadline);
        task.setTaskText(taskRequest.taskText);
        return task;
    }
}
