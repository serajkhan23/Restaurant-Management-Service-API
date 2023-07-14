package com.example.Restaurant.management.service.API.service;

import com.example.Restaurant.management.service.API.model.AuthenticationToken;
import com.example.Restaurant.management.service.API.repository.IAuthTokenRepo;
import org.springframework.beans.factory.annotation.Autowired;

public class AuthenticationService {
    @Autowired
    IAuthTokenRepo authenticationTokenRepo;

    public boolean authenticate(String email, String authenticationTokenValue)
    {

        IAuthTokenRepo authTokenRepo;
        AuthenticationToken authToken = authenticationTokenRepo.findFirstByTokenValue(authenticationTokenValue);

        if(authToken == null)
        {
            return false;
        }

        String tokenConnectedEmail = authToken.getCustomer().getCustomerEmail();

        return tokenConnectedEmail.equals(email);
    }
}
