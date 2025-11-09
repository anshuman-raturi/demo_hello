package com.cg.films.repository;
 
import org.springframework.data.jpa.repository.JpaRepository;
import com.cg.films.entity.Customer;
 
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}