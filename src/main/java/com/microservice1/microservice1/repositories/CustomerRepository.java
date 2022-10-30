package com.microservice1.microservice1.repositories;

import com.microservice1.microservice1.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
