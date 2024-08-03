package com.movieFlix.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.movieFlix.entities.Movie;
import com.movieFlix.entities.User;
import com.movieFlix.services.MovieServices;
import com.movieFlix.services.UserServices;
import jakarta.servlet.http.HttpSession;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    UserServices usrs;

    @Autowired
    MovieServices mvs;

    public UserController(UserServices usrs) {
        super();
        this.usrs = usrs;
    }

    @PostMapping("createuser")
    public String emailExists(@ModelAttribute User ur) {
        if (usrs.emailExists(ur.getEmail())) {
            return "registerfail";
        } else {
            usrs.createUser(ur);
            return "registersuccess";
        }
    }

    @GetMapping("login")
    public String validateUser(@RequestParam("email") String email, @RequestParam String password, HttpSession session) {
        if (usrs.checkUser(email, password)) {
            session.setAttribute("email", email);
            if (email.equals("admin@gmail.com")) {
                return "adminHome";
            } else {
                return "home";
            }
        } else {
            return "loginfail";
        }
    }

    @GetMapping("map-viewuser")
    public String getAllUsers(Model m, HttpSession session) {
        String email = (String) session.getAttribute("email");
        User usr = usrs.getUser(email);
        if(usr == null) {
        	return "login";
        }else {
	        List<User> userList = usrs.getAllUsers();
	        m.addAttribute("users", userList);
	        return "viewusers";
        }
    }

    @PostMapping("rmv-user")
    public String removeUser(@RequestParam("email") String email, HttpSession session) {
        if (isNull(session)) {
			return "login";
		}else {
			if (usrs.emailExists(email)) {
	            usrs.removeUser(email);
	            return "removeusersuccess";
	        } else {
	            return "removeuserfail";
	        }
		}
    }

    @GetMapping("map-exploremovies")
    public String exploreMovies(HttpSession session, Model m) {
        String email = (String) session.getAttribute("email");
        User usr = usrs.getUser(email);
        if(usr == null) {
        	return "login";
        }
        if (usr.isPremium()) {
            List<Movie> movieList = mvs.getAllMovies();
            m.addAttribute("movies", movieList);
            return "viewmoviestouser";
        } else {
            return "payment";
        }
    }

    @PostMapping("updateuser")
    public String updateUser(User user, Model m, HttpSession session) {
        if (isNull(session)) {
			return "login";
		}else {
			usrs.updateUser(user);
	        return "updateusersuccess";
		}
    }

    @PostMapping("nameusername")
    public String updateUserName(@RequestParam String name, HttpSession session, Model m) {
        if (isNull(session)) {
			return "login";
		}else {
			String email = (String) session.getAttribute("email");
	        usrs.updateUserName(name, email);
	        return "updateusersuccess";
		}
    }

    @PostMapping("userpass")
    public String updateUserPass(@RequestParam String password, HttpSession session, Model m) {
        if (isNull(session)) {
			return "login";
		}else {
	        String email = (String) session.getAttribute("email");
	        usrs.updateUserPass(password, email);
	        return "updateusersuccess";
		}
    }

    @PostMapping("userphone")
    public String updateUserPhone(@RequestParam String phone, HttpSession session, Model m) {
        if (isNull(session)) {
			return "login";
		}else {
	        String email = (String) session.getAttribute("email");
	        usrs.updateUserPhone(phone, email);
	        return "updateusersuccess";
		}
    }

    @PostMapping("useraddress")
    public String updateUserAddress(@RequestParam String address, HttpSession session, Model m) {
        if (isNull(session)) {
			return "login";
		}else {
	        String email = (String) session.getAttribute("email");
	        usrs.updateUserAddress(address, email);
	        return "updateusersuccess";
		}
    }

    @GetMapping("map-logout")
    public String logoutMethod(HttpSession session) {
        session.invalidate();
        return "login";
    }
    
    public boolean isNull(HttpSession session) {
        String email = (String) session.getAttribute("email");
        User usr = usrs.getUser(email);
        if(usr == null) {
        	return true;
        }else {
        	return false;
        }
    }
}
