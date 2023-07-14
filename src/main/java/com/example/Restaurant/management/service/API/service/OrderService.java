package com.example.Restaurant.management.service.API.service;

import com.example.Restaurant.management.service.API.model.Customer;
import com.example.Restaurant.management.service.API.model.Order;
import com.example.Restaurant.management.service.API.repository.IOrderRepo;
import org.antlr.v4.runtime.tree.pattern.ParseTreePattern;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class OrderService {
    @Autowired
    IOrderRepo iorderRepo;
    public List<Order> getAllOrders()
    {
        return orderRepo.findAll();

    }

    public Order getOrderForCustomer(Customer customer) {

    }

    public void cancelOrder(Order order) {
        return "cancel Order";
    }
}
