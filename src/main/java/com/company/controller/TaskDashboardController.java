package com.company.controller;

import com.company.dao.entities.User;
import com.company.dto.request.TaskRequest;
import com.company.service.impl.UserServiceImpl;
import com.company.service.inter.JwtService;
import com.company.service.inter.TaskService;
import com.company.service.inter.UserService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;

@Controller
@RequiredArgsConstructor
public class TaskDashboardController {//anonymousUser
    private final UserServiceImpl userServiceImpl;
    private final JwtService jwtService;
    private static final Logger log = LoggerFactory.getLogger(TaskDashboardController.class);

    @GetMapping("/tasksdashboard")
    public String taskdashboard() {
        return "tasks-dashboard";
    }

    @PostMapping("/tasksdashboard")
    public ModelAndView taskdashboard(TaskRequest request) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        System.out.println("authentication=" + authentication);
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        System.out.println(principal);
        String loggedInUserEmail = SecurityContextHolder.getContext().getAuthentication().getName();
        System.out.println("Daxil olan istifadəçinin emaili: " + loggedInUserEmail);

        return new ModelAndView("/tasks-dashboard");
    }
}
