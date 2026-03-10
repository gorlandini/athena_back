package com.core.domain.notification.app;

import com.core.domain.notification.model.Notification;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class NotificationService {

    private List<Notification> notifications = Collections.synchronizedList(new ArrayList<>());

    public void addNotification(String message) {
        notifications.add(new Notification(message));
    }

    public List<Notification> getNotifications() {
        return notifications;
    }
}