package com.cg.films.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.films.entity.Actor;
import com.cg.films.repository.ActorRepository;

@RestController
@RequestMapping("/actors")
public class ActorController {
    @Autowired
    private ActorRepository actorRepository;

    @GetMapping
    public List<Actor> getAllActors() {
        return actorRepository.findAll();
    }
}
