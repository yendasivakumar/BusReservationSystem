package com.masai.model;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.Pattern;


@Entity
public class Feedback {
	@Id
	private Integer feedBackId;
	
	@Pattern(regexp = "[1-5]{1}",message = "Driver rating should be in between 1 to 5")
	private Integer driverRating;
	
	@Pattern(regexp = "[1-5]{1}",message = "Service rating should be in between 1 to 5")
	private Integer serviceRating;
	
	@Pattern(regexp = "[1-5]{1}",message = "Overall rating should be in between 1 to 5")
	private Integer overallRating;
	
	private String comments;
	
	
	private LocalDateTime feebackDate;
	
	@OneToOne(cascade = CascadeType.ALL)
	private User users;
	
	@OneToOne(cascade = CascadeType.ALL)
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
	public LocalDateTime getFeebackDate() {
		return feebackDate;
	}
	public void setFeebackDate(LocalDateTime feebackDate) {
		this.feebackDate = feebackDate;
	}
	public User getUsers() {
		return users;
	}
	public void setUsers(User users) {
		this.users = users;
	}
	public Bus getBus() {
		return bus;
	}
	public void setBus(Bus bus) {
		this.bus = bus;
	}
	
}
