package com.cg.films.service;
 
import com.cg.films.entity.Actor;
import com.cg.films.entity.Film;
import com.cg.films.entity.FilmActor;
import com.cg.films.exception.InvalidActorNameException;
import com.cg.films.repository.ActorRepository;
import com.cg.films.service.impl.ActorServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
 
import java.util.List;
import java.util.Optional;
 
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
 
class ActorServiceImplTest {
 
    @Mock
    private ActorRepository actorRepository;
 
    @InjectMocks
    private ActorServiceImpl actorService;
 
    public ActorServiceImplTest() {
        MockitoAnnotations.openMocks(this);
    }
 
    @Test
    void testValidActorNameReturnsFilms() {
        Actor actor = new Actor();
        actor.setFirstName("Tom");
        actor.setLastName("Hanks");
 
        Film film = new Film();
        film.setTitle("Forrest Gump");
 
        FilmActor filmActor = new FilmActor();
        filmActor.setFilm(film);
 
        actor.setFilmActors(List.of(filmActor));
 
        when(actorRepository.findByFirstNameIgnoreCaseAndLastNameIgnoreCase("Tom", "Hanks"))
                .thenReturn(Optional.of(actor));
 
        List<String> films = actorService.getFilmsByActorFullName("Tom Hanks");
 
        assertEquals(1, films.size());
        assertEquals("Forrest Gump", films.get(0));
    }
 
    @Test
    void testInvalidActorNameFormatThrowsException() {
        InvalidActorNameException exception = assertThrows(InvalidActorNameException.class, () ->
                actorService.getFilmsByActorFullName("Tom"));
 
        assertEquals("Please enter both first name and last name.", exception.getMessage());
    }
 
    @Test
    void testActorNotFoundThrowsException() {
        when(actorRepository.findByFirstNameIgnoreCaseAndLastNameIgnoreCase("Sandra", "Cruise"))
                .thenReturn(Optional.empty());
 
        InvalidActorNameException exception = assertThrows(InvalidActorNameException.class, () ->
                actorService.getFilmsByActorFullName("Sandra Cruise"));
 
        assertEquals("Actor not found", exception.getMessage());
    }
}