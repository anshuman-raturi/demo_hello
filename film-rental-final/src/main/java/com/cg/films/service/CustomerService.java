package com.cg.films.service;
 
import java.util.List;
import com.cg.films.dto.CustomerNameDTO;
import com.cg.films.dto.CustomerPaymentGroupDTO;
 
public interface CustomerService {
    List<CustomerNameDTO> getAllCustomerNames();
    List<CustomerPaymentGroupDTO> getGroupedPaymentsByCustomerName(String firstName, String lastName);
}