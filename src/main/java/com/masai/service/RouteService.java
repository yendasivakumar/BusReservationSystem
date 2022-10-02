package com.masai.service;

import java.util.List;

import com.masai.exceptions.RouteException;
import com.masai.model.Route;

public interface RouteService {
	public Route addRoute(Route route,String key) throws RouteException;
	public Route updateRoute(Route route,String key) throws RouteException;
	public Route deleteRoute(int routeId,String key) throws RouteException;
	public Route viewRoute(int routeId) throws RouteException;
	public List<Route> viewAllRoute() throws RouteException;
	
	
}
