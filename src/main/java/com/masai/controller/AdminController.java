package com.masai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.masai.exceptions.AdminException;
import com.masai.model.Admin;
import com.masai.service.AdminService;

@RestController
public class AdminController {

	@Autowired
	private AdminService cService;
	
	
	@PostMapping("/admin")
	public ResponseEntity<Admin> saveAdmin(@RequestBody Admin admin) throws AdminException {
		
		Admin savedCustomer= cService.createCustomer(admin);

		return new ResponseEntity<Admin>(savedCustomer,HttpStatus.CREATED);
	}
	
	@PutMapping("/admin")
	public  ResponseEntity<Admin> updateAdmin(@RequestBody Admin admin,@RequestParam(required = false) String key ) throws AdminException {
		
		
		Admin updatedCustomer= cService.updateCustomer(admin, key);
				
		return new ResponseEntity<Admin>(updatedCustomer,HttpStatus.OK);
		
	}
	
	
}
