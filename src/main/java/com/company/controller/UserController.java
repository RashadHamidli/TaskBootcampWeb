package com.company.controller;

import com.company.dto.request.TaskRequest;
import com.company.dto.request.UserRequest;
import com.company.dto.response.TaskRespons;
import com.company.dto.response.UserRespons;
import com.company.service.impl.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/todoapp/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<UserRespons>> getAllUsers() {
        List<UserRespons> allUser = userService.getAllUser();
        return ResponseEntity.ok(allUser);
    }

    @PutMapping("/update/{userId}")
    public ResponseEntity<UserRespons> updateUser(@PathVariable Long userId,
                                                  @RequestBody UserRequest userRequest) {
        UserRespons userRespons = userService.updateUser(userId, userRequest);
        return userRespons != null ? ResponseEntity.status(HttpStatus.OK).body(userRespons)
                : ResponseEntity.status(HttpStatus.CONFLICT).build();
    }

    @DeleteMapping("delete/{userId}")
    public ResponseEntity<String> deleteUser(@PathVariable Long userId) {
        boolean deleteUser = userService.deleteUser(userId);
        return deleteUser ? ResponseEntity.status(HttpStatus.OK).body("delete successfully")
                : ResponseEntity.status(HttpStatus.CONFLICT).body("user cannot deleted");
    }

    @GetMapping("/{userId}/tasks")
    public ResponseEntity<List<TaskRespons>> getUserTasks(@PathVariable Long userId) {
        List<TaskRespons> userTasks = userService.getUserTasks(userId);
        return ResponseEntity.ok(userTasks);
    }

    @PostMapping("/{userId}/{tasksid}")
    public ResponseEntity<TaskRespons> updateUserTaskByUserIdAndTaskId(@PathVariable Long userId,
                                                                       @PathVariable Long tasksid,
                                                                       @RequestBody TaskRequest taskRequest) {
        TaskRespons taskRespons = userService.updateUserTasks(userId, tasksid, taskRequest);
        return ResponseEntity.ok(taskRespons);
    }
}
