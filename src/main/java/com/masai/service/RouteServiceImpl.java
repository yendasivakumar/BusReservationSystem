package com.masai.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exceptions.AdminException;
import com.masai.exceptions.RouteException;
import com.masai.model.Bus;
import com.masai.model.CurrentAdminSession;
import com.masai.model.Route;
import com.masai.repository.AdminDao;
import com.masai.repository.BusDao;
import com.masai.repository.CurrentAdminSessionDao;
import com.masai.repository.RouteDao;

@Service
public class RouteServiceImpl implements RouteService{
	
	@Autowired
	private BusDao bDao;
	
	@Autowired
	private RouteDao rDao;
	
	@Autowired
	private AdminDao aDao;
	
	@Autowired
	private CurrentAdminSessionDao sDao;
	
	@Override
	public Route addRoute(Route route,String key) throws RouteException {
		
		CurrentAdminSession loggedInAdmin= sDao.findByUuid(key);
		
		if(loggedInAdmin == null) {
			throw new AdminException("input key in incorrect, Please check");
		}
		else {
			Route r = rDao.findByRouteFromAndRouteTo(route.getRouteFrom(), route.getRouteTo());
			if(r==null) {
				List<Bus> busList = route.getBus();
				System.out.println("Size is : "+busList.size());
				
				for(int i=0;i<busList.size();i++) {
					busList.get(i).setRouteFrom(route.getRouteFrom());
					busList.get(i).setRouteTo(route.getRouteTo());
					busList.get(i).setRoute(route);
					bDao.save(busList.get(i));
				}
				
				return rDao.save(route);
			}
			else {
				throw new RouteException("route already exists");
			}
		}
	}

	@Override
	public Route updateRoute(Route route,String key) throws RouteException {
		CurrentAdminSession loggedInAdmin= sDao.findByUuid(key);
		
		if(loggedInAdmin == null) {
			throw new AdminException("input key in incorrect, Please check");
		}
		else {
		
			Optional<Route> opt = rDao.findById(route.getRouteId());
			if(opt.isPresent()) {
				
				List<Bus> busList = opt.get().getBus();
				
				for(Bus b: busList) {
					b.setRouteFrom(route.getRouteFrom());
					b.setRouteTo(route.getRouteTo());
					
				}
				
				return rDao.save(route);
			}
			else {
				throw new RouteException("No such route present to update");
			}
		}
	}

	@Override
	public Route deleteRoute(int routeId,String key) throws RouteException {
		CurrentAdminSession loggedInAdmin= sDao.findByUuid(key);
		
		if(loggedInAdmin == null) {
			throw new AdminException("input key in incorrect, Please check");
		}
		else {
			Optional<Route> opt = rDao.findById(routeId);
			if(opt.isPresent()) {
				Route existingRoute = opt.get();
				rDao.delete(existingRoute);
				return existingRoute;
			}
			else {
				throw new RouteException("No route present with id : "+routeId);
			}
		}
	}

	@Override
	public Route viewRoute(int routeId) throws RouteException {
		Optional<Route> opt = rDao.findById(routeId);
		if(opt.isPresent()) {
			Route r = opt.get();
			return r;
		}
		else {
			throw new RouteException("No route present with id : "+routeId);
		}
	}

	@Override
	public List<Route> viewAllRoute() throws RouteException {
		List<Route> list = rDao.findAll();
		if(list.size()>0) {
			return list;
		}
		else {
			throw new RouteException("No routes present");
		}
	}

}
