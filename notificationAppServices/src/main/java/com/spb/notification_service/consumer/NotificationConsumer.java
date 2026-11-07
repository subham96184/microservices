package com.spb.notification_service.consumer;

import com.spb.notification_service.event.OrderCreatedEvent;
import com.spb.notification_service.service.NotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class NotificationConsumer {

    private final NotificationService notificationService;

    @KafkaListener(
            topics = "order-created",
            groupId = "notification-group"
    )
    public void consume(OrderCreatedEvent event) {

        System.out.println(
                "Notification Event Received : "
                        + event
        );

        notificationService
                .sendNotification(event);
    }
}