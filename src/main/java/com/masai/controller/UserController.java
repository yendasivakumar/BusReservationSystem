package com.masai.controller;

import java.util.List;

import javax.validation.Valid;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.masai.exceptions.UserException;
import com.masai.model.Bus;
import com.masai.model.User;
import com.masai.service.UserService;

@RestController
@RequestMapping("/BRSystem")
public class UserController {
	
	@Autowired
	private UserService userService ;
	
	@PostMapping("/user")
	public ResponseEntity<User> registerUserHandler(@RequestParam(required = false) String key,@RequestBody User user) throws UserException{
		User addedUser  = userService.addUser(user,key) ;
		return new ResponseEntity<User>(addedUser, HttpStatus.CREATED) ;
//		http://localhost:8888/BRSystem/user
	}
	
	@PutMapping("/user")
	public ResponseEntity<User> updateUserHandler(@RequestParam(required = false) String key, @RequestBody User user) throws UserException{
		User updatedUser  = userService.updateUser(user,key) ;
		return new ResponseEntity<User>(updatedUser, HttpStatus.OK) ;
//		http://localhost:8888/BRSystem/user
	}
	
	@DeleteMapping("/user/{id}")
	public ResponseEntity<User> daleteUserHandler(@PathVariable int id, @RequestParam String key) throws UserException{
		User daleteUser  = userService.deleteUser(id,key) ;
		return new ResponseEntity<User>(daleteUser, HttpStatus.OK) ;
//		http://localhost:8888/BRSystem/user/id
	}
	
	@GetMapping("/user/{id}")
	public ResponseEntity<User> viewUserHandler(@PathVariable int id) throws UserException{
		User viewUser  = userService.viewUser(id) ;
		return new ResponseEntity<User>(viewUser, HttpStatus.CREATED) ;
//		http://localhost:8888/BRSystem/user/id
	}
	
	@GetMapping("/users")
	public ResponseEntity<List<User>> viewAllUserHandler() throws UserException{
		List<User> viewUser  = userService.viewAllUsers() ;
		
		return new ResponseEntity<List<User>>(viewUser, HttpStatus.CREATED) ;
//		http://localhost:8888/BRSystem/users
	}

}

//requestBody
//{
//  "userName": "vikash",
//  "password": "12345",
//  "firstName": "kiran",
//  "lastName": "prakash",
//  "contact": "983592835345",
//  "email": "badu@gmail.com",
//}
