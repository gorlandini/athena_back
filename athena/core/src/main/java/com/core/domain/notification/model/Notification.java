package com.core.domain.notification.model;



import java.time.LocalDateTime;

public class Notification {

    private final String message;
    private final LocalDateTime createdAt;

    public Notification(String message) {
        this.message = message;
        this.createdAt = LocalDateTime.now();
    }

    public String getMessage() {
        return message;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

}