package com.cg.films.serviceImpl;
 
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.films.entity.Staff;
import com.cg.films.entity.Store;
import com.cg.films.exception.InvalidInputException;
import com.cg.films.exception.ManagerIdNotFoundException;
import com.cg.films.repository.StaffRepository;
import com.cg.films.repository.StoreRepository;
import com.cg.films.service.StaffService;
 
@Service
public class StaffServiceImpl implements StaffService {
 
    @Autowired
    private StaffRepository staffRepository;
 
    @Autowired
    private StoreRepository storeRepository;
 
    @Override
    public List<Staff> getStaffByManagerId(Long managerId) {
        if (managerId == null || managerId <= 0) {
            throw new InvalidInputException("Manager ID must be positive");
        }
 
        Store store = storeRepository.findByManager_StaffId(managerId);
        if (store == null) {
            throw new ManagerIdNotFoundException("Manager ID " + managerId + " not found");
        }
 
    
        List<Staff> staffList = staffRepository.findByStore_StoreId(store.getStoreId());
        if (staffList.isEmpty()) {
            throw new ManagerIdNotFoundException("No staff found for manager ID " + managerId);
        }
 
        return staffList;
    }
}