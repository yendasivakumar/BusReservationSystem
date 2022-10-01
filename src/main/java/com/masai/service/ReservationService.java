package com.masai.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.masai.exceptions.ReservationException;

import com.masai.model.Reservation;

import com.masai.repository.ReservationDao;

public interface ReservationService {

	
	
	public Reservation addReservation(Reservation reservation);
	
	public Reservation viewReservation(Integer reservationId) throws ReservationException ;
	
	public List<Reservation> viewAllReservation() throws ReservationException ;
	
	
	public Reservation deleteReservation(Integer reservationId)throws ReservationException;
	
	public Reservation updateReservation(Reservation reservation)throws ReservationException;
	
	
}
