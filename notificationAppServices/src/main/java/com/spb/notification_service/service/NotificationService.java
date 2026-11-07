package com.spb.notification_service.service;
import com.spb.notification_service.event.OrderCreatedEvent;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {

    public void sendNotification(
            OrderCreatedEvent event) {

        System.out.println(
                "=================================="
        );

        System.out.println(
                "EMAIL SENT FOR ORDER : "
                        + event.getOrderId()
        );

        System.out.println(
                "PRODUCT ID : "
                        + event.getProductId()
        );

        System.out.println(
                "QUANTITY : "
                        + event.getQuantity()
        );

        System.out.println(
                "=================================="
        );
    }
}