package com.cg.films.service;
 
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
 
import java.util.Collections;
import java.util.List;
 
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
 
import com.cg.films.dto.FilmDTO;
import com.cg.films.entity.Film;
import com.cg.films.exception.InvalidLanguageFoundException;
import com.cg.films.exception.NoFilmsFoundForLanguageException;
import com.cg.films.repository.FilmRepository;
import com.cg.films.repository.LanguageRepository;
import com.cg.films.service.impl.FilmServiceImpl;
 
class FilmServiceImplTest {
 
    @Mock
    private FilmRepository filmRepository;
 
    @Mock
    private LanguageRepository languageRepository;
 
    @InjectMocks
    private FilmServiceImpl filmService;
 
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }
 
    @Test
    void testInvalidLanguageThrowsException() {
        when(languageRepository.existsByName("Teluguno")).thenReturn(false);
 
        InvalidLanguageFoundException ex = assertThrows(
                InvalidLanguageFoundException.class,
                () -> filmService.getAllFilmsByLanguage("Teluguno")
        );
 
        assertEquals("Invalid language: Teluguno. Please check the spelling or try a different language.", ex.getMessage());
    }
 
    @Test
    void testNoFilmsFoundThrowsException() {
        when(languageRepository.existsByName("French")).thenReturn(true);
        when(filmRepository.findByLanguage_Name("French")).thenReturn(Collections.emptyList());
 
        NoFilmsFoundForLanguageException ex = assertThrows(
                NoFilmsFoundForLanguageException.class,
                () -> filmService.getAllFilmsByLanguage("French")
        );
 
        assertEquals("Films are not available in the language French.Please select another language.", ex.getMessage());
    }
 
    @Test
    void testGetAllFilmsSuccess() {
        when(languageRepository.existsByName("English")).thenReturn(true);
 
        Film film = new Film();
        film.setTitle("Inception");
        film.setDescription("Sci-fi thriller");
        film.setReleaseYear(2010);
 
        when(filmRepository.findByLanguage_Name("English")).thenReturn(List.of(film));
 
        List<FilmDTO> result = filmService.getAllFilmsByLanguage("English");
 
        assertEquals(1, result.size());
        assertEquals("Inception", result.get(0).getTitle());
    }
}