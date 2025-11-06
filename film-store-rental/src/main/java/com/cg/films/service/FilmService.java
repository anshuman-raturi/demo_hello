package com.cg.films.service;

import com.cg.films.dto.FilmDTO;
import com.cg.films.entity.Actor;
import com.cg.films.entity.Film;
import java.util.List;

public interface FilmService {
    
	//mufi
	List<Film> findFilmsByCategory(String category);
    List<Actor> findActorsByFilmName(String filmName);
    
    
    //lavanya
	List<FilmDTO> getAllFilmsByLanguage(String name);

	
	//anshuman
    List<Film> getAllFilms();
    Film getFilmByTitle(String title);
}