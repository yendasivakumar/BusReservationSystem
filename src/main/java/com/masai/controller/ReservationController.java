package com.masai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.model.Reservation;
import com.masai.service.ReservationService;

@RestController
public class ReservationController {
	

	@Autowired
	private ReservationService reservationservice ;
	
	@PostMapping("/reservation")
	public ResponseEntity<Reservation> registerStudentHandler(@RequestBody Reservation reservation) {
		
	Reservation saveReservation = 	reservationservice.saveReservation(reservation);
		
	return new ResponseEntity<Reservation>(saveReservation,HttpStatus.CREATED);
		
	}
	
}
