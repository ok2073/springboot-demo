package com.example.demo.customer;

import org.springframework.data.jpa.repository.JpaRepository;

//@Repository
//@Primary
public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
