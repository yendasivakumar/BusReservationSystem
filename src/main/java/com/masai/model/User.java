package com.masai.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer userLoginId ;
	private String userName ;
	private String password ;
	private String firstName ;
	private String lastName ;
	private Long contect ;
	private String email ;
	
	@OneToOne
	private Reservation reservation  ;
	
	public User(String userName, String password, String firstName, String lastName, Long contect, String email) {
		super();
		this.userName = userName;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.contect = contect;
		this.email = email;
	}

}

/*
 * Take Reservation class  ;
 */


