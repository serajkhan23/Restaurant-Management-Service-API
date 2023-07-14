package com.example.Restaurant.management.service.API.controller;

import com.example.Restaurant.management.service.API.model.Customer;
import com.example.Restaurant.management.service.API.model.Order;
import com.example.Restaurant.management.service.API.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrderController {
    @Autowired
    OrderService orderService;
    @GetMapping("orders")
    public List<Order> getAllOrders()
    {

        return orderService.getAllOrders();
    }

}
