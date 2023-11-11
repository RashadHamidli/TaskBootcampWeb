package com.company.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ResetPasswordController {

    @GetMapping("/reset-password.html")
    public String resetpassword() {
        return "reset-password";
    }
}
