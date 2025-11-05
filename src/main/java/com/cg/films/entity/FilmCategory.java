package com.cg.films.entity;

import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;

@Entity
@Table(name = "film_category")
@IdClass(FilmCategoryId.class)
public class FilmCategory {
    @Id
    @Column(name = "film_id")
    private Long filmId;

    @Id
    @Column(name = "category_id")
    private Long categoryId;

    @Column(name = "last_update")
    private Timestamp lastUpdate;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "film_id", insertable = false, updatable = false)
    private Film film;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "category_id", insertable = false, updatable = false)
    private Category category;

	public Long getFilmId() {
		return filmId;
	}

	public void setFilmId(Long filmId) {
		this.filmId = filmId;
	}

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	public Timestamp getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(Timestamp lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	public Film getFilm() {
		return film;
	}

	public void setFilm(Film film) {
		this.film = film;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

    
}
