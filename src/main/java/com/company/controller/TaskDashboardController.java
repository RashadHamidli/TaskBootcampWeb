package com.company.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TaskDashboardController {

    @GetMapping("/tasks-dashboard.html")
    public String taskdashboard() {
        return "tasks-dashboard";
    }
}