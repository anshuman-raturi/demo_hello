package com.cg.films.repository;

import com.cg.films.entity.Film;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface FilmRepository extends JpaRepository<Film, Long> {

    List<Film> findByCategories_NameIgnoreCase(String name);

    
    //lavanya
    List<Film> findByLanguage_Name(String name);
    
    //anshuman
    Film findByTitle(String title);

}