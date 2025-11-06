package com.cg.films.repository;
 
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.cg.films.entity.Staff;
 
public interface StaffRepository extends JpaRepository<Staff, Long> {
	List<Staff> findByStore_StoreId(Long storeId);
    List<Staff> findByLastNameIgnoreCase(String lastName);
    List<Staff> findByFirstNameIgnoreCase(String firstName);
}