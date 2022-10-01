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
				List<Feedback> givenfeedbacks = feedbackDao.findByUser(userOpt.get());
				
				for(Feedback fb : givenfeedbacks) {
					if(fb.getBus().getBusId() == busId) {
						throw new FeedBackException("Feedback already given... try for other buses");
					}

				}
				
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
			Bus bus = fb.get().getBus();
			User user = fb.get().getUser();
			
			feedback.setBus(bus);
			feedback.setUser(user);

			return  feedbackDao.save(feedback);
		}
		throw new FeedBackException("Feedback does not exist to update");
	}

	@Override
	public Feedback viewFeedback(int feedbackId) throws FeedBackException {
		Optional<Feedback> feedback =  feedbackDao.findById(feedbackId);
		if(feedback.isPresent())
			return feedback.get();
		throw new FeedBackException("Feedback does not exist for id :"+feedbackId);
	}

	@Override
	public List<Feedback> viewAllFeedback() throws FeedBackException {
		List<Feedback> feedbackList =  feedbackDao.findAll();
		if(feedbackList.size() == 0)
			throw new FeedBackException("No feedbacks... Database Empty!");
		return feedbackList;
	}

}
