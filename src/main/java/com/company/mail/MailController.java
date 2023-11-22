package com.company.mail;

import lombok.RequiredArgsConstructor;
import org.slf4j.LoggerFactory;
import org.springframework.mail.MailException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.logging.Logger;

@Controller
@RequiredArgsConstructor
public class MailController {

    private final NotificationService notificationService;

    @GetMapping("/send")
    public String sendMail() {
        UserMail user = new UserMail();
        user.setName("Rashad");
        user.setEmailAddress("mr_rashad@email.com");
        try {
            notificationService.sendNotification(user);
            return "mail gonderildi";
        } catch (MailException e) {
            e.printStackTrace();
        }
        return "problem bas verdi";
    }
}
