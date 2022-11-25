package com.masai.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exceptions.AdminException;
import com.masai.exceptions.UserException;
import com.masai.model.CurrentAdminSession;
import com.masai.model.CurrentUserSession;
import com.masai.model.User;
import com.masai.repository.AdminDao;
import com.masai.repository.CurrentAdminSessionDao;
import com.masai.repository.CurrentUserSessionDao;
import com.masai.repository.UserDao;

@Service
public class UserServiceImpl  implements UserService {
	@Autowired
	private UserDao userDao ;
	
	@Autowired
	private CurrentUserSessionDao usDao;
	
	@Autowired
	private AdminDao aDao;
	
	@Autowired
	private CurrentAdminSessionDao sDao;

	@Override
	public User addUser(User user,String key) throws UserException  {
		CurrentAdminSession loggedInAdmin= sDao.findByUuid(key);
		
		if(loggedInAdmin == null) {
			throw new AdminException("Please check key, No Admin loggedIn with given key");
		}
		else {
			User opt= userDao.findByContact(user.getContact()) ;
//			if(user.getUserLoginId() != loggedInUser.getUserId()) {
//				throw new UserException("Invalid user details, Please Login first ");
//			}
			if(opt != null) {
				throw new UserException("User already Present!") ;
			}
			else {
				return userDao.save(user) ;
			}
		}
	}

	@Override
	public User updateUser(User user,String key) throws UserException {
		CurrentUserSession loggedInUser= usDao.findByUuid(key);
		
		if(loggedInUser == null) {
			throw new UserException("Please provide a valid key");
		}
		
		Optional<User> opt=  userDao.findById(user.getUserLoginId()) ;
		
		if(opt.get().getUserLoginId() != loggedInUser.getUserId()) {
			throw new UserException("Invalid user details, Please Login first ");
		}
		if(opt.isPresent()) {
			return userDao.save(user) ;
		}else {
			throw new UserException("First Register The User, User Id Not Found!") ;
		}
		
	}

	@Override
	public User deleteUser(int userId,String key) throws UserException {
		CurrentAdminSession loggedInAdmin= sDao.findByUuid(key);
		
		if(loggedInAdmin == null) {
			throw new AdminException("Please check key, No Admin loggedIn with given key");
		}
		
		Optional<User> opt=  userDao.findById(userId) ;
//		if(opt.get().getUserLoginId() != loggedInUser.getUserId()) {
//			throw new UserException("Invalid user details, Please Login first ");
//		}
		
		if(opt.isPresent()) {
			 userDao.deleteById(userId); ;
			 return opt.get() ;
		}else {
			throw new UserException("User Not Found!") ;
		}
		
	}

	@Override
	public User viewUser(int userId) throws UserException {
		Optional<User> opt=  userDao.findById(userId) ;
		
		if(opt.isPresent()) {
			 return opt.get() ;
		}else {
			throw new UserException("User id is not correct!") ;
		}
	}

	@Override
	public List<User> viewAllUsers() throws UserException {
		List<User> allUsers =  userDao.findAll() ;
		
		if(allUsers.size() != 0) {
			 return allUsers ;
		}else {
			throw new UserException("No user found.... Database Empty!") ;
		}
	}

	
}
