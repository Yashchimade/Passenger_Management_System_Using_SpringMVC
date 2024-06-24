package com.example.dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.model.Passenger;

@Repository
public class PassengerDAOImpl implements PassengerDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void addPassenger(Passenger passenger) {
		getCurrentSession().persist(passenger);

	}

	@Override
	public List<Passenger> getAllPassengers() {

		return getCurrentSession().createQuery("from Passenger ORDER BY name DESC", Passenger.class).list();
	}

	@Override
	public Passenger getPassengerById(Long id) {

		return getCurrentSession().get(Passenger.class, id);
	}

	@Override
	public void updatePassenger(Passenger passenger) {
		getCurrentSession().merge(passenger);

	}

	@Override
	public void deletePassenger(Long id) {
		Passenger passenger = getPassengerById(id);
		if (passenger != null) {
			getCurrentSession().remove(passenger);
		}

	}

	private Session getCurrentSession() {

		return sessionFactory.getCurrentSession();
	}

}
