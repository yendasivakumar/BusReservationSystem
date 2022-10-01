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
	private FeedbackDao feedbackDao;

	
	@Autowired
	private BusDao busDao;
	
	@Autowired
	private UserDao userDao;
	
	@Override
	public Feedback addFeedback(Feedback feedback, Integer busId , Integer userid) throws FeedBackException {
		
		if(feedback!=null) {
			Optional<Bus> busOpt = busDao.findById(busId);
			Optional<User> userOpt = userDao.findById(userid);
			
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
			
			return feedbackDao.save(feedback);
		}
		else {
			throw new FeedBackException("Null value is not accepted");
		}
	}


	public Feedback updateFeedback(Feedback feedback) throws FeedBackException {
		Optional<Feedback> fb =  feedbackDao.findById(feedback.getFeedBackId());
		if(fb.isPresent()) {
			return feedbackDao.save(feedback);
		}
		throw new FeedBackException("Feed not exists");
	}

	@Override
	public Feedback viewFeedback(int feedbackId) throws FeedBackException {
		Optional<Feedback> feedback =  feedbackDao.findById(feedbackId);
		if(feedback.isPresent())
			return feedback.get();
		throw new FeedBackException("Feed does not exists with this id :"+feedbackId);
	}

	@Override
	public List<Feedback> viewAllFeedback() throws FeedBackException {
		List<Feedback> feedbackList =  feedbackDao.findAll();
		if(feedbackList.size() == 0)
			throw new FeedBackException("No feedbacks present");
		return feedbackList;
	}

}
