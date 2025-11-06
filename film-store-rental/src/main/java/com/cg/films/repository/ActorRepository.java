package com.cg.films.repository;

import com.cg.films.entity.Actor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface ActorRepository extends JpaRepository<Actor, Long> {

    @Query("SELECT a FROM Actor a " +
           "JOIN FilmActor fa ON a.actorId = fa.actorId " +
           "JOIN Film f ON fa.filmId = f.filmId " +
           "WHERE LOWER(f.title) = LOWER(:filmName)")
    List<Actor> findActorsByFilmName(String filmName);
    
    List<Actor> findByFirstNameIgnoreCase(String firstName);
    List<Actor> findByLastNameIgnoreCase(String lastName);
}
