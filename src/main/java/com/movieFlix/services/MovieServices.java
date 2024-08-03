package com.movieFlix.services;

import java.util.List;
import com.movieFlix.entities.Movie;

public interface MovieServices {
	public String addMovie(Movie m);
	public String removeMovie(String name);
	public boolean movieExists(String name);
	public List<Movie> getAllMovies();
}
