package com.company.controller.impl;

import com.company.controller.inter.TaskRestController;
import com.company.dto.request.TaskRequest;
import com.company.dto.response.TaskRespons;
import com.company.service.impl.TaskServiceImpl;
import com.company.service.inter.TaskService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todoapp/tasks")
public class TaskRestControllerImpl implements TaskRestController {
    private final TaskService taskService;

    public TaskRestControllerImpl(TaskServiceImpl taskService) {
        this.taskService = taskService;
    }

    @Override
    @GetMapping("/all")
    public ResponseEntity<List<TaskRespons>> getAllTasks() {
        List<TaskRespons> allTasks = taskService.getAllTasks();
        return ResponseEntity.ok(allTasks);
    }

    @Override
    @GetMapping("/{taskId}")
    public ResponseEntity<TaskRespons> getTaskByTaskId(@PathVariable Long taskId) {
        TaskRespons taskRespons = taskService.getTaskById(taskId);
        return ResponseEntity.ok(taskRespons);
    }

    @Override
    @PostMapping("/task")
    public ResponseEntity<TaskRespons> createTask(@RequestBody TaskRequest taskRequest) {
        TaskRespons taskRespons = taskService.createTask(taskRequest);
        return ResponseEntity.ok(taskRespons);
    }

    @Override
    @PostMapping("/user/{userId}")
    public ResponseEntity<TaskRespons> createTaskForUserId(@PathVariable Long userId,
                                                           @RequestBody TaskRequest taskRequest) {
        TaskRespons taskRespons = taskService.createTaskForUser(userId, taskRequest);
        return ResponseEntity.ok(taskRespons);
    }

    @Override
    @PutMapping("/{taskId}")
    public ResponseEntity<TaskRespons> updateTaskByTaskId(@PathVariable Long taskId,
                                                          @RequestBody TaskRequest taskRequest) {
        TaskRespons taskRespons = taskService.updateTaskByTaskId(taskId, taskRequest);
        return ResponseEntity.ok(taskRespons);
    }

    @Override
    @DeleteMapping("/{taskId}")
    public ResponseEntity<String> deleteTaskByTaskId(@PathVariable Long taskId) {
        boolean deletedTask = taskService.deleteTaskByTaskId(taskId);
        return deletedTask ? ResponseEntity.status(HttpStatus.OK).body("delete task successfully")
                : ResponseEntity.status(HttpStatus.BAD_REQUEST).body("task cannot be deleted");
    }

    @Override
    @DeleteMapping("/{userId}/{taskId}")
    public ResponseEntity<String> deleteTaskByUserIdAndTaskId(@PathVariable Long taskId,
                                                              @PathVariable Long userId) {
        boolean deletedTask = taskService.deleteTaskByUserIdAndTaskId(taskId, userId);
        return deletedTask ? ResponseEntity.status(HttpStatus.OK).body("delete task successfully")
                : ResponseEntity.status(HttpStatus.BAD_REQUEST).body("task cannot be deleted");
    }

}
