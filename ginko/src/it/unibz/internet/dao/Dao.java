package it.unibz.internet.dao;

import it.unibz.internet.domain.Dish;
import it.unibz.internet.domain.Order;
import it.unibz.internet.domain.Patient;
import it.unibz.internet.domain.Restriction;

import java.util.List;

public interface Dao {

	public abstract Dish getDish(int id);

	public abstract List<Dish> getDishs();

	public abstract Order getOrder(int orderId);

	public abstract List<Order> getOrderList(int patientId);

	public abstract boolean updateOrderDetails(Order o);

	public abstract void addNew(Patient pat);

	public abstract void deletePatientById(int id);

	public abstract void updatePatient(Patient p);

	public abstract Patient getPatient(int id);

	public abstract List<Patient> getPatients();

	public abstract Restriction getRestriction(int id);

	public abstract List<Restriction> getRestrictions();

}