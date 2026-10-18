package com.spb.order_service.controller;

import com.spb.order_service.entity.Order;
import com.spb.order_service.repository.OrderRepository;
import com.spb.order_service.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    public Order createOrder(
            @RequestBody Order order) {

        return orderService.create(order);
    }
}