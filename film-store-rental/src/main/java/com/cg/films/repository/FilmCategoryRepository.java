package com.cg.films.repository;

import com.cg.films.entity.Film;
import com.cg.films.entity.Category;
import com.cg.films.entity.FilmCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FilmCategoryRepository extends JpaRepository<FilmCategory, Long> {
    boolean existsByFilmAndCategory(Film film, Category category);
}