package com.masai.service;

import java.util.List;

import com.masai.exceptions.FeedBackException;
import com.masai.model.Feedback;

public interface FeedbackService {
	
	public Feedback addFeedback(Feedback feedback, Integer busId, Integer userid,String key) throws FeedBackException;
	public Feedback updateFeedback(Feedback feedback,String key) throws FeedBackException;
	public Feedback viewFeedback(int feedbackId) throws FeedBackException;
	public List<Feedback> viewAllFeedback(String adminKey) throws FeedBackException;
	
	
	
}
