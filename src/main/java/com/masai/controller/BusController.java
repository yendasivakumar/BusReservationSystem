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
import com.masai.model.Bus;
import com.masai.service.BusService;

@RestController
public class BusController {
	
	@Autowired
	private BusService bService;
	
	@PostMapping("/addBus")
	public ResponseEntity<Bus> createBus(@Valid @RequestBody Bus bus) {
		return new ResponseEntity<Bus>(bService.addBus(bus),HttpStatus.CREATED);
//		http://localhost:8080/addBus
	}
	
	@PutMapping("/updateBus")
	public ResponseEntity<Bus> updateIt(@Valid @RequestBody Bus bus){
		return new ResponseEntity<Bus>(bService.updateBus(bus),HttpStatus.ACCEPTED);
//		http://localhost:8080/updateBus
	}
	
	@DeleteMapping("deleteBus/{busId}")
	public ResponseEntity<Bus> deleteIt(@PathVariable("busId") Integer Id){
		return new ResponseEntity<Bus>(bService.deleteBus(Id), HttpStatus.OK);
//		http://localhost:8080/deleteBus/3
	}
	
	@GetMapping("bus/{busId}")
	public ResponseEntity<Bus> viewItbyId(@PathVariable("busId") Integer Id){
		return new ResponseEntity<Bus>(bService.viewBus(Id), HttpStatus.FOUND);
//		http://localhost:8080/bus/3
	}
	
	@GetMapping("busByType/{busType}")
	public ResponseEntity<List<Bus>> viewItbyType(@PathVariable("busType") String type){
		return new ResponseEntity<List<Bus>>(bService.viewBusByType(type), HttpStatus.FOUND);
//		http://localhost:8080/busByType/Express
	}
	
	@GetMapping("buses")
	public ResponseEntity<List<Bus>> viewAll(){
		return new ResponseEntity<List<Bus>>(bService.viewAllBus(), HttpStatus.OK);
//		http://localhost:8080/buses
	}
	
	
	
}

//requestBody
//	{
//	  "busName": "Super",
//	  "driverName": "ram",
//	  "busType": "Ac",
//	  "routeFrom": "Hyd",
//	  "routeTo": "mumbai",
//	  "arrivalTime": "05:15:00",
//	  "departureTime": "03:15:00",
//	  "availableSeats":20,
//	  "seats":25
//	}





