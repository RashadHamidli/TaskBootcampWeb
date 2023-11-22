package com.company.service.inter;

import com.company.dao.entities.User;
import org.springframework.mail.MailException;

public interface NotificationService {
    public void sendNotification(String email) throws MailException;
}
