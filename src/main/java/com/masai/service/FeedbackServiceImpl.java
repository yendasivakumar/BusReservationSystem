package com.masai.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.model.Bus;
import com.masai.model.Feedback;
import com.masai.repository.BusDao;
import com.masai.repository.FeedbackDao;

@Service
public class FeedbackServiceImpl implements FeedbackService {
	
	@Autowired
	private FeedbackDao feedbackDao;
	
	@Autowired
	private BusDao busDao;

	@Override
	public Feedback addFeedback(Feedback feedback) {
		
		System.out.println("impl 01");
		Optional<Bus> bus = busDao.findById(feedback.getBus().getBusId());
		
		if(bus != null)
			return feedbackDao.save(feedback);
		
		return null;
	
	}

	@Override
	public Feedback getFeebFeedback(Integer id) {
		Optional<Feedback> fb =  feedbackDao.findById(id);
		
		return fb.get();
		
	}

}
