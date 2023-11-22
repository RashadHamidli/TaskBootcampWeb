package com.company.mail;

import lombok.RequiredArgsConstructor;
import org.slf4j.LoggerFactory;
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
        UserMail user = new UserMail();
        user.setName("Rashad");
        user.setEmailAddress("rashad.j13@email.com");

        try {
            notificationService.sendNotification(user);
            model.addAttribute("message", "E-posta başarıyla gönderildi.");
        } catch (MailException e) {
            e.printStackTrace();
            model.addAttribute("message", "E-posta gönderme sırasında bir sorun oluştu.");
        }

        return "mail-result";
    }
}
