package com.cg.films.entity;

import java.io.Serializable;
import java.util.Objects;

@SuppressWarnings("serial")
public class FilmCategoryId implements Serializable {
    private Long filmId;
    private Long categoryId;

    public FilmCategoryId() {}

    public FilmCategoryId(Long filmId, Long categoryId) {
        this.filmId = filmId;
        this.categoryId = categoryId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FilmCategoryId)) return false;
        FilmCategoryId that = (FilmCategoryId) o;
        return Objects.equals(filmId, that.filmId) &&
               Objects.equals(categoryId, that.categoryId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(filmId, categoryId);
    }
}