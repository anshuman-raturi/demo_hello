package com.cg.films.controller;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.cg.films.dto.AddressDTO;
import com.cg.films.dto.StaffBasicDTO;
import com.cg.films.entity.Staff;
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
    @GetMapping("/address-by-first-name")
    public List<AddressDTO> getAddressByFirstName(@RequestParam String firstName) {
    return staffRepository.findByFirstNameIgnoreCase(firstName).stream()
            .map(staff -> StaffMapper.toAddressDTO(staff.getAddress()))
            .collect(Collectors.toList());
}
   
}  