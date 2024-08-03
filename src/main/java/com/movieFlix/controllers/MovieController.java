package com.movieFlix.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import com.movieFlix.entities.Movie;
import com.movieFlix.entities.User;
import com.movieFlix.services.MovieServices;
import com.movieFlix.services.UserServices;

import jakarta.servlet.http.HttpSession;

@Controller
public class MovieController {
    @Autowired
    UserServices usrs;
	
	@Autowired
	MovieServices mvs;

	public MovieController(MovieServices mvs) {
		super();
		this.mvs = mvs;
	}
	
	@PostMapping("add-movie")
	public String addMovie(Movie m, HttpSession session) {
		if(isUserNull(session)) {
			return "login";
		}else {
			if (mvs.movieExists(m.getName())) {
				return "addmoviefail";
			}else {
				mvs.addMovie(m);
				return "addmoviesucces";
			}
		}
	}

	@PostMapping("rmv-movie")
	public String removeMovie(String name, HttpSession session) {
		if (isUserNull(session)) {
			return "login";
		}else {
			if(mvs.movieExists(name)) {
				mvs.removeMovie(name);
				return "removemoviesucces";
			}else {
				return "removemoviefail";
			}
		}
	}
	
	@GetMapping("map-viewmovie")
	public String getAllMovies(Model m, HttpSession session) {
        String email = (String) session.getAttribute("email");
        User usr = usrs.getUser(email);
        if(usr == null) {
        	return "login";
        }else {
			List<Movie> movieList = mvs.getAllMovies();
			m.addAttribute("movies", movieList);
			return "viewmovies";
        }
	}
	
    public boolean isUserNull(HttpSession session) {
        String email = (String) session.getAttribute("email");
        User usr = usrs.getUser(email);
        if(usr == null) {
        	return true;
        }else {
        	return false;
        }
    }
}
