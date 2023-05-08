package com.marsh.TestDatabaseContainers.controller;

import com.marsh.TestDatabaseContainers.model.Customer;
import com.marsh.TestDatabaseContainers.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;

    @GetMapping("customers")
    public ResponseEntity<List<Customer>> getCustomers(){
        return ResponseEntity.ok(customerRepository.findAll());
    }

    @GetMapping("customer/{id}")
    public ResponseEntity<?> getCustomerById(@PathVariable Long id){
        Optional<Customer> findByIdResult = customerRepository.findById(id);
        if (findByIdResult.isPresent()){
            return ResponseEntity.ok(findByIdResult.get());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("customer")
    public ResponseEntity<Customer> createCustomer(){
        Customer customer = new Customer();
        customer.setFirstName("test");
        customer.setLastName("test");
        customerRepository.save(customer);
        return new ResponseEntity<>(customer, HttpStatus.CREATED);
    }
}
