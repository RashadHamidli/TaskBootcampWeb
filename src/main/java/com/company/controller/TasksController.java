package com.company.controller;

import com.company.model.dao.entities.Status;
import com.company.model.dto.response.TaskRespons;
import com.company.model.dto.response.UserRespons;
import com.company.service.impl.StatusServiceImpl;
import com.company.service.impl.UserServiceImpl;
import com.company.service.inter.JwtService;
import com.company.service.inter.TaskService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequiredArgsConstructor
public class TasksController {
    private final JwtService service;
    private final TaskService taskService;
    private final UserServiceImpl userService;
    private final StatusServiceImpl statusServiceImpl;
    private static final Logger log = LoggerFactory.getLogger(TasksController.class);


    @GetMapping("/tasks")
    public String getTasks(HttpSession session, Model model) {
        String token = (String) session.getAttribute("token");
        String email = service.extractUserName(token);
        Long userId = userService.findByUserId(email);

        List<TaskRespons> userTasks = taskService.getAllTasksById(userId);
        List<Long> userTaskIds = userTasks.stream().map(TaskRespons::getId).collect(Collectors.toList());

        List<Status> statuses = statusServiceImpl.getTasksStatusesForTask(userTaskIds);

        model.addAttribute("statuses", statuses);

        UserRespons userResp = (UserRespons) session.getAttribute("userRespons");
        model.addAttribute("userRespons", userResp);
        model.addAttribute("status", "All Tasks");
        return "tasks-statuses";
    }
}
