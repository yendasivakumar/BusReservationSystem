package com.masai.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.masai.model.Reservation;
import com.masai.repository.ReservationDao;

public interface ReservationService {

	
	
	public Reservation saveReservation(Reservation reservation);
	
}
