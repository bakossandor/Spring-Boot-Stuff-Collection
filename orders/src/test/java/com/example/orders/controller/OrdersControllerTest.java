package com.example.orders.controller;

import com.example.orders.domain.Order;
import com.example.orders.service.OrdersService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@ExtendWith(MockitoExtension.class)
class OrdersControllerTest {

    @Mock
    OrdersService ordersService;

    @InjectMocks
    OrdersController controller;

    MockMvc mockMvc;

    @BeforeEach
    public void setUp() throws Exception {
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    void getOrders() throws Exception {
        mockMvc.perform(get("/orders/"))
                .andExpect(status().isOk())
                .andExpect(view().name("orders"));
    }

    @Test
    void getOrder() throws Exception {
        Order order1 = new Order();
        order1.setId(1l);
        when(ordersService.findById(anyLong())).thenReturn(order1);
        mockMvc.perform(get("/orders/{id}", "1"))
                .andExpect(status().isOk())
                .andExpect(view().name("order"));
    }

    @Test
    void notFoundHandler() {
    }
}