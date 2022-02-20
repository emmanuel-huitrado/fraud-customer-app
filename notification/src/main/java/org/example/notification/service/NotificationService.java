package org.example.notification.service;

import lombok.AllArgsConstructor;
import org.example.clients.notification.request.NotificationRequest;
import org.example.notification.model.Notification;
import org.example.notification.repository.NotificationRepository;

import org.springframework.stereotype.Service;
import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class NotificationService {
    private final NotificationRepository notificationRepository;

    public void saveNotification(NotificationRequest request){
        notificationRepository.save(Notification.builder().
                                    type(request.getType()).
                                    message(request.getMessage()).
                                    createdAt(LocalDateTime.now()).build());
    }
}
