package com.masai.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.model.Route;
import com.masai.service.RouteService;

@RestController
public class RouteController {
	
	@Autowired
	private RouteService rService;
	
	@PostMapping("/addRoute")
	public ResponseEntity<Route> createRoute(@Valid @RequestBody Route route) {
		return new ResponseEntity<Route>(rService.addRoute(route),HttpStatus.CREATED);
//		http://localhost:8080/addRoute
	}
	
	@PutMapping("/updateRoute")
	public ResponseEntity<Route> updateIt(@Valid @RequestBody Route route){
		return new ResponseEntity<Route>(rService.updateRoute(route),HttpStatus.ACCEPTED);
//		http://localhost:8080/updateRoute
	}
	
	@DeleteMapping("deleteRoute/{routeId}")
	public ResponseEntity<Route> deleteIt(@PathVariable("routeId") Integer Id){
		return new ResponseEntity<Route>(rService.deleteRoute(Id), HttpStatus.OK);
//		http://localhost:8080/deleteRoute/3
	}
	
	@GetMapping("route/{routeId}")
	public ResponseEntity<Route> viewItbyId(@PathVariable("routeId") Integer Id){
		return new ResponseEntity<Route>(rService.viewRoute(Id), HttpStatus.FOUND);
//		http://localhost:8080/route/3
	}
	
	
	@GetMapping("routes")
	public ResponseEntity<List<Route>> viewAll(){
		return new ResponseEntity<List<Route>>(rService.viewAllRoute(), HttpStatus.OK);
//		http://localhost:8080/routes
	}
	
}

//requestBody
//{
//  "routeFrom": "chennai",
//  "routeTo": "Hyd",
//  "distance":80,
//	"bus":[
//{
//"busName": "Super",
//"driverName": "vignesh",
//"busType": "Non-Ac",
//"routeFrom": "chennai",
//"routeTo": "Hyd",
//"arrivalTime": "05:15:00",
//"departureTime": "03:15:00",
//"availableSeats":20,
//"seats":25
//}
//{
//"busName": "Delux",
//"driverName": "Babji",
//"busType": "Ac",
//"routeFrom": "chennai",
//"routeTo": "Hyd",
//"arrivalTime": "05:15:00",
//"departureTime": "03:15:00",
//"availableSeats":20,
//"seats":25
//}
//]
//}

