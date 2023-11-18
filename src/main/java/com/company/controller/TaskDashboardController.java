package com.company.controller;

import com.company.dao.entities.Task;
import com.company.dao.entities.User;
import com.company.dao.repository.TaskRepository;
import com.company.dao.repository.UserRepository;
import com.company.dto.request.TaskRequest;
import com.company.dto.response.TaskRespons;
import com.company.dto.response.UserRespons;
import com.company.service.impl.UserServiceImpl;
import com.company.service.inter.JwtService;
import com.company.service.inter.TaskService;
import com.company.service.inter.UserService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.lang.NonNull;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class TaskDashboardController {
    private final JwtService service;
    private final TaskService taskService;
    private final UserServiceImpl userService;
    private static final Logger log = LoggerFactory.getLogger(TaskDashboardController.class);


    @GetMapping("/tasksdashboard")
    public String getTasks(HttpSession session, Model model) {
        String token = (String) session.getAttribute("token");
        String email = service.extractUserName(token);
        Long userId = userService.findByUserId(email);
        List<TaskRespons> tasks = taskService.getAllTasksById(userId);
        model.addAttribute("tasks", tasks);
        UserRespons userResp = (UserRespons) session.getAttribute("userRespons");
        model.addAttribute("userRespons", userResp);
        return "tasks-dashboard";
    }
}
