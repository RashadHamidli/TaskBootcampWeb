package com.company.controller;

import com.company.config.AuthenticationFacade;
import com.company.dto.request.TaskRequest;
import com.company.dto.response.JwtAuthenticationResponse;
import com.company.service.impl.JwtServiceImpl;
import com.company.service.impl.UserServiceImpl;
import com.company.service.inter.AuthenticationService;
import com.company.service.inter.TaskService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequiredArgsConstructor
@RequestMapping("/addtask")
public class TaskController {
    private final TaskService taskService;
    private final JwtServiceImpl jwtService;
    private final UserServiceImpl userService;
    private final AuthenticationFacade authenticationFacade;

    @GetMapping()
    public String task() {
        return "add-task";
    }

    @PostMapping
    public ModelAndView addTask(HttpSession session, TaskRequest request, Model model) {
        String token = (String) session.getAttribute("token");
        model.addAttribute("token", token);
        String email = jwtService.extractUserName(token);
        Long userId = userService.findByUserId(email);

        System.out.println("User ID: " + userId);
        System.out.println("Task Request: " + request.toString());

        taskService.createTaskForUser(userId, request);

        System.out.println("Task created successfully!");

        ModelAndView modelAndView = new ModelAndView("tasks-dashboard");
        System.out.println("ModelAndView URL: " + modelAndView.getViewName());

        return modelAndView;
    }
}
