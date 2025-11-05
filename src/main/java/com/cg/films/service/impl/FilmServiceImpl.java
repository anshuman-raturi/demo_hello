package com.cg.films.service.impl;

import com.cg.films.entity.Actor;
import com.cg.films.entity.Film;
import com.cg.films.repository.FilmRepository;
import com.cg.films.repository.ActorRepository;
import com.cg.films.service.FilmService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class FilmServiceImpl implements FilmService {

    private final FilmRepository filmRepository;
    private final ActorRepository actorRepository;

    public FilmServiceImpl(FilmRepository filmRepository, ActorRepository actorRepository) {
        this.filmRepository = filmRepository;
        this.actorRepository = actorRepository;
    }

    @Override
    public List<Film> findFilmsByCategory(String category) {
        // Use @Query method from FilmRepository
        return filmRepository.findFilmsByCategory(category);
    }

    @Override
    public List<Actor> findActorsByFilmName(String filmName) {
        // Use @Query method from ActorRepository
        return actorRepository.findActorsByFilmName(filmName);
    }
}