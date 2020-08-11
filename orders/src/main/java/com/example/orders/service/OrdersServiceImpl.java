package com.example.orders.service;

import com.example.orders.domain.Order;
import com.example.orders.exceptions.NotFoundException;
import com.example.orders.repository.OrdersRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

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
    public ArrayList<Order> getOrders() {
        ArrayList<Order> resultSet = new ArrayList<>();
        ordersRepository.findAll().iterator().forEachRemaining(resultSet::add);
        return resultSet;
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
