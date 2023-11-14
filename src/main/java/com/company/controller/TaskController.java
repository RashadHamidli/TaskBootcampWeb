package com.company.controller;

import com.company.dto.request.TaskRequest;
import com.company.service.impl.UserServiceImpl;
import com.company.service.inter.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequiredArgsConstructor
@RequestMapping("/addtask")
public class TaskController {
    private final TaskService taskService;
    private final UserServiceImpl userService;

    @GetMapping()
    public String task() {
        return "add-task";
    }

    @PostMapping()
    public ModelAndView taskdashboard(TaskRequest request) {

        String loggedInUserEmail = SecurityContextHolder.getContext().getAuthentication().getName();
        System.out.println("loggedInUserEmail=" + loggedInUserEmail);
        Long userId = userService.findByUserId(loggedInUserEmail);
        taskService.createTaskForUser(userId, request);

        return new ModelAndView("/tasks-dashboard");
    }
}
