package it.unibz.internet.business;

import it.unibz.internet.dao.Dao;
import it.unibz.internet.dao.DaoImpl;
import it.unibz.internet.domain.Dish;
import it.unibz.internet.domain.Order;
import it.unibz.internet.domain.Patient;
import it.unibz.internet.domain.Restriction;

import java.util.List;

public class MealReservationService {

	Dao dao;

	public MealReservationService() {
		// TODO: retrieve DAO implementation through factory class
		dao = new DaoImpl();
		
	}

	public List<Patient> getPatients() {
		return dao.getPatients();
	}

	public boolean addPatient(String patname, int patientbednr) {
		Patient pat = new Patient();
		pat.setName(patname);
		pat.setBednr(patientbednr);

		// TODO: Business logic: check patient constraints before save
		// save to db
		this.dao.addNew(pat);
		return true;
	}

	public Patient getPatient(int id) {
		return this.dao.getPatient(id);
	}

	public void updatePatient(int patientid, String patname, int patientbednr) {
		Patient pat = this.dao.getPatient(patientid);
		pat.setName(patname);
		pat.setBednr(patientbednr);

		// TODO: Business logic: check patient constraints before save
		// save to db
		this.dao.updatePatient(pat);
	}

	public List<Order> getOrderList(int patientId) {
		return this.dao.getOrderList(patientId);
	}

	public Order getOrder(int orderId) {
		return this.dao.getOrder(orderId);
	}

	public List<Dish> getDishs() {
		return this.dao.getDishs();
	}

	public Dish getDish(int dishId) {
		return this.dao.getDish(dishId);
	}

	public void addDishToOrder(int orderId, int dishId) throws Exception {
		Dish d = this.getDish(dishId);
		Order o = this.getOrder(orderId);
		Patient p = this.getPatient(o.getPatientId());
		
		//Check if dish falls in restriction
		List<Restriction> restrictions = p.getRestrictions();
		for (Restriction r : restrictions) {
			if (r.getDishs().contains(d)){
				throw new Exception("Dish not allowed");
			}
		}

		//all ok, add to list of dishes of the order
		List<Dish> l = o.getDishs();
		l.add(d); 
		o.setDishs(l);
		// Write order details to DB
		this.dao.updateOrderDetails(o);
	}

	public void removeDishFromOrder(int orderId, int dishId) {
		Dish d = this.getDish(dishId);
		Order o = this.getOrder(orderId);
		List<Dish> l = o.getDishs();
		l.remove(d);
		o.setDishs(l);
		this.dao.updateOrderDetails(o);
	}

}
