package com.masai.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	@Autowired
	private BusService busService;
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/addFeedback/{userId}/{busId}")
	public ResponseEntity<Feedback> createBus(@Valid @RequestBody Feedback feedback, @PathVariable("userId") Integer uId, @PathVariable("busId") Integer bId) throws FeedBackException{
		return new ResponseEntity<Feedback>(feedbackService.addFeedback(feedback, bId, uId),HttpStatus.CREATED);
		

	}
	
	@PutMapping("/feedback")
	public ResponseEntity<Feedback> updateFeedback(@RequestBody Feedback feedback) throws FeedBackException{
		
		return new ResponseEntity<Feedback>(feedbackService.updateFeedback(feedback),HttpStatus.OK);
		
			
	}
	
	@GetMapping("/feedback/id")
	public ResponseEntity<Feedback> getFeedback(@PathVariable("id") Integer feedbackId) throws FeedBackException{
		return new ResponseEntity<Feedback>(feedbackService.viewFeedback(feedbackId),HttpStatus.OK);
		
	}
	
	@GetMapping("/feedback")
	public ResponseEntity<List<Feedback>> getAllFeedback() throws FeedBackException{
		List<Feedback> feedbackList = feedbackService.viewAllFeedback();
		return new ResponseEntity<List<Feedback>>(feedbackList,HttpStatus.OK);
	}
	
	

}

//RequestMapping
//{
//"driverRating":6,
//"serviceRating": 3,
//"overallRating": 5,
//"comments": "Can Improve",
//"feedbackdate": "2022-11-03",
//}
