package com.cg.films.repository;

import com.cg.films.entity.Film;
import com.cg.films.entity.FilmActor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FilmActorRepository extends JpaRepository<FilmActor, Long> {
    List<FilmActor> findByFilm(Film film);
}