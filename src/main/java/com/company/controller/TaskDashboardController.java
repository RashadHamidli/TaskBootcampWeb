package com.company.controller;

import com.company.dao.entities.User;
import com.company.dto.request.TaskRequest;
import com.company.service.inter.TaskService;
import com.company.service.inter.UserService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequiredArgsConstructor
public class TaskDashboardController {//anonymousUser
    private static final Logger log = LoggerFactory.getLogger(TaskDashboardController.class);

    @GetMapping("/tasksdashboard")
    public String taskdashboard() {
        return "tasks-dashboard";
    }

    @PostMapping("/tasksdashboard")
    public ModelAndView taskdashboard(TaskRequest request) {

        String loggedInUserEmail = SecurityContextHolder.getContext().getAuthentication().getName();
        System.out.println("Daxil olan istifadəçinin emaili: " + loggedInUserEmail);

        return new ModelAndView("/tasks-dashboard");
    }
}
