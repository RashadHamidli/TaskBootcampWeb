package com.company.controller;

import com.company.model.dto.response.UserRespons;
import com.company.service.impl.JwtServiceImpl;
import com.company.service.impl.UserServiceImpl;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
@RequestMapping("/status")
public class TaskStatusController {
    private final JwtServiceImpl jwtService;
    private final UserServiceImpl userService;

    @GetMapping()
    public String task(HttpSession session, Model model) {
        UserRespons userResp = (UserRespons) session.getAttribute("userRespons");
        model.addAttribute("userRespons", userResp);
        String token = (String) session.getAttribute("token");
        String email = jwtService.extractUserName(token);
        Long userId = userService.findByUserId(email);
        model.addAttribute("userId", userId);
        return "redirect:/tasks";
    }


    @PostMapping()
    public String filterTasks(@RequestParam("task-type") String taskType) {
        switch (taskType) {
            case "tasks":
                return "redirect:/tasks";
            case "delete":
                return "redirect:/tasksdelete";
            case "important":
                return "redirect:/tasksimportant";
            case "Archive":
                return "redirect:/tasksarchive";
            case "Complete":
                return "redirect:/taskscomplete";
            default:
                return "redirect:/tasks";
        }
    }

}
