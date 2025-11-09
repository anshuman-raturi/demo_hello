package com.cg.film.controller;

import com.cg.film.model.CustomerDTO;
import com.cg.film.model.CustomerPaymentGroupDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Controller
public class CustomerViewController {

	@Value("${app.backend.url}")
    private String backendUrl;
	
    @Autowired
    private RestTemplate restTemplate;
    
    @GetMapping("/customers")
    public String getCustomers(Model model) {
        String url = backendUrl+"/api/customers";
        CustomerDTO[] customerArray = restTemplate.getForObject(url, CustomerDTO[].class);
        List<CustomerDTO> customers = customerArray != null ? Arrays.asList(customerArray) : List.of();
        model.addAttribute("customers", customers);
        return "customers";
    }

    @GetMapping("/customer/payments")
    public String getCustomerPayments(@RequestParam String firstName,
                                      @RequestParam String lastName,
                                      Model model) {

        String url = backendUrl+"/api/customers/payments/grouped-by-name?firstName="
                + firstName + "&lastName=" + lastName;

        CustomerPaymentGroupDTO[] response = restTemplate.getForObject(url, CustomerPaymentGroupDTO[].class);

        if (response != null && response.length > 0) {
            model.addAttribute("customer", response[0]);
            model.addAttribute("payments", response[0].getPayments());
        } else {
            model.addAttribute("customer", new CustomerPaymentGroupDTO(firstName, lastName, List.of()));
            model.addAttribute("payments", List.of());
        }

        return "payments";
    }
}
