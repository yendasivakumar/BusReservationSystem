package com.masai.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.masai.model.Bus;

@Repository
public interface BusDao extends JpaRepository<Bus, Integer>{
	
	public Bus findByDriverName(String driverName);
	
	public List<Bus> findByBusType(String busType);
	
	public List<Bus> findByRouteFromAndRouteTo(String routeFrom,String routeTo);
}
