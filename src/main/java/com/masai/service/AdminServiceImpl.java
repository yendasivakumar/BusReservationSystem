package com.masai.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exceptions.AdminException;
import com.masai.model.Admin;
import com.masai.model.CurrentAdminSession;
import com.masai.repository.AdminDao;
import com.masai.repository.CurrentAdminSessionDao;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminDao aDao;
	
	@Autowired
	private CurrentAdminSessionDao sDao;

	@Override
	public Admin createCustomer(Admin admin) throws AdminException {
		Admin existingAdmin= aDao.findByMobile(admin.getMobile());
		
		if(existingAdmin != null) 
			throw new AdminException("Admin Already Registered with given UserName");
			return aDao.save(admin);
			
	}

	@Override
	public Admin updateCustomer(Admin admin, String key) throws AdminException {
		CurrentAdminSession loggedInAdmin= sDao.findByUuid(key);
		
		if(loggedInAdmin == null) {
			throw new AdminException("Please provide a valid key to update a Admin");
		}
		
		if(admin.getAdminId() == loggedInAdmin.getUserId()) {
			return aDao.save(admin);
		}
		else
			throw new AdminException("Invalid Admin Details, please login first");
	}
		
		
		
}


