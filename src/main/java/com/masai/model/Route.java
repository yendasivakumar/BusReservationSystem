package com.masai.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Range;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Route {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer routeId;
	
//	@NotNull(message = "routeFrom should not be null")
//	@Pattern(regexp="^[a-zA-Z_]+( [a-zA-Z_]+)*$", message = "routeFrom should contain only letters")
//	@Size(min=3,max=20, message = "routeFrom should be of size between 3 to 20 charcters")
	private String routeFrom;
	
//	@NotNull(message = "routeTo should not be null")
//	@Pattern(regexp="^[a-zA-Z_]+( [a-zA-Z_]+)*$", message = "routeTo should contain only letters")
//	@Size(min=3,max=20, message = "routeTo should be of size between 3 to 20 charcters")
	private String routeTo;
	
//	@NotNull(message = "seats should not be null")
//	@Range(min=30,max=300, message = "seats should be of between 0 to 30")
	private Integer distance;
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "route")
	private List<Bus> bus = new ArrayList<>();
	
}
