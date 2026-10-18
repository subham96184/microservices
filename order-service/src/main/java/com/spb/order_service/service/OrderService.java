package com.spb.order_service.service;

import com.spb.order_service.entity.Order;
import com.spb.order_service.event.OrderCreatedEvent;
import com.spb.order_service.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository repository;
    private final KafkaProducerService producer;

    public Order create(Order order) {

        order.setStatus("CREATED");

        Order savedOrder =
                repository.save(order);

        producer.publish(
                new OrderCreatedEvent(
                        savedOrder.getId(),
                        savedOrder.getProductId(),
                        savedOrder.getQuantity()
                )
        );

        return savedOrder;
    }
}