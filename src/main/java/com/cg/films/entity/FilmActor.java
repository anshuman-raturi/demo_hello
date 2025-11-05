package com.cg.films.entity;

import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "film_actor")
@IdClass(FilmActorId.class)
public class FilmActor {

    @Id
    @Column(name = "actor_id")
    private Long actorId;

    @Id
    @Column(name = "film_id")
    private Long filmId;

    @Column(name = "last_update")
    private Timestamp lastUpdate;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "actor_id", insertable = false, updatable = false)
    private Actor actor;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "film_id", insertable = false, updatable = false)
    private Film film;

    public Long getActorId() { return actorId; }
    public void setActorId(Long actorId) { this.actorId = actorId; }

    public Long getFilmId() { return filmId; }
    public void setFilmId(Long filmId) { this.filmId = filmId; }

    public Timestamp getLastUpdate() { return lastUpdate; }
    public void setLastUpdate(Timestamp lastUpdate) { this.lastUpdate = lastUpdate; }

    public Actor getActor() { return actor; }
    public void setActor(Actor actor) { this.actor = actor; }

    public Film getFilm() { return film; }
    public void setFilm(Film film) { this.film = film; }
}