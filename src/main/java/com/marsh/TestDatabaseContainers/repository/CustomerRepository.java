package com.marsh.TestDatabaseContainers.repository;

import com.marsh.TestDatabaseContainers.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
