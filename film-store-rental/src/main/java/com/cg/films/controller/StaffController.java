package com.cg.films.controller;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.cg.films.dto.AddressDTO;
import com.cg.films.dto.StaffBasicDTO;
import com.cg.films.entity.Staff;
import com.cg.films.exception.StaffNotFoundException;
import com.cg.films.mapper.StaffMapper;
import com.cg.films.repository.StaffRepository;
import com.cg.films.service.StaffService;
 
 
@RestController
@RequestMapping("/staff")
public class StaffController {
 
    @Autowired
    private StaffService staffService;
 
    private final StaffRepository staffRepository;
    
    public StaffController(StaffRepository staffRepository) {
        this.staffRepository = staffRepository;
    }
 
    @GetMapping("/manager/{managerId}")
    public List<Staff> getStaffByManagerId(@PathVariable Long managerId) {
        return staffService.getStaffByManagerId(managerId);
    }
    
    
    //manasa
    @GetMapping("/basic-info")
    public List<StaffBasicDTO> getBasicStaffInfo() {
        return staffRepository.findAll().stream()
            .map(StaffMapper::toBasicDTO)
            .collect(Collectors.toList());
    }
 
    @GetMapping("/address-by-full-name")
    public AddressDTO getAddressByFullName(@RequestParam String fullName) {
        String[] parts = fullName.trim().split(" ");
        if (parts.length < 2) {
            throw new IllegalArgumentException("Full name must include both first and last name.");
        }
 
        String firstName = parts[0];
        String lastName = parts[1];
 
        Staff staff = staffRepository.findByFirstNameIgnoreCaseAndLastNameIgnoreCase(firstName, lastName)
            .orElseThrow(() -> new StaffNotFoundException("No staff found with name: " + fullName));
 
        return StaffMapper.toAddressDTO(staff.getAddress());
    }
   
}  