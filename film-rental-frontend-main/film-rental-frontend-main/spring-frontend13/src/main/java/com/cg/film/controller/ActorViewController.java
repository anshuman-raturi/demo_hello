package com.cg.film.controller;

import com.cg.film.model.ActorDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Controller
public class ActorViewController {

	@Value("${app.backend.url}")
    private String backendUrl;
	
    @Autowired
    private RestTemplate restTemplate;

    // Display list of actors
    @GetMapping("/actors")
    public String getActors(Model model) {
        String url = backendUrl+"/actors";
        ActorDTO[] actorArray = restTemplate.getForObject(url, ActorDTO[].class);
        List<ActorDTO> actors = actorArray != null ? Arrays.asList(actorArray) : List.of();
        model.addAttribute("actors", actors);
        return "actors"; // maps to templates/actors.html
    }


    @GetMapping("/actor/films")
    public String getFilmsByActor(@RequestParam String fullName, Model model) {
        String url = backendUrl+"/actors/films/by-name?name=" + fullName;
        String[] filmArray = restTemplate.getForObject(url, String[].class);
        List<String> films = filmArray != null ? Arrays.asList(filmArray) : List.of();

        model.addAttribute("actorName", fullName);
        model.addAttribute("films", films);

        return "films";
    }
}