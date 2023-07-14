package com.example.Restaurant.management.service.API.repository;


import com.example.Restaurant.management.service.API.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IOrderRepo extends JpaRepository<Order,Long> {
}
