package com.company.controller;

import com.company.dto.request.UserRequest;
import com.company.dto.response.UserRespons;
import com.company.service.inter.NotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/resetpassword")
public class RestPasswordController {
    private final NotificationService notificationService;

    @GetMapping
    public String getResetPassword() {
        return "reset-password";
    }

    @PostMapping
    public String postResetPassword(UserRequest userRequest) {
        String email = userRequest.getEmail();
        notificationService.sendNotificationPassword(email);
        return "/login";
    }


}
