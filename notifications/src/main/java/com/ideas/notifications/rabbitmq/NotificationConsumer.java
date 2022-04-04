package com.ideas.notifications.rabbitmq;

import com.ideas.clients.notifications.NotificationRequest;
import com.ideas.notifications.NotificationServices;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
@Slf4j
public class NotificationConsumer {

    private final NotificationServices notificationServices;

    @RabbitListener(queues = "${rabbitmq.queue.notifications}")
    public void consumer(NotificationRequest notificationRequest) {
        log.info("Consumed {} from queue", notificationRequest);
        notificationServices.send(notificationRequest);
    }
}
