package com.example.Restaurant.management.service.API.repository;

import com.example.Restaurant.management.service.API.model.Customer;

import java.util.List;

public interface ICustomerRepo {
    void save(Customer customer);

    List<Customer> findAll();

    Customer findFirstByCustomerEmail(String email);
}
