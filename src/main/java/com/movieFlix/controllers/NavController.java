package com.movieFlix.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.movieFlix.entities.User;
import com.movieFlix.services.UserServices;

import jakarta.servlet.http.HttpSession;

@Controller
public class NavController {
    @Autowired
    UserServices usrs;
    
	@GetMapping("map-register")
	public String giveControlforRegistering() {
		return "register";
	}
	
	@GetMapping("map-login")
	public String giveControlforLoggingIn() {
		return "login";
	}
	
	@GetMapping("map-addmovie")
	public String giveControlforAddMovie(HttpSession session) {
        String email = (String) session.getAttribute("email");
        User usr = usrs.getUser(email);
        if(usr == null) {
        	return "login";
        }else {
        	return "addmovie";
        }
	}
	
	@GetMapping("map-rmvmovie")
	public String giveControlforRmvMovie(HttpSession session) {
        String email = (String) session.getAttribute("email");
        User usr = usrs.getUser(email);
        if(usr == null) {
        	return "login";
        }else {
        	return "removemovie";
        }
	}
	
	@GetMapping("map-rmvuser")
	public String giveControlforRmvUser(HttpSession session) {
        String email = (String) session.getAttribute("email");
        User usr = usrs.getUser(email);
        if(usr == null) {
        	return "login";
        }else {
        	return "removeuser";
        }
	}
	
	@GetMapping("map-backadmin")
	public String giveControlToBack() {
		return "adminHome";
	}
	
	@GetMapping("map-updateuser")
	public String giveControlForUpdateUserInfo(HttpSession session) {
        String email = (String) session.getAttribute("email");
        User usr = usrs.getUser(email);
        if(usr == null) {
        	return "login";
        }else {
        	return "updateuser";
        }
	}
	
	@GetMapping("map-backuser")
	public String giveControlToUserBack() {
		return "home";
	}
	
	@GetMapping("map-updatename")
	public String giveControlToUpdateName(HttpSession session) {
		if(isUserNull(session)) {
			return "login";
		}else {
			return "nameupdate";
		}
	}
	
	@GetMapping("map-updatepass")
	public String giveControlToUpdatePass(HttpSession session) {
		if(isUserNull(session)) {
			return "login";
		}else {
			return "passupdate";
		}
	}
	
	@GetMapping("map-updatephone")
	public String giveControlToUpdatePhone(HttpSession session) {
		if(isUserNull(session)) {
			return "login";
		}else {
			return "phoneupdate";
		}
	}
	
	@GetMapping("map-updateaddress")
	public String giveControlToUpdateAddress(HttpSession session) {
		if(isUserNull(session)) {
			return "login";
		}else {
			return "addressupdate";
		}
	}
	
	@GetMapping("map-index")
	public String giveControlToIndex() {
		return "index";
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
