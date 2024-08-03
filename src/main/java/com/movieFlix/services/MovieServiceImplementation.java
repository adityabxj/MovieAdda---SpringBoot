package com.movieFlix.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movieFlix.entities.Movie;
import com.movieFlix.repositories.MovieRepository;

@Service
public class MovieServiceImplementation implements MovieServices{
	
	@Autowired
	MovieRepository mvr;
	
	public MovieServiceImplementation(MovieRepository mvr) {
		super();
		this.mvr = mvr;
	}

	@Override
	public String addMovie(Movie m) {
		mvr.save(m);
		return "movie added";
	}

	@Override
	public String removeMovie(String name) {
		Movie movie = mvr.findByname(name);
		mvr.delete(movie);
		return "movie deleted";
	}
	
	@Override
	public boolean movieExists(String name) {
		if(mvr.findByname(name)==null) {
			return false;
		}else {
			return true;
		}
	}

	@Override
	public List<Movie> getAllMovies() {
		List<Movie> moviesList = mvr.findAll();
		return moviesList;
	}
}
