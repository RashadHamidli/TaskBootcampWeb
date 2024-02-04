package com.company.controller;

import com.company.model.dao.entities.User;
import com.company.service.inter.NotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequiredArgsConstructor
public class MailController {

    private final NotificationService notificationService;
    private final JavaMailSender mailSender;

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
    @PostMapping("/send-email")
    public String sendEmail(@RequestParam("email") String email) {
        // E-posta gönderme işlemi
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(email);
        message.setSubject("Şifre Sıfırlama Talebi");
        message.setText("Merhaba, şifrenizi sıfırlamak için aşağıdaki linke tıklayın: <link>");
        mailSender.send(message);

        // Başarılı gönderim sonrası kullanıcıyı yönlendirme
        return "redirect:/success.html";
    }
}
