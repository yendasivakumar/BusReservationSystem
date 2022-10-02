package com.masai.controller;

import java.time.LocalDateTime;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.masai.exceptions.FeedBackException;
import com.masai.model.Feedback;
import com.masai.service.BusService;
import com.masai.service.FeedbackService;
import com.masai.service.UserService;

@RestController
public class FeedbackController {

	@Autowired
	private FeedbackService feedbackService;

	
	@PostMapping("/feedback/{userId}/{busId}")
	public ResponseEntity<Feedback> registerFeedback(@Valid @RequestBody Feedback feedback, @PathVariable("userId") Integer uId, @PathVariable("busId") Integer bId,@RequestParam(required = false) String key ) throws FeedBackException{
		feedback.setFeedbackdatetime(LocalDateTime.now());
		return new ResponseEntity<Feedback>(feedbackService.addFeedback(feedback, bId, uId,key),HttpStatus.CREATED);
	}
	
	@PutMapping("/feedback")
	public ResponseEntity<Feedback> updateFeedback(@Valid @RequestBody Feedback feedback,@RequestParam(required = false) String key ) throws FeedBackException{
		feedback.setFeedbackdatetime(LocalDateTime.now());
		return new ResponseEntity<Feedback>(feedbackService.updateFeedback(feedback,key),HttpStatus.OK);
		
			
	}
	
	@GetMapping("/feedback/{id}")
	public ResponseEntity<Feedback> getFeedback(@PathVariable("id") Integer feedbackId) throws FeedBackException{
		return new ResponseEntity<Feedback>(feedbackService.viewFeedback(feedbackId),HttpStatus.OK);
		
	}
	
	@GetMapping("/feedbacks")
	public ResponseEntity<List<Feedback>> getAllFeedback() throws FeedBackException{
		List<Feedback> feedbackList = feedbackService.viewAllFeedback();
		return new ResponseEntity<List<Feedback>>(feedbackList,HttpStatus.OK);
	}

}

//RequestBody
//{
//"driverRating":6,
//"serviceRating": 3,
//"overallRating": 5,
//"comments": "Can Improve",
//"feedbackdate": "2022-11-03",
//}
