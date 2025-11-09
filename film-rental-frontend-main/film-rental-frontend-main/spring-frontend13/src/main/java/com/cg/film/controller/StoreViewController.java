package com.cg.film.controller;

import com.cg.film.model.Staff;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Controller
public class StoreViewController {

    @Autowired
    private RestTemplate restTemplate;
    
//    @Value("${app.backend.url}")
//    private String backendUrl;
    
//    private final String baseUrl = backendUrl;
    private final String baseUrl = "http://localhost:8282";
    // Display list of manager IDs
    @GetMapping("/store")
    public String getManagerIds(Model model) {
        String url = baseUrl + "/store/managers";
        Long[] managerArray = restTemplate.getForObject(url, Long[].class);
        List<Long> managerIds = managerArray != null ? Arrays.asList(managerArray) : List.of();
        model.addAttribute("managerIds", managerIds);
        return "store";
    }
    @GetMapping("/store/staff/managers")
    public String getStaffByManager(@RequestParam Long managerId, Model model) {
        String url = baseUrl + "/staff/manager/" + managerId; // ✅ Corrected
        Staff[] staffArray = restTemplate.getForObject(url, Staff[].class);
        List<Staff> staffList = staffArray != null ? Arrays.asList(staffArray) : List.of();
        model.addAttribute("staffList", staffList);
        model.addAttribute("managerId", managerId);
        return "staff"; // Renders staff-by-manager.html
    }

}