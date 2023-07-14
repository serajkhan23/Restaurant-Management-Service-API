package com.example.Restaurant.management.service.API.service;

import com.example.Restaurant.management.service.API.model.AuthenticationToken;
import com.example.Restaurant.management.service.API.model.Customer;
import com.example.Restaurant.management.service.API.model.Order;
import com.example.Restaurant.management.service.API.model.dto.SignInInput;
import com.example.Restaurant.management.service.API.model.dto.SignUpOutput;
import com.example.Restaurant.management.service.API.repository.IAuthTokenRepo;
import com.example.Restaurant.management.service.API.repository.ICustomerRepo;
import com.example.Restaurant.management.service.API.service.emailUtility.EmailHandler;
import com.example.Restaurant.management.service.API.service.hashingUtility.PasswordEncrypter;
import org.antlr.v4.runtime.TokenStreamRewriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Service
public class CustomerService {
    @Autowired
    ICustomerRepo customerRepo;
    @Autowired
    IAuthTokenRepo authTokenRepo;

    @Autowired
    OrderService orderService;

    public SignUpOutput signUpCustomer(Customer customer) {
        boolean signUpStatus = true;
        String signUpStatusMessage = null;

        String newEmail = customer.getCustomerEmail();

        if(newEmail == null)
        {
            signUpStatusMessage = "Invalid email";
            signUpStatus = false;
            return new SignUpOutput(signUpStatus,signUpStatusMessage);
        }

        //check if this patient email already exists ??
        Customer existingCustomer = customerRepo.findFirstByCustomerEmail(newEmail);

        if(existingCustomer != null)
        {
            signUpStatusMessage = "Email already registered!!!";
            signUpStatus = false;
            return new SignUpOutput(signUpStatus,signUpStatusMessage);
        }

        //hash the password: encrypt the password
        try {
            String encryptedPassword = PasswordEncrypter.encryptPassword(customer.getCustomerPassword());

            //saveAppointment the patient with the new encrypted password

            customer.setCustomerPassword(encryptedPassword);
            customerRepo.save(customer);

            return new SignUpOutput(signUpStatus, "Customer registered successfully!!!");
        }
        catch(Exception e)
        {
            signUpStatusMessage = "Internal error occurred during sign up";
            signUpStatus = false;
            return new SignUpOutput(signUpStatus,signUpStatusMessage);
        }
    }


    @GetMapping("customers")
    public List<Customer> getAllCustomers() {
        List<Customer> all = customerRepo.findAll();
        return all;

    }

    public void addCustomer(Customer customer) {
    }

    public void cancelOrder(String email) {
        Customer customer = customerRepo.findFirstByCustomerEmail(email);



        Order order =orderService.getOrderForCustomer(customer);

        orderService.cancelOrder(order);


    }


    public String signInCustomer(SignInInput signInInput) {
        String signInStatusMessage = null;

        String signInEmail = signInInput.getEmail();

        if(signInEmail == null)
        {
            signInStatusMessage = "Invalid email";
            return signInStatusMessage;


        }

        //check if this customer email already exists ??
        Customer existingCustomer = customerRepo.findFirstByCustomerEmail(signInEmail);

        if(existingCustomer == null)
        {
            signInStatusMessage = "Email not registered!!!";
            return signInStatusMessage;

        }

        //match passwords :

        //hash the password: encrypt the password
        try {
            String encryptedPassword = PasswordEncrypter.encryptPassword(signInInput.getPassword());
            if(existingCustomer.getCustomerPassword().equals(encryptedPassword))
            {
                //session should be created since password matched and user id is valid
                AuthenticationToken authToken  = new AuthenticationToken(existingCustomer);
                authTokenRepo.save(authToken);

                EmailHandler.sendEmail(signInEmail,"email testing",authToken.getTokenValue());
                return "Token sent to your email";
            }
            else {
                signInStatusMessage = "Invalid credentials!!!";
                return signInStatusMessage;
            }
        }
        catch(Exception e)
        {
            signInStatusMessage = "Internal error occurred during sign in";
            return signInStatusMessage;
        }

    }



}

    public String sigOutCustomer(String email) {
        Customer customer = customerRepo.findFirstByCustomerEmail(email);
        IAuthTokenRepo authTokenRepo;
        authTokenRepo.delete(authTokenRepo.findFirstByCustomer(customer));
        return "Customer Signed out successfully";
    }

}
