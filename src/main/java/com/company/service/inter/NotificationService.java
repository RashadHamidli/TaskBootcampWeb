package com.company.service.inter;

import com.company.model.dto.response.UserRespons;
import org.springframework.mail.MailException;

public interface NotificationService {
    public void sendNotification(String email, UserRespons userRespons) throws MailException;
    public void sendNotificationPassword(String email) throws MailException;
}
