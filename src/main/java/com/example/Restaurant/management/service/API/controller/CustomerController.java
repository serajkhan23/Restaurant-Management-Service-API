package com.example.Restaurant.management.service.API.controller;


import com.example.Restaurant.management.service.API.model.Customer;
import com.example.Restaurant.management.service.API.model.dto.SignInInput;
import com.example.Restaurant.management.service.API.model.dto.SignUpOutput;
import com.example.Restaurant.management.service.API.service.AuthenticationService;
import com.example.Restaurant.management.service.API.service.CustomerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {
    @Autowired
    CustomerService customerService;
    @Autowired
    AuthenticationService authenticationService;

    @PostMapping("customer/signup")
    public SignUpOutput signUpCustomer(@RequestBody Customer customer)
    {

        return customerService.signUpCustomer(customer);
    }
    @PostMapping("customer")
    void addCustomer(@RequestBody Customer customer)
    {
        customerService.addCustomer(customer);
    }
    @PostMapping("customer/signIn")
    public String sigInCustomer(@RequestBody @Valid SignInInput signInInput)
    {
        return customerService.signInCustmer(signInInput);
    }

    @DeleteMapping("customer/signOut")
    public String sigOutCustomer(String email, String token)
    {
        if(authenticationService.authenticate(email,token)) {
            return customerService.sigOutCustomer(email);
        }
        else {
            return "Sign out not allowed for non authenticated user.";
        }

    }
    @GetMapping("customers")
    public List<Customer> getAllCustomers()
    {
        return customerService.getAllCustomers();
    }
    @DeleteMapping("customer/cancel")
    public String  cancelOrder(String email, String token)
    {

        if(authenticationService.authenticate(email,token)) {
            customerService.cancelOrder(email);
            return "canceled order successfully";
        }
        else
        {
            return "Ordered failed because invalid authentication";
        }
    }
}
