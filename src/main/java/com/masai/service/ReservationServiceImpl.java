package com.masai.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.model.Reservation;
import com.masai.repository.ReservationDao;
@Service
public class ReservationServiceImpl implements ReservationService {
	@Autowired
	private ReservationDao dao;

	@Override
	public Reservation saveReservation(Reservation reservation) {
	Reservation saveReservation = dao.save(reservation);
	
       return saveReservation;
}
	
}
