package com.cg.films.service;

import com.cg.films.entity.Actor;
import com.cg.films.entity.Film;
import java.util.List;

public interface FilmService {
    List<Film> findFilmsByCategory(String category);
    List<Actor> findActorsByFilmName(String filmName);
}