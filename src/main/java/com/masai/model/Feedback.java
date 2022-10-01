package com.masai.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;




@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Feedback {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer feedBackId;
	
	@NotNull
//	@Size(min=1,max=5,message = "Rating should be in between 1 to 5")
	private Integer driverRating;
	
	@NotNull
//	@Size(min=1,max=5,message = "Rating should be in between 1 to 5")
	private Integer serviceRating;
	
	@NotNull
//	@Size(min=1,max=5,message = "Rating should be in between 1 to 5")
	private Integer overallRating;
	
	
	private String comments;
	
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDateTime feedbackdatetime;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="user_id")
	private User user;

	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="bus_id")
	private Bus bus;

	

}
