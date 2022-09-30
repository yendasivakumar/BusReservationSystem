package com.masai.model;

import java.time.LocalTime;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.util.RouteMatcher.Route;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Bus {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer busId ;
	
	
	private String busName;
	
	
	private String driverName;
	
	
	private String busType;
	
	
	private String routeFrom;
	
	
	private String routeTo;
	

	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "HH:mm:ss[.SSS][.SS][.S]")
	private LocalTime arrivalTime;
	
	
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "HH:mm:ss[.SSS][.SS][.S]")
	private LocalTime departureTime;
	
	
	private Integer availableSeats;
	
	
	private Integer seats;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "route_FK")
	@JsonIgnore
	private Route route;
	
	
}
