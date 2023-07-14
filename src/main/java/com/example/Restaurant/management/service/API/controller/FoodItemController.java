package com.example.Restaurant.management.service.API.controller;

import com.example.Restaurant.management.service.API.model.FoodItem;
import com.example.Restaurant.management.service.API.service.FoodItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FoodItemController {
    @Autowired
    FoodItemService foodItemService;
    @PostMapping("fooditem")
    void showFoodItem(@RequestBody FoodItem fooditem)
    {
        foodItemService.addFodItem(fooditem);
    }
    @GetMapping("foodItems")
    public List<FoodItem> getAllFoodItems()
        {
            return FoodItemService.getAllFoodItems;
        }


}
