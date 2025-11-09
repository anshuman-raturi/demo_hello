package com.cg.films.service;
 
import com.cg.films.dto.CustomerNameDTO;
import com.cg.films.dto.CustomerPaymentGroupDTO;
import com.cg.films.dto.PaymentDetailDTO;
import com.cg.films.entity.Customer;
import com.cg.films.entity.Payment;
import com.cg.films.exception.PaymentDetailsNotFoundException;
import com.cg.films.repository.CustomerRepository;
import com.cg.films.repository.PaymentRepository;
import com.cg.films.service.impl.CustomerServiceImpl;
 
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
 
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.math.BigDecimal;
import java.util.List;
 
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
 
class CustomerServiceImplTest {
 
    @Mock
    private CustomerRepository customerRepository;
 
    @Mock
    private PaymentRepository paymentRepository;
 
    @InjectMocks
    private CustomerServiceImpl customerService;
 
    public CustomerServiceImplTest() {
        MockitoAnnotations.openMocks(this);
    }
 
    @Test
    void testGetAllCustomerNames() {
        Customer customer = new Customer();
        customer.setFirstName("Alice");
        customer.setLastName("Wonderland");
 
        when(customerRepository.findAll()).thenReturn(List.of(customer));
 
        List<CustomerNameDTO> result = customerService.getAllCustomerNames();
 
        assertEquals(1, result.size());
        assertEquals("Alice", result.get(0).getFirstName());
        assertEquals("Wonderland", result.get(0).getLastName());
    }
 
    @Test
    void testGetGroupedPaymentsByCustomerName_validCustomer() {
        Customer customer = new Customer();
        customer.setFirstName("Bob");
        customer.setLastName("Builder");
 
        Timestamp timestamp = Timestamp.valueOf(LocalDateTime.of(2023, 10, 10, 0, 0));
 
        Payment payment = new Payment();
        payment.setPaymentId(101L);
        payment.setAmount(BigDecimal.valueOf(150.0));
        payment.setPaymentDate(timestamp);
        payment.setCustomer(customer);
 
        when(paymentRepository.findByCustomerFirstNameAndCustomerLastName("Bob", "Builder"))
                .thenReturn(List.of(payment));
 
        List<CustomerPaymentGroupDTO> result = customerService.getGroupedPaymentsByCustomerName("Bob", "Builder");
 
        assertEquals(1, result.size());
        CustomerPaymentGroupDTO group = result.get(0);
        assertEquals("Bob", group.getFirstName());
        assertEquals("Builder", group.getLastName());
        assertEquals(1, group.getPayments().size());
 
        PaymentDetailDTO detail = group.getPayments().get(0);
        assertEquals(101L, detail.getPaymentId());
        assertEquals(BigDecimal.valueOf(150.0), detail.getAmount());
        assertEquals(timestamp, detail.getPaymentDate());
    }
 
    @Test
    void testGetGroupedPaymentsByCustomerName_invalidCustomer() {
        when(paymentRepository.findByCustomerFirstNameAndCustomerLastName("Ghost", "User"))
                .thenReturn(List.of());
 
        PaymentDetailsNotFoundException exception = assertThrows(PaymentDetailsNotFoundException.class, () -> {
            customerService.getGroupedPaymentsByCustomerName("Ghost", "User");
        });
 
        assertEquals("No payment details found for customer: Ghost User", exception.getMessage());
    }
}
 
 