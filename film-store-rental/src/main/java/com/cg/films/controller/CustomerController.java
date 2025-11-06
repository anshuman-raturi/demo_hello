package com.cg.films.controller;
 
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
 
import com.cg.films.dto.CustomerNameDTO;
import com.cg.films.dto.CustomerPaymentGroupDTO;
import com.cg.films.service.CustomerService;
 
@RestController
@RequestMapping("/api/customers")
@CrossOrigin(origins = "*")
public class CustomerController {
 
    @Autowired
    private CustomerService customerService;
 
    @GetMapping
    public List<CustomerNameDTO> getAllCustomerNames() {
        return customerService.getAllCustomerNames();
    }
 
    @GetMapping("/payments/grouped-by-name")
    public List<CustomerPaymentGroupDTO> getGroupedPayments(@RequestParam String firstName, @RequestParam String lastName) {
        return customerService.getGroupedPaymentsByCustomerName(firstName, lastName);
    }
}