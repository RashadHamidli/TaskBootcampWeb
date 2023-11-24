package com.company.controller;


import com.company.dto.response.UserRespons;
import com.company.service.inter.JwtService;
import com.company.service.inter.UserService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/landing")
//@PreAuthorize("hasRole('USER')")
public class LandingController {

    @GetMapping()
    public String landing(HttpSession session, Model model) {
        UserRespons userResp = (UserRespons) session.getAttribute("userRespons");
        model.addAttribute("userResp", userResp);

        SecurityContextHolder.getContext().getAuthentication().getAuthorities().forEach(authority -> {
            System.out.println("User has role 2: " + authority.getAuthority());
        });

        return "landing";
    }

}
