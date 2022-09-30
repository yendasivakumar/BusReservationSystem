package com.masai.model;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Reservation {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer no_of_reservation;
	private String reservationStatus;
	private String reservationType;
	private LocalDate reservationDate;
	private LocalTime reservationTime;
	private String source;
	private String destination;
	public int getNo_of_reservation() {
		return no_of_reservation;
	}
	public void setNo_of_reservation(int no_of_reservation) {
		this.no_of_reservation = no_of_reservation;
	}
	public String getReservationStatus() {
		return reservationStatus;
	}
	public void setReservationStatus(String reservationStatus) {
		this.reservationStatus = reservationStatus;
	}
	public String getReservationType() {
		return reservationType;
	}
	public void setReservationType(String reservationType) {
		this.reservationType = reservationType;
	}
	public LocalDate getReservationDate() {
		return reservationDate;
	}
	public void setReservationDate(LocalDate reservationDate) {
		this.reservationDate = reservationDate;
	}
	public LocalTime getReservationTime() {
		return reservationTime;
	}
	public void setReservationTime(LocalTime reservationTime) {
		this.reservationTime = reservationTime;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}

	

}
