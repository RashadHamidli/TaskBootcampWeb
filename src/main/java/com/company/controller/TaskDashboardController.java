package com.company.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/tasksdashboard")
public class TaskDashboardController {

    @GetMapping()
    public String taskdashboard() {
        return "tasks-dashboard";
    }
}