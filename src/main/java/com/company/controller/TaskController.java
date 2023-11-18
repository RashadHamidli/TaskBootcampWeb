package com.company.controller;

import com.company.config.AuthenticationFacade;
import com.company.dto.request.TaskRequest;
import com.company.dto.response.JwtAuthenticationResponse;
import com.company.dto.response.UserRespons;
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

    @GetMapping()
    public String task(HttpSession session, Model model) {
        UserRespons userResp = (UserRespons) session.getAttribute("userRespons");
        model.addAttribute("userRespons", userResp);
        String token = (String) session.getAttribute("token");
        String email = jwtService.extractUserName(token);
        Long userId = userService.findByUserId(email);
        model.addAttribute("userId", userId);
        return "add-task";
    }

    @PostMapping
    public String addTask(HttpSession session, TaskRequest request, Model model) {
        String token = (String) session.getAttribute("token");
        String email = jwtService.extractUserName(token);
        Long userId = userService.findByUserId(email);
        model.addAttribute("userId", userId);
        taskService.createTaskForUser(userId, request);
        return "redirect:/tasksdashboard";
    }

}
//    @PostMapping
//    public String addTask(HttpSession session, TaskRequest request, Model model) {
//        String token = (String) session.getAttribute("token");
//        model.addAttribute("token", token);
//        String email = jwtService.extractUserName(token);
//        Long userId = userService.findByUserId(email);
//        taskService.createTaskForUser(userId, request);
//        return "redirect:/tasksdashboard";
//    }