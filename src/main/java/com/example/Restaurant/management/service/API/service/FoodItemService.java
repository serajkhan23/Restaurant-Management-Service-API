package com.example.Restaurant.management.service.API.service;

import com.example.Restaurant.management.service.API.model.FoodItem;
import com.example.Restaurant.management.service.API.repository.IFoodItemRepo;
import org.antlr.v4.runtime.misc.LogManager;
import org.antlr.v4.runtime.tree.pattern.ParseTreePattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodItemService {


    @Autowired
    IFoodItemRepo foodItemRepo;

      List<FoodItem> getAllFoodItems()
    {
        return foodItemRepo.findAll();
    }

    public void addFodItem(FoodItem fooditem) {

    }
}
