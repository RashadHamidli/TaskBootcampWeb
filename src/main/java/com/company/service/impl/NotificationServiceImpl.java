package com.company.service.impl;

import com.company.dao.entities.User;
import com.company.service.inter.NotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NotificationServiceImpl implements NotificationService {
    private final JavaMailSender javaMailSender;

    @Override
    public void sendNotification(String email) throws MailException {
        SimpleMailMessage mail = new SimpleMailMessage();
        mail.setTo(email);
        mail.setFrom("mail_rashad@mail.ru");
        mail.setSubject("New task");
        mail.setText("Hi " + email + " new task added in your page");
        javaMailSender.send(mail);
    }
}
