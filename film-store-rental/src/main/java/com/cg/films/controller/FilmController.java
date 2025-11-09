package com.cg.films.controller;

import com.cg.films.dto.FilmDTO;
import com.cg.films.entity.Actor;
import com.cg.films.entity.Film;
import com.cg.films.service.FilmService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/films")
@CrossOrigin("*")
public class FilmController {

    private final FilmService filmService;

    public FilmController(FilmService filmService) {
        this.filmService = filmService;
    }

    @GetMapping("/category/{category}")
    public List<Film> getFilmsByCategory(@PathVariable String category) {
        return filmService.findFilmsByCategory(category);
    }

    @GetMapping("/films/{filmName}/actors")
    public ResponseEntity<List<Actor>> getActorsByFilmName(@PathVariable String filmName) {
        List<Actor> actors = filmService.findActorsByFilmName(filmName);
        return ResponseEntity.ok(actors);
    }
    
    //lavanya
    @GetMapping("/api/films/filmDetails/language/{lang}")
    public List<FilmDTO> getFilmsByLanguage(@PathVariable String lang) {
        return filmService.getAllFilmsByLanguage(lang);
    }
    @GetMapping("/api/films/language/{lang}")
    public List<FilmDTO> getFilmsByLang(@PathVariable String lang){
    	return filmService.getAllFilmsByLanguage(lang);
    }
    //end
    
    //anshuman
    @GetMapping
    public ResponseEntity<List<Film>> getAllFilms() {
        return ResponseEntity.ok(filmService.getAllFilms());
    }
    //end
}