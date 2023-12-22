package com.example.demo.customer;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.internal.matchers.Equals;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@DataJpaTest //Needed for CustomerRepository
class CustomerServiceTest {
    @Autowired
    private CustomerRepository customerRepository;
    private CustomerService underTest;

    @BeforeEach
    void setUp() {
        underTest = new CustomerService(customerRepository);
        customerRepository.deleteAll();
    }

    @AfterEach
    void tearDown() {
        customerRepository.deleteAll();
    }

    @Test
    void getCustomers() {
        Customer jamila = new Customer(1L, "jamila", "pwd123", "jamila@gmail.com");
        Customer ali = new Customer(2L, "ali", "pwd345", "ali@gmail.com");
        customerRepository.saveAll(Arrays.asList(jamila, ali));
        List<Customer> customers = underTest.getCustomers();
        assertEquals(2, customers.size());
    }

    @Test
    void getCustomer() {
        Customer jamila = new Customer(1L, "jamila", "pwd123", "jamila@gmail.com");
        customerRepository.save(jamila);
        Customer customer = underTest.getCustomer(1L);
        assertEquals(1L, customer.getId());
        assertEquals("jamila", customer.getName());
        assertEquals("pwd123", customer.getPassword());
        assertEquals("jamila@gmail.com", customer.getEmail());
    }
}