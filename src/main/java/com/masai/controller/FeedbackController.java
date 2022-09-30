package com.masai.controller;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.masai.model.Feedback;
import com.masai.service.FeedbackService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@ControllerAdvice
public class FeedbackController {
		
	@Autowired
	private FeedbackService feedbackService;
	
	@PostMapping("/feedback")
	public ResponseEntity<Feedback> addFeedbackHandler(@RequestBody Feedback feedback) {
		
		feedback.setFeebackDate(LocalDateTime.now());
		Feedback fb = feedbackService.addFeedback(feedback);
		return new ResponseEntity<Feedback>(fb,HttpStatus.CREATED);
	}
	@GetMapping("/fb")
	public ResponseEntity<Feedback> getFeedback(@RequestParam("id") Integer id ) {
		Feedback fb = feedbackService.getFeebFeedback(id);
		return new ResponseEntity<Feedback>(fb,HttpStatus.OK);
	}
}
