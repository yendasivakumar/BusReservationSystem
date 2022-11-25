package com.masai.controller;

import java.time.LocalTime;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.masai.exceptions.ReservationException;
import com.masai.model.Reservation;
import com.masai.service.ReservationService;

@RestController
public class ReservationController {
	@Autowired
	private ReservationService reservationservice ;
	
	@PostMapping("/reservation/{userId}")
	public ResponseEntity<Reservation> addReservationHandler(@PathVariable("userId") Integer userId,@RequestParam(required = false) String key,@RequestBody Reservation reservation) throws ReservationException {
		reservation.setReservationTime(LocalTime.now());
	Reservation saveReservation = 	reservationservice.addReservation(reservation,userId,key);
		
	return new ResponseEntity<Reservation>(saveReservation,HttpStatus.CREATED);
		
	}
	
	@GetMapping("/reservation/{reservationId}")
     public ResponseEntity<Reservation>	getReservationByreservationIdHandler(@PathVariable("reservationId") Integer reservationId) throws ReservationException{
		
		Reservation reservation = reservationservice.viewReservation(reservationId);
		
		return new ResponseEntity<Reservation>(reservation,HttpStatus.OK);
	}
	
	
	@GetMapping("reservations")
	public ResponseEntity<List<Reservation>> viewAllReservationHandler(@RequestParam String key) throws ReservationException{
		
		List<Reservation> reservations = reservationservice.viewAllReservation(key);
		
		return new ResponseEntity<List<Reservation>>(reservations,HttpStatus.OK);
	}
	
	
	@DeleteMapping("/reservation/{userId}/{reservationId}")
	public ResponseEntity<Reservation> deleteReservationByRollHandler(@PathVariable("userId") Integer userId, @PathVariable("reservationId") Integer reservationId,@RequestParam(required = false) String key) throws ReservationException{
		
		Reservation reservation= reservationservice.deleteReservation(reservationId,userId,key);
		
		return new ResponseEntity<Reservation>(reservation,HttpStatus.OK);
		
	}
	
	@PutMapping("/reservation/{userId}")
	public ResponseEntity<Reservation> updateReservationHandler(@PathVariable("userId") Integer userId,@RequestParam(required = false) String key, @RequestBody Reservation reservation) throws ReservationException{
		reservation.setReservationTime(LocalTime.now());
		Reservation updatedReservation= reservationservice.updateReservation(reservation,userId,key);
		return new ResponseEntity<Reservation>(updatedReservation,HttpStatus.OK);
		
	}
    
}

//request body
//{
//"reservationStatus": "reserved",
//"reservationType": "Vip",
//"reservationDate": "2022-11-04",
//"reservationTime": "08:30:00",
//"source": "Hyd",
//"destination": "Vizag"
//}




