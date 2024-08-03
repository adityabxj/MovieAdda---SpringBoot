package com.movieFlix.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Movie {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;
	String name;
	String link;
	String genre;
	String cast;
	String director;
	public Movie() {
		super();
	}
	public Movie(int id, String name, String link, String genre, String cast, String director) {
		super();
		this.id = id;
		this.name = name;
		this.link = link;
		this.genre = genre;
		this.cast = cast;
		this.director = director;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getCast() {
		return cast;
	}
	public void setCast(String cast) {
		this.cast = cast;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	@Override
	public String toString() {
		return "Movie [id=" + id + ", name=" + name + ", link=" + link + ", genre=" + genre + ", cast=" + cast
				+ ", director=" + director + "]";
	}
}
