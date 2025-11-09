package com.cg.films.service;
 
import com.cg.films.entity.Film;
import com.cg.films.exception.RecordNotFound;
import com.cg.films.repository.FilmRepository;
import com.cg.films.repository.InventoryRepository;
import com.cg.films.service.impl.InventoryServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
 
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
 
class InventoryServiceTest {
 
    @Mock
    private InventoryRepository inventoryRepository;
 
    @Mock
    private FilmRepository filmRepository;
 
    @InjectMocks
    private InventoryServiceImpl inventoryService;
 
    public InventoryServiceTest() {
        MockitoAnnotations.openMocks(this);
    }
 
    @Test
    void testGetInventoryCountByTitle_ACE_GOLDFINGER() {
        String title = "ACE GOLDFINGER";
        Film mockFilm = new Film(); // Assuming Film has a default constructor
        when(filmRepository.findByTitle(title)).thenReturn(mockFilm);
        when(inventoryRepository.countByFilm_Title(title)).thenReturn(3L);
 
        long count = inventoryService.getInventoryCountByTitle(title);
        assertEquals(3L, count, "DVD count should be 3 for ACE GOLDFINGER");
    }
 
    @Test
    void testGetInventoryCountByTitle_invalidTitle() {
        String title = "UNKNOWN TITLE";
        when(filmRepository.findByTitle(title)).thenReturn(null);
 
        RecordNotFound exception = assertThrows(RecordNotFound.class, () -> {
            inventoryService.getInventoryCountByTitle(title);
        });
 
        assertEquals("Film is not available", exception.getMessage());
    }
}