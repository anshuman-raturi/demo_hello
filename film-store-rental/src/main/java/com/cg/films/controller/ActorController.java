package com.cg.films.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.films.entity.Actor;
import com.cg.films.repository.ActorRepository;
import com.cg.films.service.ActorService;

@RestController
@RequestMapping("/actors")
public class ActorController {
    @Autowired
    private ActorRepository actorRepository;

    @Autowired
    private ActorService actorService;
    
    @GetMapping
    public List<Actor> getAllActors() {
        return actorRepository.findAll();
    }
    
    //neelima
    @GetMapping("/{id}/films")
    public List<String> getFilmsByActor(@PathVariable Long id) {
        return actorService.getFilmsByActor(id);
    }

    @GetMapping("/films/firstname/{fn}")
    public List<String> getFilmsByActorFirstName(@PathVariable String fn) {
        return actorService.getFilmsByActorFirstName(fn);
    }
 
    @GetMapping("/films/lastname/{ln}")
    public List<String> getFilmsByActorLastName(@PathVariable String ln) {
        return actorService.getFilmsByActorLastName(ln);
    }
    //end
}
