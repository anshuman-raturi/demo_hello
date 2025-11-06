package com.cg.films.repository;
 
import org.springframework.data.jpa.repository.JpaRepository;
import com.cg.films.entity.Payment;
import java.util.List;
 
public interface PaymentRepository extends JpaRepository<Payment, Short> {
    List<Payment> findByCustomerFirstNameAndCustomerLastName(String firstName, String lastName);
}