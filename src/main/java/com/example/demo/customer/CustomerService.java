package com.example.demo.customer;

import com.example.demo.exception.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    //public CustomerService(@Qualifier("fake") CustomerRepo customerRepo) {
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Customer> getCustomers() {
        return customerRepository.findAll();
    }

    public Customer getCustomer(Long id) {
        return customerRepository
                .findById(id)
                .orElseThrow(
                        () -> new NotFoundException(
                                "customer with id " + id +  " not found"));
    }

    /*public Customer getCustomer(Long id) {
        return getCustomers()
                .stream()
                .filter(customer -> customer.getId().equals(id))
                .findFirst()
                .orElseThrow(
                        () -> new NotFoundException(
                                "customer with id " + id +  " not found"));
    }*/
}
