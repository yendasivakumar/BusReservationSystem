package com.masai.service;

import java.util.List;

import com.masai.exceptions.UserException;
import com.masai.model.User;

public interface UserService {
	public User addUser(User user,String key) throws UserException;
	public User updateUser(User user,String key) throws UserException;
	public User deleteUser(int userId,String key) throws UserException;
	public User viewUser(int userID) throws UserException;
	public List<User> viewAllUsers() throws UserException;
	
}
