package com.cg.films.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.films.entity.Language;

public interface LanguageRepository extends JpaRepository<Language, Long> {
	List<Language> findAll();	
}