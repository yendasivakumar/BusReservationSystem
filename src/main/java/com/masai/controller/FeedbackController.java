package com.masai.controller;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.masai.model.Feedback;
import com.masai.service.FeedbackService;

@RestController
public class FeedbackController {
		
	@Autowired
	private FeedbackService feedbackService;
	
	@PostMapping("/feedback")
	public Feedback addFeedbackHandler(@RequestBody Feedback feedback) {
		
//		feedback.setFeebackDate(LocalDateTime.now());
		Feedback fb = feedbackService.addFeedback(feedback);
		System.out.println(fb);
		return fb;
	}
	@GetMapping("/fb")
	public ResponseEntity<Feedback> getFeedback(@RequestParam("id") Integer id ) {
		Feedback fb = feedbackService.getFeebFeedback(id);
		return new ResponseEntity<Feedback>(fb,HttpStatus.OK);
	}
}
