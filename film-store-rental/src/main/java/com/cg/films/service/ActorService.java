package com.cg.films.service;
 
import java.util.List;

import com.cg.films.dto.ActorDTO;
 
public interface ActorService {
	List<ActorDTO> getAllActors();
    
    List<String> getFilmsByActor(Long actorId);
    List<String> getFilmsByActorFullName(String fullName); // new method
}