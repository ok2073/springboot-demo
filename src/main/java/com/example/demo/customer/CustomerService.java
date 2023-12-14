package com.example.demo.customer;

import org.springframework.stereotype.Component;

@Component
public class CustomerService {

    public Customer getCustomer() {
        return new Customer(1L, "James Bondddd");
    }
}
