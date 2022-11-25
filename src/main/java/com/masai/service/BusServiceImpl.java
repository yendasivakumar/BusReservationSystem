package com.masai.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exceptions.AdminException;
import com.masai.exceptions.BusException;
import com.masai.exceptions.RouteException;
import com.masai.model.Bus;
import com.masai.model.CurrentAdminSession;
import com.masai.model.Route;
import com.masai.repository.AdminDao;
import com.masai.repository.BusDao;
import com.masai.repository.CurrentAdminSessionDao;
import com.masai.repository.RouteDao;

@Service
public class BusServiceImpl implements BusService{
	
	@Autowired
	private BusDao bDao;
	
	@Autowired
	private RouteDao rDao;
	
	@Autowired
	private AdminDao aDao;
	
	@Autowired
	private CurrentAdminSessionDao sDao;

	@Override
	public Bus addBus(Bus bus,String key) throws BusException, RouteException {
		CurrentAdminSession loggedInAdmin= sDao.findByUuid(key);
		if(bus.getSeats() < bus.getAvailableSeats()) {
			throw new BusException("wrong data input. Available seat can not be greater total seat.") ;
		}
		if(loggedInAdmin == null)  throw new AdminException("Looks like admin has not logedin or input key in incorrect, Please check");
		else {
		
			Bus b = bDao.findByDriverName(bus.getDriverName());
			if(b==null) {
				
				Route r = rDao.findByRouteFromAndRouteTo(bus.getRouteFrom(),bus.getRouteTo());
				if(r!=null) {
					List<Bus> list = r.getBus();
					list.add(bus);
					bus.setRoute(r);
				}
				else {
					throw new RouteException("No such route found");
				}
				return bDao.save(bus); 
			}
			else {
				throw new BusException("Bus already exists with given driver name");
			}
		}
	}

	@Override
	public Bus updateBus(Bus bus,String key) throws BusException {
		CurrentAdminSession loggedInAdmin= sDao.findByUuid(key);
		
		if(loggedInAdmin == null) {
			throw new AdminException("Looks like admin has not logedin or input key in incorrect, Please check");
		}
		else {
			Optional<Bus> opt = bDao.findById(bus.getBusId());
			if(opt.isPresent()) {
				Bus existingBus = opt.get();
				
				Route r = rDao.findByRouteFromAndRouteTo(bus.getRouteFrom(),bus.getRouteTo());
				if(r!=null) {
					List<Bus> list = r.getBus();
					list.add(bus);
					bus.setRoute(r);
				}
				else {
					throw new RouteException("No such route found");
				}
				
				bDao.save(bus);
				return existingBus;
			}
			else {
				throw new BusException("No Bus found with given details");
			}
		}
		
	}

	@Override
	public Bus deleteBus(int busId,String key) throws BusException {
CurrentAdminSession loggedInAdmin= sDao.findByUuid(key);
		
		if(loggedInAdmin == null) {
			throw new AdminException("Looks like admin has not logedin or input key in incorrect, Please check");
		}
		else {
			Optional<Bus> opt = bDao.findById(busId);
			if(opt.isPresent()) {
				Bus b = opt.get();
				b.setRoute(null);
				bDao.delete(b);
				return b;
			}
			else {
				throw new BusException("No Bus present with given id : "+busId);
			}
		}
	}

	@Override
	public Bus viewBus(int busId) throws BusException {
		Optional<Bus> opt = bDao.findById(busId);
		if(opt.isPresent()) {
			Bus b = opt.get();
			return b;
		}
		else {
			throw new BusException("No Bus present with id : "+busId);
		}
	}

	@Override
	public List<Bus> viewBusByType(String busType) throws BusException {
		List<Bus> b = bDao.findByBusType(busType);
		if(b.size()>0) {
			return b;
		}
		else {
			throw new BusException("No Bus present with : "+busType);
		}
	}

	@Override
	public List<Bus> viewAllBus() throws BusException {
		List<Bus> b = bDao.findAll();
		if(b.size()>0) {
			return b;
		}
		else {
			throw new BusException("No Bus present");
		}
	}

}
