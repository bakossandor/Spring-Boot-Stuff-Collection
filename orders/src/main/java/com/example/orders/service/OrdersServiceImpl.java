package com.example.orders.service;

import com.example.orders.domain.Order;
import com.example.orders.exceptions.NotFoundException;
import com.example.orders.repository.OrdersRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
public class OrdersServiceImpl implements OrdersService {
    OrdersRepository ordersRepository;

    public OrdersServiceImpl(OrdersRepository ordersRepository) {
        this.ordersRepository = ordersRepository;
    }

    @Override
    public Order findById(Long id) {
        Optional<Order> optionalOrder = ordersRepository.findById(id);
        if (optionalOrder.isEmpty()) {
            throw new NotFoundException("Requested Order is not found");
        }
        return optionalOrder.get();
    }

    @Override
    public Set<Order> getOrders() {
        return (Set<Order>) ordersRepository.findAll();
    }

    @Override
    public void insert(Order order) {
        ordersRepository.save(order);
    }

    @Override
    public void deleteById(Long id) {
        ordersRepository.deleteById(id);
    }
}
