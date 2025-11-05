package com.cg.films.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.films.entity.Language;
import com.cg.films.repository.LanguageRepository;

@RestController
@RequestMapping("/languages")
public class LanguageController {
    @Autowired
    private LanguageRepository languageRepository;

    @GetMapping
    public List<Language> getAllLanguages() {
        return languageRepository.findAll();
    }
}