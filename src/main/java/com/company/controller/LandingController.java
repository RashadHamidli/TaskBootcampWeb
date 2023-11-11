package com.company.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/landing")
public class LandingController {

    @GetMapping()
    public String landing() {
        return "landing";
    }
}
