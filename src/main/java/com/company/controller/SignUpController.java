package com.company.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SignUpController {

    @GetMapping("/signup.html")
    public String signup() {
        return "sign-up";
    }
}
