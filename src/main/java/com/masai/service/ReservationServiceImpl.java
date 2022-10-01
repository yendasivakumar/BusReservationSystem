package com.masai.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exceptions.BusException;
import com.masai.exceptions.ReservationException;
import com.masai.exceptions.UserException;
import com.masai.model.Bus;
import com.masai.model.Reservation;
import com.masai.model.ReservationStatus;
import com.masai.model.User;
import com.masai.repository.BusDao;
import com.masai.repository.ReservationDao;
import com.masai.repository.UserDao;
@Service
public class ReservationServiceImpl implements ReservationService {
	@Autowired
	private ReservationDao reservationdao;
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private BusDao busDao;

	@Override
	public Reservation addReservation(Reservation reservation, int userId) {
		Reservation r = null;
		
		Optional<User> userOpt = userDao.findById(userId);
		List<Bus> busList = busDao.findByRouteFromAndRouteTo(reservation.getSource(), reservation.getDestination());
		
		if(userOpt.isEmpty()) {
			throw new UserException("Invalid user Id");
		}
		else if(busList.size()==0){
			throw new BusException("Sorry No buses present in that route to reserve");
		}
		else {
			for(Bus b : busList) {
				if(b.getAvailableSeats()>0) {
					b.setAvailableSeats(b.getAvailableSeats()-reservation.getNo_of_reservation());
					User u = userOpt.get();
					reservation.setBus(b);
					reservation.setReservationStatus(ReservationStatus.BOOKED.name());
					u.setReservation(reservation);
					r = reservationdao.save(reservation);
					break;
				}
			}
		}
		
		if(r==null) {
			throw new ReservationException("No seats left to Book... update Failed");
		}
		
		return r;
	}

	@Override
	public Reservation viewReservation(int reservationId) throws ReservationException {
	
	Optional<Reservation>opt= reservationdao.findById(reservationId);
	
	return opt.orElseThrow(()-> new ReservationException("Reserevation does not exit with reservationId "+reservationId));
	}

	@Override
	public List<Reservation> viewAllReservation() throws ReservationException {
	
		List<Reservation> reservation = reservationdao.findAll();
		
		if(reservation.size()>0) {
			return reservation ;
		}
		else
			throw new ReservationException("No reservation Found... DataBase Empty!");
		
	}

	@Override
	public Reservation deleteReservation(int reservationId, int userId) throws ReservationException {
		
		Optional<Reservation> rOpt = reservationdao.findById(reservationId);
		if(rOpt.isPresent()) {
			Reservation r = rOpt.get();
			
//			Optional<Bus> busOpt = busDao.findById(r.getBus());
//			 Bus b = busOpt.get();
			Bus b = r.getBus();
			 b.setAvailableSeats(b.getAvailableSeats()+r.getNo_of_reservation());
			
			r.setReservationStatus(ReservationStatus.CANCELED.name());
			r.setBus(null);
			
			Optional<User> userOpt = userDao.findById(userId);
				User u = userOpt.get();
				u.setReservation(null);
		
			reservationdao.delete(r);
			return r;
		}
		else {
			throw new ReservationException("No reservation found with Id : "+reservationId);
		}
		
	}
	
	@Override
	public Reservation updateReservation(Reservation reservation,int userId) throws ReservationException {
		Reservation r = null;
		
		Optional<User> userOpt = userDao.findById(userId);
		List<Bus> busList = busDao.findByRouteFromAndRouteTo(reservation.getSource(), reservation.getDestination());
		
		if(userOpt.isEmpty()) {
			throw new UserException("Invalid user Id");
		}
		else if(busList.size()==0){
			throw new BusException("Sorry No buses present in that route to reserve");
		}
		else {
			for(Bus b : busList) {
				if(b.getAvailableSeats()>0) {
					b.setAvailableSeats(b.getAvailableSeats()-reservation.getNo_of_reservation());
					User u = userOpt.get();
					reservation.setBus(b);
					reservation.setReservationStatus(ReservationStatus.BOOKED.name());
					u.setReservation(reservation);
					r = reservationdao.save(reservation);
					break;
				}
			}
		}
		
		if(r==null) {
			throw new ReservationException("No seats left to Book... update Failed");
		}
		
		return r;
		
	}

//	@Override
//	public List<Reservation> getAllReservation(LocalDate date) throws ReservationException {
//		// TODO Auto-generated method stub
//		return null;
//	}

	
}
