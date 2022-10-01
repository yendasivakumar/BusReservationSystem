package com.masai.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Admin {

	@Id
	@GeneratedValue(strategy =  GenerationType.AUTO)
	private Integer adminId;
	private String adminUserName;
	private String adminPassword;
	private String mobile;

}

//
//"adminUserName":"Ram",
//"adminPassword":'352345"
