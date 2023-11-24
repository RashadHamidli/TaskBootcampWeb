package com.company.controller;


import com.company.dto.request.SigninRequest;
import com.company.dto.response.JwtAuthenticationResponse;
import com.company.dto.response.UserRespons;
import com.company.service.impl.JwtServiceImpl;
import com.company.service.inter.AuthenticationService;
import com.company.service.inter.UserService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/login")
public class LoginController {
    private final AuthenticationService authenticationService;
    private final JwtServiceImpl jwtService;
    private final UserService userService;

    @GetMapping
    public String login() {
        return "login";
    }

    @PostMapping()
    public String login(SigninRequest request, HttpSession session, Model model) {
        JwtAuthenticationResponse response = authenticationService.signin(request);
        if (response != null && response.getToken() != null) {
            session.setAttribute("token", response.getToken());
            model.addAttribute("token", response.getToken());
            String email = jwtService.extractUserName(response.getToken());
            UserRespons userRespons = userService.userNameAndSurname(email);
            session.setAttribute("userRespons", userRespons);

            SecurityContext context = SecurityContextHolder.getContext();
            System.out.println(context);

            SecurityContextHolder.getContext().getAuthentication().getAuthorities().forEach(authority -> {
                System.out.println("User has role: " + authority.getAuthority());
            });

            return "redirect:/landing";
        } else {
            return "redircet:/login";
        }
    }

}
