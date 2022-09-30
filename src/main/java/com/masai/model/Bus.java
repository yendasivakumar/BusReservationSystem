package com.masai.model;

import java.time.LocalTime;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Range;

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
	
//	@NotNull(message = "busName should not be null")
//	@Pattern(regexp="^[a-zA-Z_]+( [a-zA-Z_]+)*$", message = "Bus name should contain only letters")
//	@Size(min=3,max=20, message = "busName should be of size between 3 to 20 charcters")
	private String busName;
	
//	@NotNull(message = "driverName should not be null")
//	@Pattern(regexp="^[a-zA-Z_]+( [a-zA-Z_]+)*$", message = "driverName should contain only letters")
//	@Size(min=3,max=20, message = "busName should be of size between 3 to 20 charcters")
	private String driverName;
	
//	@NotNull(message = "busType should not be null")
//	@Pattern(regexp="^[a-zA-Z_]+( [a-zA-Z_]+)*$", message = "busType should contain only letters")
//	@Size(min=2,max=20, message = "busType should be of size between 2 to 15 charcters")
	private String busType;
	
//	@NotNull(message = "routeFrom should not be null")
//	@Pattern(regexp="^[a-zA-Z_]+( [a-zA-Z_]+)*$", message = "routeFrom should contain only letters")
//	@Size(min=2,max=20, message = "routeFrom should be of size between 3 to 20 charcters")
	private String routeFrom;
	
//	@NotNull(message = "routeTo should not be null")
//	@Pattern(regexp="^[a-zA-Z_]+( [a-zA-Z_]+)*$", message = "routeTo should contain only letters")
//	@Size(min=2,max=20, message = "routeTo should be of size between 3 to 20 charcters")
	private String routeTo;
	

	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "HH:mm:ss[.SSS][.SS][.S]")
	private LocalTime arrivalTime;
	
	
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "HH:mm:ss[.SSS][.SS][.S]")
	private LocalTime departureTime;
	
//	@NotNull(message = "availableSeats should not be null")
//	@Range(min=0,max=30, message = "availableSeats should be of between 0 to 30")
	private Integer availableSeats;
	
//	@NotNull(message = "seats should not be null")
//	@Range(min=15,max=30, message = "seats should be of between 0 to 30")
	private Integer seats;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "route_FK")
	@JsonIgnore
	private Route route;
	
	
}
