package com.masai.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exceptions.BusException;
import com.masai.exceptions.FeedBackException;
import com.masai.exceptions.UserException;
import com.masai.model.Bus;
import com.masai.model.Feedback;
import com.masai.model.User;
import com.masai.repository.BusDao;
import com.masai.repository.FeedbackDao;
import com.masai.repository.UserDao;

@Service
public class FeedbackServiceImpl implements FeedbackService{

	@Autowired
	private FeedbackDao fDao;
	
	@Autowired
	private BusDao bDao;
	
	@Autowired
	private UserDao uDao;
	
	@Override
	public Feedback addFeedback(Feedback feedback, Integer busId , Integer userid) throws FeedBackException {
		
		if(feedback!=null) {
			Optional<Bus> busOpt = bDao.findById(busId);
			Optional<User> userOpt = uDao.findById(userid);
			
			if(busOpt.isEmpty()) {
				throw new BusException("No Bus present with given id : "+busId);
			}
			else if(!userOpt.isPresent()) {
				throw new UserException("No User present with given id : "+userid);
			}
			else {
				Bus b = busOpt.get();
				User u = userOpt.get();
				
				feedback.setBus(b);
				feedback.setUser(u);
			}
			
			return fDao.save(feedback);
		}
		else {
			throw new FeedBackException("Null value is not accepted");
		}
	}

	@Override
	public Feedback updateFeedback(Feedback feedback) throws FeedBackException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Feedback viewFeedback(int feedbackId) throws FeedBackException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Feedback> viewAllFeedback() throws FeedBackException {
		// TODO Auto-generated method stub
		return null;
	}

}
