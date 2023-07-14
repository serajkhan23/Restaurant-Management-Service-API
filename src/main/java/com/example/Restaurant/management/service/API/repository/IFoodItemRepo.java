package com.example.Restaurant.management.service.API.repository;


import com.example.Restaurant.management.service.API.model.FoodItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IFoodItemRepo extends JpaRepository<FoodItem,Long> {
}
