package com.example.orders.service;

import com.example.orders.domain.Order;

import java.util.ArrayList;

public interface OrdersService {
    Order findById(Long id);
    ArrayList<Order> getOrders();
    void insert(Order order);
    void deleteById(Long id);
}
