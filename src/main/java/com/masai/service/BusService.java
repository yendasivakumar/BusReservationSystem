package com.masai.service;

import java.util.List;

import com.masai.exceptions.BusException;
import com.masai.exceptions.RouteException;
import com.masai.model.Bus;

public interface BusService {
	public Bus addBus(Bus bus,String key) throws BusException, RouteException;
	public Bus updateBus(Bus bus,String key) throws BusException;
	public Bus deleteBus(int busId,String key) throws BusException;
	public Bus viewBus(int busId) throws BusException;
	public List<Bus> viewBusByType(String busType) throws BusException;
	public List<Bus> viewAllBus() throws BusException;
	
	
}
