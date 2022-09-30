package com.masai.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import lombok.Data;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Admin {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int adminId ;
	private String adminUserName ;
	private String adminPassword ;
	
}

/*
 * @Data @AllArgsConstructor @NoArgsConstructor 
 *                                  Lombok dependency
 *  
 * @Entity @Id
	@GeneratedValue(strategy = GenerationType.AUTO) -- > ORM approach (Object Relational Mapping ))
 */


