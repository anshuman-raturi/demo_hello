package com.cg.films.repository;
 
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.cg.films.entity.Staff;
 
public interface StaffRepository extends JpaRepository<Staff, Long> {
    List<Staff> findByFirstNameIgnoreCase(String firstName);
    Optional<Staff> findByAddress_AddressId(Long addressId);
    Optional<Staff> findByFirstNameIgnoreCaseAndLastNameIgnoreCase(String firstName, String lastName);
	List<Staff> findByStore_StoreId(Long storeId);
}