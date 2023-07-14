package com.example.Restaurant.management.service.API.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@JsonIdentityInfo(generator= ObjectIdGenerators.PropertyGenerator.class,scope=Customer.class,property="customerId")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long customerId;
    private String customerName;
    @Pattern(regexp = "^.+@(?![Rr][Ee][Ss][Tt][Aa][Uu][Rr][Aa][Nn][Tt][Aa][Dd][Mm][Ii][Nn]\\.[Cc][Oo][Mm]$).+$")
    @Column(unique = true)
    private String customerEmail;
    @NotBlank
    private String customerPassword;

    private Integer customerAge;
    private String customerAddress;



    @OneToOne(mappedBy = "customer")
    Order order;

}
