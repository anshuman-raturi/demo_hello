package com.cg.films.entity;
 
import java.sql.Timestamp;
 
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
 
@Entity
@Table(name = "film")
public class Film {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "film_id")
    private Long filmId;
 
    private String title;
    private String description;
    private Integer releaseYear;
 
    @ManyToOne
    @JoinColumn(name = "language_id")
    private Language language;
 
    private Integer rentalDuration;
    private Double rentalRate;
    private Integer length;
    private Double replacementCost;
    private String rating;
    private Timestamp lastUpdate;
	public Long getFilmId() {
		return filmId;
	}
	public void setFilmId(Long filmId) {
		this.filmId = filmId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Integer getReleaseYear() {
		return releaseYear;
	}
	public void setReleaseYear(Integer releaseYear) {
		this.releaseYear = releaseYear;
	}
	public Language getLanguage() {
		return language;
	}
	public void setLanguage(Language language) {
		this.language = language;
	}
	public Integer getRentalDuration() {
		return rentalDuration;
	}
	public void setRentalDuration(Integer rentalDuration) {
		this.rentalDuration = rentalDuration;
	}
	public Double getRentalRate() {
		return rentalRate;
	}
	public void setRentalRate(Double rentalRate) {
		this.rentalRate = rentalRate;
	}
	public Integer getLength() {
		return length;
	}
	public void setLength(Integer length) {
		this.length = length;
	}
	public Double getReplacementCost() {
		return replacementCost;
	}
	public void setReplacementCost(Double replacementCost) {
		this.replacementCost = replacementCost;
	}
	public String getRating() {
		return rating;
	}
	public void setRating(String rating) {
		this.rating = rating;
	}
	public Timestamp getLastUpdate() {
		return lastUpdate;
	}
	public void setLastUpdate(Timestamp lastUpdate) {
		this.lastUpdate = lastUpdate;
	}
}