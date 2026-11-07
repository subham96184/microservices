package com.spb.inventory_service.consumer;

import com.spb.inventory_service.event.OrderCreatedEvent;
import com.spb.inventory_service.service.InventoryService;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class InventoryConsumer {
    private final InventoryService inventoryService;

    public InventoryConsumer(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }

    @KafkaListener(
            topics = "order-created",
            groupId = "inventory-group-v2"
    )
    public void consume(OrderCreatedEvent event) {

        System.out.println(
                "Received Event : " + event
        );

        inventoryService.updateInventory(event);
    }
}