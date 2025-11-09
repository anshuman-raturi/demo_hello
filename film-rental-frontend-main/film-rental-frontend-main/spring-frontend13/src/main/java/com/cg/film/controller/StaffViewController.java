package com.cg.film.controller;

import com.cg.film.model.AddressDTO;
import com.cg.film.model.StaffBasicDTO;
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
public class StaffViewController {

    @Autowired
    private RestTemplate restTemplate;
    
//    @Value("${app.backend.url}")
//    private String backendUrl;
//    
//    private final String baseUrl =backendUrl;
    private final String baseUrl = "http://localhost:8282";

    // Display list of staff with basic info
    @GetMapping("/staff")
    public String getStaffList(Model model) {
        String url = baseUrl + "/staff/basic-info";
        StaffBasicDTO[] staffArray = restTemplate.getForObject(url, StaffBasicDTO[].class);
        List<StaffBasicDTO> staffList = staffArray != null ? Arrays.asList(staffArray) : List.of();
        model.addAttribute("staffList", staffList);
        return "staff"; // Renders staff.html
    }

    // Display address details for a selected staff member
    @GetMapping("/staff/address")
    public String getStaffAddress(@RequestParam String fullName, Model model) {
        String url = baseUrl + "/staff/address-by-full-name?fullName=" + fullName;
        AddressDTO address = restTemplate.getForObject(url, AddressDTO.class);

        model.addAttribute("fullName", fullName);
        model.addAttribute("address", address != null ? address : new AddressDTO());
        return "address"; // Renders address.html
    }
}