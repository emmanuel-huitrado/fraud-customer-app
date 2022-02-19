package org.example.clients.notification;

import org.example.clients.notification.request.NotificationRequest;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient("notification")
public interface NotificationClient {
    void sendNotification(NotificationRequest notification);
}
