package com.cg.films.repository;
 
import org.springframework.data.jpa.repository.JpaRepository;
import com.cg.films.entity.Inventory;
 
public interface InventoryRepository extends JpaRepository<Inventory, Long> {
    long countByFilm_Title(String title); // Derived query
}