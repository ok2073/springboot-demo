package com.example.demo.customer;

import com.example.demo.exception.NotFoundException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j //Removes LOGGER definition
public class CustomerService {

    //private final static Logger LOGGER = LoggerFactory.getLogger(CustomerService.class);
    private final CustomerRepository customerRepository;

    //public CustomerService(@Qualifier("fake") CustomerRepo customerRepo) {
  /*  public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }*/

    public List<Customer> getCustomers() {
        log.info("getCustomers was called");
        return customerRepository.findAll();
    }

    public Customer getCustomer(Long id) {
        return customerRepository
                .findById(id)
                .orElseThrow(
                        () -> {
                            NotFoundException notFoundException = new NotFoundException(
                                                                "customer with id " + id + " not found");
                            log.error("error in getting customer {}", id, notFoundException);
                            return notFoundException;
                });
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
