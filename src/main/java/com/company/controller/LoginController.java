package com.company.controller;


import com.company.dto.request.SignUpRequest;
import com.company.dto.request.SigninRequest;
import com.company.dto.response.JwtAuthenticationResponse;
import com.company.service.impl.JwtServiceImpl;
import com.company.service.inter.AuthenticationService;
import com.company.service.inter.JwtService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/login")
public class LoginController {
    private final AuthenticationService authenticationService;
    private final JwtServiceImpl jwtService;

    @GetMapping
    public String login() {
        return "login";
    }

    @PostMapping()
    public String login(SigninRequest request, HttpSession session, Model model) {
        JwtAuthenticationResponse response = authenticationService.signin(request);
        session.setAttribute("token", response.getToken());
        model.addAttribute("token", response.getToken());
        return "/landing";
    }

}
