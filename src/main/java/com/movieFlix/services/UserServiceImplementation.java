package com.movieFlix.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.movieFlix.entities.User;
import com.movieFlix.repositories.UserRepository;

@Service
public class UserServiceImplementation implements UserServices{
	
	@Autowired
	UserRepository usr;
	
	public UserServiceImplementation(UserRepository usr) {
		super();
		this.usr = usr;
	}

	@Override
	public String createUser(User ur) {
		usr.save(ur);
		return "User is created";
	}
	
	@Override
	public List<User> getAllUsers() {
		List<User> usrList = usr.findAll();
		return usrList;
	}
	
	@Override
	public boolean emailExists(String email) {
		if(usr.findByEmail(email)==null) {
			return false;
		}else {
			return true;
		}
	}

	@Override
	public boolean checkUser(String email, String password) {
		
		User user = usr.findByEmail(email);
		if(user!=null)
		{
		String pass = user.getPassword();
		if(pass.equals(password)) {
			return true;
		}else {
			return false;
		}
		}
		return false;
	}

	@Override
	public String removeUser(String email) {
		User user = usr.findByEmail(email);
		usr.delete(user);
		return "user deleted";
	}

	@Override
	public User getUser(String email) {
		User user = usr.findByEmail(email);
		return user;
	}

	@Override
	public void updateUser(User user) {
		usr.save(user);
	}

	@Override
	public void updateUserName(String name, String email) {
		User user = usr.findByEmail(email);
		user.setName(name);
		usr.save(user);
	}

	@Override
	public void updateUserPass(String pass, String email) {
		User user = usr.findByEmail(email);
		user.setPassword(pass);
		usr.save(user);
	}

	@Override
	public void updateUserPhone(String phone, String email) {
		User user = usr.findByEmail(email);
		user.setPhone(phone);
		usr.save(user);
	}

	@Override
	public void updateUserAddress(String address, String email) {
		User user = usr.findByEmail(email);
		user.setAddress(address);
		usr.save(user);
	}
}
