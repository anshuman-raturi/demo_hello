package com.cg.films.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.films.dto.LanguageDTO;
import com.cg.films.entity.Language;
import com.cg.films.repository.LanguageRepository;
import com.cg.films.service.LanguageService;

@RestController
@RequestMapping("/languages")
@CrossOrigin("*")

public class LanguageController {
    @Autowired
    private LanguageRepository languageRepository;
	private LanguageService langService;

	//comment if not use/error
	LanguageController(LanguageService langService){
		this.langService=langService;
	}
	
    @GetMapping
    public List<Language> getAllLanguages() {
        return languageRepository.findAll();
    }
    
    //lavanya
	@GetMapping("/api/languages/names")
	public List<LanguageDTO> getAllLanguagesNames(){
		return langService.getAllLanguagesByName();
	}
}