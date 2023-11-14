package com.company.controller;


import com.company.dto.request.SignUpRequest;
import com.company.dto.request.SigninRequest;
import com.company.dto.response.JwtAuthenticationResponse;
import com.company.service.impl.JwtServiceImpl;
import com.company.service.inter.AuthenticationService;
import com.company.service.inter.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

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
    public ModelAndView login(SigninRequest request) {
        JwtAuthenticationResponse response = authenticationService.signin(request);
        if (response == null) {
            System.out.println("register cannot be successfully");
            return new ModelAndView("login");
        }
        ModelAndView modelAndView = new ModelAndView("tasks-dashboard");
        modelAndView.addObject("token", response.getToken()); // Add token to the model
        return modelAndView;
    }
}
