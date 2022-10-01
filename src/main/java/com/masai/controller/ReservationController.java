package com.masai.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.exceptions.ReservationException;
import com.masai.model.Reservation;
import com.masai.service.ReservationService;

@RestController
public class ReservationController {
	

	@Autowired
	private ReservationService reservationservice ;
	
	@PostMapping("/reservation")
	public ResponseEntity<Reservation> addReservationHandler(@RequestBody Reservation reservation) {
		
	Reservation saveReservation = 	reservationservice.addReservation(reservation);
		
	return new ResponseEntity<Reservation>(saveReservation,HttpStatus.CREATED);
		
	}
	
	@GetMapping("/reservation/{reservationId}")
     public ResponseEntity<Reservation>	getReservationByreservationIdHandler(@PathVariable("reservationId") Integer reservationId) throws ReservationException{
		
		Reservation reservation = reservationservice.viewReservation(reservationId);
		
		return new ResponseEntity<Reservation>(reservation,HttpStatus.OK);
	}
	
	
	@GetMapping
	public ResponseEntity<List<Reservation>> viewAllReservationHandler() throws ReservationException{
		
		List<Reservation> reservations = reservationservice.viewAllReservation();
		
		return new ResponseEntity<List<Reservation>>(reservations,HttpStatus.OK);
	}
	
	
	@DeleteMapping("/reservation/{reservationId}")
	public ResponseEntity<Reservation> deleteReservationByRollHandler(@PathVariable("reservationId") Integer reservationId) throws ReservationException{
		
		Reservation reservation= reservationservice.deleteReservation(reservationId);
		
		return new ResponseEntity<Reservation>(reservation,HttpStatus.OK);
		
	}
	
	@PutMapping("/reservation")
	public ResponseEntity<Reservation> updateReservationHandler(@RequestBody Reservation reservation) throws ReservationException{
		
		Reservation updatedReservation= reservationservice.updateReservation(reservation);
		
		
		return new ResponseEntity<Reservation>(updatedReservation,HttpStatus.OK);
		
	}
    
}
