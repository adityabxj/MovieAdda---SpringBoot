package com.movieFlix.services;

import java.util.List;

import com.movieFlix.entities.User;

public interface UserServices {
	public String createUser(User ur);
	public boolean emailExists(String email);
	public List<User> getAllUsers();
	public boolean checkUser(String email, String password);
	public String removeUser(String email);
	public User getUser(String email);
	public void updateUser(User user);
	public void updateUserName(String name, String email);
	public void updateUserPass(String pass, String email);
	public void updateUserPhone(String phone, String email);
	public void updateUserAddress(String address, String email);
}
