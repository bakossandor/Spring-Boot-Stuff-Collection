package com.example.orders.controller;

import com.example.orders.exceptions.NotFoundException;
import com.example.orders.service.OrdersService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class OrdersController {
    OrdersService ordersService;

    public OrdersController(OrdersService ordersService) {
        this.ordersService = ordersService;
    }

    @RequestMapping("/orders/{id}")
    public String getOrder(@PathVariable String id, Model model) {
        model.addAttribute("order", ordersService.findById(Long.valueOf(id)));
        return "order";
    }

    @ExceptionHandler(NotFoundException.class)
    public ModelAndView notFoundHandler(Exception exception) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("404");
        modelAndView.addObject("exception", exception);
        return modelAndView;
    }
}
