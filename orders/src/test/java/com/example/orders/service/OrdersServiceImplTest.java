package com.example.orders.service;

import com.example.orders.domain.Order;
import com.example.orders.repository.OrdersRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class OrdersServiceImplTest {

    @Mock
    OrdersRepository ordersRepository;

    @InjectMocks
    OrdersServiceImpl ordersService;

    @Test
    void findById() {
        Long id = 1L;
        Order order = new Order();
        order.setId(id);
        Optional<Order> result = Optional.of(order);
        when(ordersRepository.findById(id)).thenReturn(result);
        Order findThisOne = ordersService.findById(id);
        assertEquals(findThisOne.getId(), id);
    }

    @Test
    void getOrders() {
        Long id = 1L;
        Order order = new Order();
        order.setId(id);
        ArrayList<Order> result = new ArrayList<>();
        result.add(order);
        when(ordersRepository.findAll()).thenReturn(result);
        ArrayList<Order> orders = ordersService.getOrders();
        assertEquals(orders.size(), result.size());
        assertEquals(orders.get(0).getId(), id);
    }

    @Test
    void insert() {
    }

    @Test
    void deleteById() {
    }
}