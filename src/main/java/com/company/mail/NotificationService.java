package com.company.mail;

import org.springframework.mail.MailException;

public interface NotificationService {
    public void sendNotification(UserMail userMail) throws MailException;
}
