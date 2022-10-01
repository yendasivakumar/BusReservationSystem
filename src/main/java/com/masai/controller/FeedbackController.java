package com.masai.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.model.Feedback;
import com.masai.service.BusService;
import com.masai.service.FeedbackService;
import com.masai.service.UserService;

@RestController
public class FeedbackController {
	
	@Autowired
	private FeedbackService fService;
	
	@Autowired
	private BusService bService;
	
	@Autowired
	private UserService uService;
	
	@PostMapping("/addFeedback/{userId}/{busId}")
	public ResponseEntity<Feedback> createBus(@Valid @RequestBody Feedback feedback, @PathVariable("userId") Integer uId, @PathVariable("busId") Integer bId) {
		return new ResponseEntity<Feedback>(fService.addFeedback(feedback, bId, uId),HttpStatus.CREATED);
//		http://localhost:8080/addFeedback/userId/busId
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
