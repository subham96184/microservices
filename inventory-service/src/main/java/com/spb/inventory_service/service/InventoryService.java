package com.spb.inventory_service.service;

import com.spb.inventory_service.entity.Inventory;
import com.spb.inventory_service.event.OrderCreatedEvent;
import com.spb.inventory_service.repository.InventoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
@Service
@RequiredArgsConstructor
public class InventoryService {

    private final InventoryRepository repository;

    public void updateInventory(
            OrderCreatedEvent event) {

        Inventory inventory =
                repository.findById(
                                event.getProductId())
                        .orElseThrow();

        inventory.setStock(
                inventory.getStock()
                        - event.getQuantity());

        repository.save(inventory);

        System.out.println(
                "Stock Updated Successfully");
    }
}