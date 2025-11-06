package com.cg.films.service;
 
import java.util.List;
 
import com.cg.films.entity.Actor;
 
public interface ActorService {
    List<Actor> getAllActors();
    
    List<String> getFilmsByActor(Long actorId);
    List<String> getFilmsByActorFirstName(String firstName);
    List<String> getFilmsByActorLastName(String lastName);
}