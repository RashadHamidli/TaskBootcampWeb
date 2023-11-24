package com.company.controller;

import com.company.dto.request.SignUpRequest;
import com.company.dto.response.JwtAuthenticationResponse;
import com.company.service.inter.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequiredArgsConstructor
@RequestMapping("/signup")
public class SignUpController {

    @GetMapping()
    public String signup() {
        return "sign-up";
    }

    private final AuthenticationService authenticationService;

    @PostMapping()
    public ModelAndView signup(SignUpRequest request) {
        JwtAuthenticationResponse response = authenticationService.signup(request);
        if (response == null) {
            System.out.println("register cannot be successfully");
            return new ModelAndView("/sign-up");
        }
        return new ModelAndView("login");
    }
}
