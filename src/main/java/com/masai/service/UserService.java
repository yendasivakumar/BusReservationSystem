package com.masai.service;

import java.util.List;
import org.springframework.stereotype.Service;

import com.masai.exceptions.UserException;
import com.masai.model.User;


public interface UserService {
	
	public User addUser(User user) throws UserException ; 
	public User updateUser(User user) throws UserException ;
	public User deleteUser(int userId) throws UserException ;
	public User viewUser(int userId) throws UserException;
	public List<User> viewallUsers() throws UserException;
}
