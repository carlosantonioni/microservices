package com.ideas.notifications;

import com.ideas.clients.notifications.NotificationRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class NotificationServices {

    private final NotificationRepository notificationRepository;

    public void send(NotificationRequest notificationRequest){

        notificationRepository.save(
                Notifications.builder()
                        .toCustomerId(notificationRequest.toCustomerId())
                        .toCustomerEmail(notificationRequest.toCustomerName())
                        .sender("ideas")
                        .message(notificationRequest.message())
                        .sentAt(LocalDateTime.now())
                        .build()
        );

    }

}
