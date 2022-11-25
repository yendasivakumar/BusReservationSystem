package com.masai.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exceptions.LoginException;
import com.masai.model.Admin;
import com.masai.model.CurrentAdminSession;
import com.masai.model.CurrentUserSession;
import com.masai.model.LoginDTO;
import com.masai.model.User;
import com.masai.repository.AdminDao;
import com.masai.repository.CurrentAdminSessionDao;
import com.masai.repository.CurrentUserSessionDao;
import com.masai.repository.UserDao;

import net.bytebuddy.utility.RandomString;

@Service
public class LoginServiceImpl implements LoginService{

	@Autowired
	private UserDao cDao;
	
	@Autowired
	private CurrentUserSessionDao sDao;
	
	@Autowired
	private AdminDao aDao;
	
	@Autowired
	private CurrentAdminSessionDao asDao;
	
	
	
	@Override
	public String logIntoAccount(LoginDTO dto)throws LoginException{
		
		
		User existingUser= cDao.findByContact(dto.getMobileNo());
		
		if(existingUser == null) {
			throw new LoginException("Please Enter a valid mobile number");
		}
		
		Optional<CurrentUserSession> validUserSessionOpt =  sDao.findById(existingUser.getUserLoginId());
		
		if(validUserSessionOpt.isPresent()) {
			
			throw new LoginException("User already Logged In with this number");
			
		}
		
		if(existingUser.getPassword().equals(dto.getPassword())) {
			
			String key= RandomString.make(6);
			
			CurrentUserSession currentUserSession = new CurrentUserSession(existingUser.getUserLoginId(),key,LocalDateTime.now());
			
			sDao.save(currentUserSession);

			return currentUserSession.toString();
		}
		else
			throw new LoginException("Please Enter a valid password");
		
	}


	@Override
	public String logOutFromAccount(String key)throws LoginException {
		
		CurrentUserSession validUserSession = sDao.findByUuid(key);
		
		if(validUserSession == null) {
			throw new LoginException("User Not Logged In with this key");
		}
		
		sDao.delete(validUserSession);
		
		return "Logged Out !";
		
	}


	@Override
	public String logIntoAdminAccount(LoginDTO dto) throws LoginException {
		Admin existingAdmin= aDao.findByMobile(dto.getMobileNo());
		
		if(existingAdmin == null) {
			throw new LoginException("Please Enter a valid mobile number");
		}
		
		Optional<CurrentAdminSession> validAdminSessionOpt =  asDao.findById(existingAdmin.getAdminId());
		
		if(validAdminSessionOpt.isPresent()) {
			
			throw new LoginException("Admin already Logged In with this number");
			
		}
		
		if(existingAdmin.getAdminPassword().equals(dto.getPassword())) {
			
			String key= RandomString.make(6);
			
			CurrentAdminSession currentAdminSession = new CurrentAdminSession(existingAdmin.getAdminId(),key,LocalDateTime.now());
			
			asDao.save(currentAdminSession);

			return currentAdminSession.toString();
		}
		else
			throw new LoginException("Please Enter a valid password");
	}


	@Override
	public String logOutFromAdminAccount(String key) throws LoginException {
		CurrentAdminSession validAdminSession = asDao.findByUuid(key);
		
		if(validAdminSession == null) {
			throw new LoginException("Admin Not Logged In with this number");
		}
		
		asDao.delete(validAdminSession);
		
		return "Logged Out !";
	}

}
