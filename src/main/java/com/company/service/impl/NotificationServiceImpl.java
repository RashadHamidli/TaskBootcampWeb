package com.company.service.impl;

import com.company.model.dto.response.UserRespons;
import com.company.service.inter.NotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NotificationServiceImpl implements NotificationService {
    private final JavaMailSender javaMailSender;

    @Override
    @Async
    public void sendNotification(String email, UserRespons userRespons) throws MailException {
        SimpleMailMessage mail = new SimpleMailMessage();
        mail.setTo(email);
        mail.setFrom("mail_rashad@mail.ru");
        mail.setSubject("New task");
        mail.setText("Hi " + userRespons.getName() + " " + userRespons.getSurname() + " new task added in your page");
        javaMailSender.send(mail);
    }
    @Override
    public void sendNotificationPassword(String email) throws MailException {
        SimpleMailMessage mail = new SimpleMailMessage();
        mail.setTo(email);
        mail.setFrom("mail_rashad@mail.ru");
        mail.setSubject("password change");
        mail.setText("Hi, change new password use this tp '123456'");
        javaMailSender.send(mail);
    }
}
