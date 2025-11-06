package com.cg.films.service.impl;

import com.cg.films.dto.FilmDTO;
import com.cg.films.entity.Actor;
import com.cg.films.entity.Film;
import com.cg.films.repository.FilmRepository;
import com.cg.films.repository.ActorRepository;
import com.cg.films.service.FilmService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
        return filmRepository.findByCategories_NameIgnoreCase(category);
    }

    @Override
    public List<Actor> findActorsByFilmName(String filmName) {
        // Use @Query method from ActorRepository
        return actorRepository.findActorsByFilmName(filmName);
    }
    
    
    //lavanya
	@Override
	public List<FilmDTO> getAllFilmsByLanguage(String name) {
		List<Film> films=filmRepository.findByLanguage_Name(name);
		List<FilmDTO> filmTitleDTO=new ArrayList<>();
		for(Film film:films) {
			filmTitleDTO.add(new FilmDTO(film.getTitle()));
		}
		return filmTitleDTO;
	}
	//end
	
	//anshuman
    @Override
    public List<Film> getAllFilms() {
        return filmRepository.findAll();
    }
 
    @Override
    public Film getFilmByTitle(String title) {
        return filmRepository.findByTitle(title);
    }
    //end
	
}