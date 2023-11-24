package com.company.service.inter;

import com.company.dao.entities.User;
import com.company.dto.response.UserRespons;
import org.springframework.mail.MailException;

public interface NotificationService {
    public void sendNotification(String email, UserRespons userRespons) throws MailException;
    public void sendNotificationPassword(String email) throws MailException;
}
