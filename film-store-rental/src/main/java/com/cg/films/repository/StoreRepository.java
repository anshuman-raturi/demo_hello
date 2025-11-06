package com.cg.films.repository;
 
import java.util.List;
 
import org.springframework.data.jpa.repository.JpaRepository;
import com.cg.films.entity.Store;
 
public interface StoreRepository extends JpaRepository<Store, Long> {
	List<Store> findAll();
	Store findByManager_StaffId(Long managerId);
	
}