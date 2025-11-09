package com.cg.films.repository;

import com.cg.films.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
	Category findByName(String categoryName);

}