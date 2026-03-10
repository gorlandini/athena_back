package com.core.domain.notification.app;

import com.core.domain.notification.model.Notification;
import org.springframework.stereotype.Service;
import org.springframework.integration.annotation.ServiceActivator;

@Service

public class NotificationSubscriber {

    private final NotificationService notificationService;

    public NotificationSubscriber(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @ServiceActivator(inputChannel = "pubsubInputChannel")
    public void receive(String title) {

        Notification notification = new Notification(title);

        System.out.println("chegou mensagem: " + notification.getMessage());

        notificationService.addNotification(notification.getMessage());

    }
}
