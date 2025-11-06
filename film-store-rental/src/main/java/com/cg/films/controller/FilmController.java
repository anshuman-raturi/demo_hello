package com.cg.films.controller;

import com.cg.films.dto.FilmDTO;
import com.cg.films.entity.Actor;
import com.cg.films.entity.Film;
import com.cg.films.service.FilmService;

import org.springframework.http.ResponseEntity;
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
    
    //lavanya
    @GetMapping("/api/films/language/{lang}")
    public List<FilmDTO> getFilmsByLanguage(@PathVariable String lang) {
        return filmService.getAllFilmsByLanguage(lang);
    }
    //end
    
    
    
    //anshuman
    // Existing endpoint: Get all film details
    @GetMapping
    public ResponseEntity<List<Film>> getAllFilms() {
        return ResponseEntity.ok(filmService.getAllFilms());
    }
    //end
}