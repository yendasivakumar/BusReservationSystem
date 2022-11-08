package com.masai.service;

import java.util.List;

import com.masai.exceptions.ReservationException;
import com.masai.model.Reservation;

public interface ReservationService {
	public Reservation addReservation(Reservation reservation,int userId,String key) throws ReservationException;
	public Reservation updateReservation(Reservation reservation, int userId,String key) throws ReservationException;
	public Reservation deleteReservation(int reservationId, int userId,String key) throws ReservationException;
	public Reservation viewReservation(int reservationId) throws ReservationException;
	public List<Reservation> viewAllReservation(String key) throws ReservationException;
//	public List<Reservation> getAllReservation(LocalDate date) throws ReservationException;
	
}
