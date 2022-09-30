package com.masai.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.model.Admin;

public interface AdminDao extends JpaRepository<Admin, Integer>{
	
}

/*
 * DAL : AdminDao and UserDao ; 
 * No need to take daoImpl--> spring data JPA give this.  
 */

