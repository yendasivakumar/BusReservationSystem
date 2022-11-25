package com.masai.service;

import com.masai.exceptions.AdminException;
import com.masai.model.Admin;

public interface AdminService {
	
	
	public Admin createCustomer(Admin admin)throws AdminException;
	
	public Admin updateCustomer(Admin admin,String key)throws AdminException;

}
