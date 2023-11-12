package com.company.controller;

import com.company.dao.entities.User;
import com.company.dto.request.TaskRequest;
import com.company.dto.response.TaskRespons;
import com.company.service.impl.UserServiceImpl;
import com.company.service.inter.TaskService;
import com.company.service.inter.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequiredArgsConstructor
@RequestMapping("/tasksdashboard")
public class TaskDashboardController {
    private final TaskService taskService;

    @GetMapping()
    public String taskdashboard() {
        return "tasks-dashboard";
    }

    @PostMapping
    public ModelAndView taskdashboard(TaskRequest request) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication != null && authentication.getPrincipal() instanceof User) {
            Long userId = ((User) authentication.getPrincipal()).getId();

            TaskRespons respons = taskService.createTaskForUser(userId, request);
            new ModelAndView("tasks-dashboard");
            if (respons == null) {
                System.out.println("task yaradılmadı");
            }
            return new ModelAndView("error-page");
        } else {
            System.out.println("authentication != null && authentication.getPrincipal() instanceof User methodu islemedi");
        }
        return null;
    }

}