package com.example.Restaurant.management.service.API.repository;

import com.example.Restaurant.management.service.API.model.AuthenticationToken;
import com.example.Restaurant.management.service.API.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAuthTokenRepo extends JpaRepository<AuthenticationToken,Long> {

    AuthenticationToken findFirstByTokenValue(String authTokenValue);

    AuthenticationToken findFirstByCustomer(Customer customer);
}
