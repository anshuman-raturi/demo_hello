package com.cg.films.service;
 
import java.util.List;
import com.cg.films.entity.Staff;
 
public interface StaffService {

    List<Staff> getStaffByManagerId(Long managerId);
}