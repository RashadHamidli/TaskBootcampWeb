package com.company.controller;


import com.company.dto.response.UserRespons;
import com.company.service.inter.JwtService;
import com.company.service.inter.UserService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/landing")
public class LandingController {
    private final JwtService jwtService;
    private final UserService userService;

    @GetMapping()
    public String landing(HttpSession session, Model model) {
        String token = (String) session.getAttribute("token");
        System.out.println(token);
        String email = jwtService.extractUserName(token);
        System.out.println(email);
        UserRespons userRespons = userService.userNameAndSurname(email);
        System.out.println(userRespons);
        model.addAttribute("userRespons", userRespons);
        return "landing";
    }

}
