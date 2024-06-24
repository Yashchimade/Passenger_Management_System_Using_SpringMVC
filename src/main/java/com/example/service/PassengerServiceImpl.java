package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.dao.PassengerDAO;
import com.example.model.Passenger;

@Service
@Transactional
public class PassengerServiceImpl implements PassengerService {

	@Autowired
	private PassengerDAO passengerDAO;

	@Override
	public void addPassenger(Passenger passenger) {
		passengerDAO.addPassenger(passenger);

	}

	@Override
	public List<Passenger> getAllPassengers() {

		return passengerDAO.getAllPassengers();
	}

	@Override
	public Passenger getPassengerById(Long id) {

		return passengerDAO.getPassengerById(id);
	}

	@Override
	public void updatePassenger(Passenger passenger) {
		passengerDAO.updatePassenger(passenger);

	}

	@Override
	public void deletePassenger(Long id) {
		passengerDAO.deletePassenger(id);

	}

}