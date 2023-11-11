package com.company.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TaskArchiveController {
    @GetMapping("/task-archive.html")
    public String taskarchive() {
        return "task-archive";
    }
}

