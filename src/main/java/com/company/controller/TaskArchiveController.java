package com.company.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TaskArchiveController {
    @GetMapping("/tasks-archive.html")
    public String taskarchive() {
        return "tasks-archive";
    }
}

