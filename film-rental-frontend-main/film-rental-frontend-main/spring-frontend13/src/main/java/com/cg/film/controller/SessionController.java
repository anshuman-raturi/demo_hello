package com.cg.film.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
 
@Controller
public class SessionController {
 
	@GetMapping("/films")
	public String filmsPage() {
	    return "film"; 
	}
	
	@GetMapping("/dvd")
	public String dvdPage() {
	    return "dvd"; 
	}

}