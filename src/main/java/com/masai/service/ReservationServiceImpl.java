package com.masai.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exceptions.ReservationException;
import com.masai.model.Reservation;
import com.masai.repository.ReservationDao;
@Service
public class ReservationServiceImpl implements ReservationService {
	@Autowired
	private ReservationDao dao;

	@Override
	public Reservation addReservation(Reservation reservation) {
	Reservation saveReservation = dao.save(reservation);
	
       return saveReservation;
	}

	@Override
	public Reservation viewReservation(Integer reservationId) throws ReservationException {
	
	Optional<Reservation>opt= dao.findById(reservationId);
	
	return opt.orElseThrow(()-> new ReservationException("Reserevation does not exit with reservationId "+reservationId));
	}

	@Override
	public List<Reservation> viewAllReservation() throws ReservationException {
	
		List<Reservation> reservation = dao.findAll();
		
		if(reservation.size()>0) {
			return reservation ;
		}
		else
			throw new ReservationException("No reservation Found");
		
	}

	@Override
	public Reservation deleteReservation(Integer reservationId) throws ReservationException {
		Reservation existingReservation= dao.findById(reservationId).orElseThrow(() -> new ReservationException("Reservation does not exist with reservationId "+reservationId));;
		
		dao.delete(existingReservation);
		
		
		return existingReservation;
		
		
	}
	
	@Override
	public Reservation updateReservation(Reservation reservation) throws ReservationException {
		
		Optional<Reservation> opt= dao.findById(reservation.getreservationId());
		
		
		if(opt.isPresent()) {
			
			return dao.save(reservation);
			
			
			
		}
		else
			throw new ReservationException("Invalid Reservation details");
		
		
		
		
		
		
	}

	
}
