package com.cg.films.service;
 
import java.util.List;
 
import com.cg.films.dto.LanguageDTO;
 
public interface LanguageService {
	List<LanguageDTO> getAllLanguagesByName();
 
}