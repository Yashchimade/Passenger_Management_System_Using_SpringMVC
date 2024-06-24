package com.example.service;

import java.util.List;
import com.example.model.Passenger;

public interface PassengerService {
	void addPassenger(Passenger passenger);

	List<Passenger> getAllPassengers();

	Passenger getPassengerById(Long id);

	void updatePassenger(Passenger passenger);

	void deletePassenger(Long id);
}