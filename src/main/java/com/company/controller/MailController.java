package com.company.controller;

import com.company.model.dao.entities.User;
import com.company.service.inter.NotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.MailException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
@RequiredArgsConstructor
public class MailController {

    private final NotificationService notificationService;

    @GetMapping("/send")
    public String sendMail(Model model) {
        User user = new User();
        user.setFirstName("Rashad");
        user.setEmail("rashad.j13@email.com");

        try {
//            notificationService.sendNotification(user);
            model.addAttribute("message", "E-posta başarıyla gönderildi.");
        } catch (MailException e) {
            e.printStackTrace();
            model.addAttribute("message", "E-posta gönderme sırasında bir sorun oluştu.");
        }

        return "mail-result";
    }
}
