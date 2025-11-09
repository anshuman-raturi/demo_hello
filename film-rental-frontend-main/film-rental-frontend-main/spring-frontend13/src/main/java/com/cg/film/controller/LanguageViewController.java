package com.cg.film.controller;

import com.cg.film.model.FilmDTO;
import com.cg.film.model.Language;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;


@Controller
public class LanguageViewController {
	@Value("${app.backend.url}")
    private String backendUrl;
	
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/languages")
    public String getLanguages(Model model) {
        String url = backendUrl+"/languages";
        Language[] languages = restTemplate.getForObject(url, Language[].class);
        model.addAttribute("languages", Arrays.asList(languages));
        return "languages";
    }
    @GetMapping("/languages/cinema")
    public String getFilmsByLanguage(@RequestParam("name") String name, Model model) {
        try {
            String url = backendUrl+"/api/films/api/films/language/" + name;
            FilmDTO[] films = restTemplate.getForObject(url, FilmDTO[].class);

            model.addAttribute("films", Arrays.asList(films));
            model.addAttribute("language", name);
            return "cinema";
        } catch (Exception e) {
        
            System.out.println("Error fetching films for " + name + ": " + e.getMessage());

            model.addAttribute("language", name);
            model.addAttribute("error", "No films available for " + name);
            return "cinema"; 
        }
    }
}

