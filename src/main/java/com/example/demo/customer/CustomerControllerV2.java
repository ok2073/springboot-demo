package com.example.demo.customer;

import com.example.demo.exception.ApiRequestException;
import com.example.demo.infoapp.InfoApp;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RequestMapping(path = "api/v2/customers")
@RestController
@AllArgsConstructor
public class CustomerControllerV2 {
    private final CustomerService customerService;
    private final InfoApp infoApp;

   /* @Autowired
    public CustomerControllerV2(CustomerService customerService, InfoApp infoApp) {
        this.customerService = customerService;
        this.infoApp = infoApp;
    }*/

    @GetMapping
    List<Customer> getCustomers() {
        System.out.println("InfoApp in CustomerControllerV2 " + infoApp);
        return customerService.getCustomers();
    }

    @GetMapping(path = "{customerId}")
    Customer getCustomer(@PathVariable("customerId") Long id) {
        return customerService.getCustomer(id);
    }

    @GetMapping(path = "{customerId}/exception")
    Customer getCustomerException(@PathVariable("customerId") Long id) {
        throw new ApiRequestException("ApiRequestException for customer " + id);
    }

    @PostMapping
    void createNewCustomer(@Valid @RequestBody Customer customer) {
        System.out.println("POST REQUEST...");
        System.out.println(customer);
    }

    @PutMapping
    void updateNewCustomer(@RequestBody Customer customer) {
        System.out.println("UPDATE REQUEST...");
        System.out.println(customer);
    }

    @DeleteMapping(path = "{customerId}")
    void deleteMapping(@PathVariable("customerId") Long id) {
        System.out.println("DELETE REQUEST FOR CUSTOMER WITH ID " + id);
    }
}
