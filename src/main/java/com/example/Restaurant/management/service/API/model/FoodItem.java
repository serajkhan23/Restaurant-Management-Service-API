package com.example.Restaurant.management.service.API.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@JsonIdentityInfo(generator= ObjectIdGenerators.PropertyGenerator.class,scope=Order.class,property="orderId")
public class FoodItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String title;
    private String description;
    private Integer price;
    @JsonProperty(access= JsonProperty.Access.READ_ONLY)
    private LocalDateTime orderScheduleTime;

    @OneToOne
    @JoinColumn(name = "fk_customer_id")
    Customer customer;

    @ManyToOne
    @JoinColumn(name = "fk_order_id")
    Order order;

}
