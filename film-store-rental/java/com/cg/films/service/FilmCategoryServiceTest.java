package com.cg.films.service;

import com.cg.films.entity.Film;
import com.cg.films.entity.Category;
import com.cg.films.exception.RecordNotFound;
import com.cg.films.repository.FilmRepository;
import com.cg.films.repository.CategoryRepository;
import com.cg.films.repository.FilmCategoryRepository;
import com.cg.films.service.impl.FilmCategoryServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class FilmCategoryServiceTest {

    @Mock
    private FilmRepository filmRepository;

    @Mock
    private CategoryRepository categoryRepository;

    @Mock
    private FilmCategoryRepository filmCategoryRepository;

    @InjectMocks
    private FilmCategoryServiceImpl filmCategoryService;

    public FilmCategoryServiceTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testMovieExistsInCategory() {
        String filmName = "ACADEMY DINOSAUR";
        String categoryName = "Documentary";

        Film mockFilm = new Film();
        Category mockCategory = new Category();

        when(filmRepository.findByTitle(filmName)).thenReturn(mockFilm);
        when(categoryRepository.findByName(categoryName)).thenReturn(mockCategory);
        when(filmCategoryRepository.existsByFilmAndCategory(mockFilm, mockCategory)).thenReturn(true);

        boolean result = filmCategoryService.isMovieInCategory(filmName, categoryName);
        assertTrue(result, "Film should exist in the given category");
    }

    @Test
    void testMovieOrCategoryNotFound() {
        String filmName = "UNKNOWN FILM";
        String categoryName = "Documentary";

        when(filmRepository.findByTitle(filmName)).thenReturn(null);

        RecordNotFound exception = assertThrows(RecordNotFound.class, () -> {
            filmCategoryService.isMovieInCategory(filmName, categoryName);
        });

        assertEquals("Film or Category not found", exception.getMessage());
    }
}