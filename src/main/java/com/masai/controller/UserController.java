package com.masai.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masai.exceptions.UserException;
import com.masai.model.User;
import com.masai.service.UserService;

@RestController
@RequestMapping("/BRSystem")
public class UserController {
	@Autowired
	private UserService userService ;
	
	@PostMapping("/user")
	public ResponseEntity<User> registerUserHandler(@RequestBody User user) throws UserException{
		User addedUser  = userService.addUser(user) ;
		return new ResponseEntity<User>(addedUser, HttpStatus.CREATED) ;
	}
	
	@PutMapping("/user")
	public ResponseEntity<User> updateUserHandler(@RequestBody User user) throws UserException{
		User updatedUser  = userService.updateUser(user) ;
		return new ResponseEntity<User>(updatedUser, HttpStatus.OK) ;
	}
	
	@DeleteMapping("/user/{id}")
	public ResponseEntity<User> daleteUserHandler(@PathVariable int id) throws UserException{
		User daleteUser  = userService.deleteUser(id) ;
		return new ResponseEntity<User>(daleteUser, HttpStatus.OK) ;
	}
	
	@GetMapping("/user/{id}")
	public ResponseEntity<User> viewUserHandler(@PathVariable int id) throws UserException{
		User viewUser  = userService.viewUser(id) ;
		return new ResponseEntity<User>(viewUser, HttpStatus.CREATED) ;
	}
	
	@GetMapping("/users")
	public ResponseEntity<List<User>> viewAllUserHandler() throws UserException{
		List<User> viewUser  = userService.viewallUsers() ;
		
		return new ResponseEntity<List<User>>(viewUser, HttpStatus.CREATED) ;
	}
}