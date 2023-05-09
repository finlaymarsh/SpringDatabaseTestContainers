package com.marsh.TestDatabaseContainers.repository;

import com.marsh.TestDatabaseContainers.database.MySqlTestContainer;
import com.marsh.TestDatabaseContainers.model.Customer;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@Testcontainers
@DataJpaTest
public class CustomerRepositoryIT {
    @Autowired
    private CustomerRepository customerRepository;

    @Container
    public static MySqlTestContainer mySqlContainer = MySqlTestContainer.getInstance();

    @Test
    public void getUserByIdTest(){
        Customer customer = addUser();
        assertEquals(customer, customerRepository.findById(customer.getId()).get());
    }

    @Test
    public void getUserByIdTest2(){
        addUser();
        addUser();
        addUser();
        List<Customer> customers = customerRepository.findAll();
        assertTrue(customers.size() >= 3);
    }

    private Customer addUser() {
        Customer customer = new Customer();
        customer.setFirstName("Finlay");
        customer.setLastName("Marsh");
        return customerRepository.save(customer);
    }
}
