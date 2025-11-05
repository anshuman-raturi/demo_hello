package com.cg.films.controller;

import com.cg.films.entity.Actor;
import com.cg.films.entity.Film;
import com.cg.films.service.FilmService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/films")
public class FilmController {

    private final FilmService filmService;

    public FilmController(FilmService filmService) {
        this.filmService = filmService;
    }

    @GetMapping("/category/{category}")
    public List<Film> getFilmsByCategory(@PathVariable String category) {
        return filmService.findFilmsByCategory(category);
    }

    @GetMapping("/{filmName}/actors")
    public List<Actor> getActorsByFilm(@PathVariable String filmName) {
        return filmService.findActorsByFilmName(filmName);
    }
}