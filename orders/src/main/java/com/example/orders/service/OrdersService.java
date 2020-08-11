package com.example.orders.service;

import com.example.orders.domain.Order;

import java.util.Set;

public interface OrdersService {
    Order findById(Long id);
    Set<Order> getOrders();
    void insert(Order order);
    void deleteById(Long id);
}
