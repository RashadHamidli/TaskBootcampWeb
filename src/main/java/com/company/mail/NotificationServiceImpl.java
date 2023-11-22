package com.company.mail;

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
    public void sendNotification(UserMail userMail) throws MailException {
        SimpleMailMessage mail = new SimpleMailMessage();
        mail.setTo(userMail.getEmailAddress());
        mail.setFrom("");
        mail.setSubject("Test Mail");
        mail.setText("Hi " + userMail.getName() + " email sent");
        javaMailSender.send(mail);
    }
}
