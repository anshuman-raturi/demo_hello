package com.cg.films.entity;

import java.io.Serializable;
import java.util.Objects;

@SuppressWarnings("serial")
public class FilmActorId implements Serializable {
    private Long actorId;
    private Long filmId;

    public FilmActorId() {}

    public FilmActorId(Long actorId, Long filmId) {
        this.actorId = actorId;
        this.filmId = filmId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FilmActorId)) return false;
        FilmActorId that = (FilmActorId) o;
        return Objects.equals(actorId, that.actorId) &&
               Objects.equals(filmId, that.filmId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(actorId, filmId);
    }
}