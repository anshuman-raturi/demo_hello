package com.cg.films.repository;

import com.cg.films.entity.Film;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface FilmRepository extends JpaRepository<Film, Long> {

    @Query("SELECT f FROM Film f " +
           "JOIN FilmCategory fc ON f.filmId = fc.filmId " +
           "JOIN Category c ON fc.categoryId = c.categoryId " +
           "WHERE LOWER(c.name) = LOWER(:category)")
    List<Film> findFilmsByCategory(String category);
}