package com.cg.films.service;
 
import com.cg.films.controller.StaffController;
import com.cg.films.dto.AddressDTO;
import com.cg.films.dto.StaffBasicDTO;
import com.cg.films.entity.Address;
import com.cg.films.entity.Staff;
import com.cg.films.exception.StaffNotFoundException;
import com.cg.films.repository.StaffRepository;
 
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
 
import java.sql.Timestamp;
 
import java.util.List;
import java.util.Optional;
import java.util.Arrays;
 
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
 
class StaffControllerTest {
 
    @Mock
    private StaffRepository staffRepository;
 
    @InjectMocks
    private StaffController staffController;
 
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }
 
    @Test
    void testGetBasicStaffInfo() {
        Staff staff = new Staff();
        staff.setFirstName("John");
        staff.setLastName("Doe");
        Address address = new Address();
        address.setAddressId(1L);
        staff.setAddress(address);
 
        when(staffRepository.findAll()).thenReturn(Arrays.asList(staff));
 
        List<StaffBasicDTO> result = staffController.getBasicStaffInfo();
 
        assertEquals(1, result.size());
        assertEquals("John", result.get(0).getFirstName());
        assertEquals("Doe", result.get(0).getLastName());
        assertEquals("John Doe", result.get(0).getFullName());
        assertEquals(1L, result.get(0).getAddressId());
    }
 
    
    @Test
    void testGetAddressByFullName_Success() {
        Staff staff = new Staff();
        Address address = new Address();
        address.setAddressId(3L);
        address.setAddress("456 Elm St");
        address.setDistrict("North");
        address.setPostalCode("560002");
        address.setPhone("9876543210");
        address.setLastUpdate(new Timestamp(System.currentTimeMillis()));
        staff.setAddress(address);
 
        when(staffRepository.findByFirstNameIgnoreCaseAndLastNameIgnoreCase("Alice", "Smith"))
            .thenReturn(Optional.of(staff));
 
        AddressDTO result = staffController.getAddressByFullName("Alice Smith");
 
        assertEquals("456 Elm St", result.getAddress());
        assertEquals("North", result.getDistrict());
    }
 
    @Test
    void testGetAddressByFullName_NotFound() {
        when(staffRepository.findByFirstNameIgnoreCaseAndLastNameIgnoreCase("Bob", "Marley"))
            .thenReturn(Optional.empty());
 
        StaffNotFoundException exception = assertThrows(StaffNotFoundException.class, () -> {
            staffController.getAddressByFullName("Bob Marley");
        });
 
        assertEquals("No staff found with name: Bob Marley", exception.getMessage());
    }
 
    @Test
    void testGetAddressByFullName_InvalidFormat() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            staffController.getAddressByFullName("SingleName");
        });
 
        assertEquals("Full name must include both first and last name.", exception.getMessage());
    }
}