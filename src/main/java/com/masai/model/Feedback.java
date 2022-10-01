package com.masai.model;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatTypes;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonValueFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;





@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Feedback {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer feedBackId;
	
//	@Pattern(regexp = "[1-5]{1}",message = "Driver rating should be in between 1 to 5")
	private Integer driverRating;
	
//	@Pattern(regexp = "[1-5]{1}",message = "Service rating should be in between 1 to 5")
	private Integer serviceRating;
	
//	@Pattern(regexp = "[1-5]{1}",message = "Overall rating should be in between 1 to 5")
	private Integer overallRating;
	
	private String comments;
	
//	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
//	private LocalDateTime feebackDate;
//	
//	@OneToOne(cascade = CascadeType.ALL)
////	private User users;
	
	@OneToOne
	@JoinColumn(name="bus_id",referencedColumnName = "busId")
	private Bus bus;
	
	public Integer getFeedBackId() {
		return feedBackId;
	}
	public void setFeedBackId(Integer feedBackId) {
		this.feedBackId = feedBackId;
	}
	public Integer getDriverRating() {
		return driverRating;
	}
	public void setDriverRating(Integer driverRating) {
		this.driverRating = driverRating;
	}
	public Integer getServiceRating() {
		return serviceRating;
	}
	public void setServiceRating(Integer serviceRating) {
		this.serviceRating = serviceRating;
	}
	public Integer getOverallRating() {
		return overallRating;
	}
	public void setOverallRating(Integer overallRating) {
		this.overallRating = overallRating;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
//	public LocalDateTime getFeebackDate() {
//		return feebackDate;
//	}
//	public void setFeebackDate(LocalDateTime feebackDate) {
//		this.feebackDate = feebackDate;
//	}
//	public User getUsers() {
//		return users;
//	}
//	public void setUsers(User users) {
//		this.users = users;
//	}
	public Bus getBus() {
		return bus;
	}
	public void setBus(Bus bus) {
		this.bus = bus;
	}
	
}
