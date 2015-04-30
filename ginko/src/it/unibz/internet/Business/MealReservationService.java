package it.unibz.internet.Business;

import it.unibz.internet.dao.DishDAOInterface;
import it.unibz.internet.dao.OrderDAOInterface;
import it.unibz.internet.dao.PatientDAOInterface;
import it.unibz.internet.dao.RestrictionDAOInterface;
import it.unibz.internet.dao.implementation.DishDAO;
import it.unibz.internet.dao.implementation.OrderDAO;
import it.unibz.internet.dao.implementation.PatientDAO;
import it.unibz.internet.dao.implementation.RestrictionDAO;
import it.unibz.internet.domain.Dish;
import it.unibz.internet.domain.Order;
import it.unibz.internet.domain.Patient;
import it.unibz.internet.domain.Restriction;

import java.util.List;

public class MealReservationService {

	PatientDAOInterface patientDAO;
	DishDAOInterface dishDAO;
	OrderDAOInterface orderDAO;
	RestrictionDAOInterface restrictionDAO;

	public MealReservationService() {
		// TODO: retrieve DAO implementation through factory class
		patientDAO = new PatientDAO();
		dishDAO = new DishDAO();
		orderDAO = new OrderDAO();
		restrictionDAO = new RestrictionDAO();
	}

	public List<Patient> getPatients() {
		return patientDAO.getPatients();
	}

	public boolean addPatient(String patname, int patientbednr) {
		Patient pat = new Patient();
		pat.setName(patname);
		pat.setBednr(patientbednr);

		// TODO: Business logic: check patient constraints before save
		// save to db
		this.patientDAO.addNew(pat);
		return true;
	}

	public Patient getPatient(int id) {
		return this.patientDAO.getPatient(id);
	}

	public void updatePatient(int patientid, String patname, int patientbednr) {
		Patient pat = this.patientDAO.getPatient(patientid);
		pat.setName(patname);
		pat.setBednr(patientbednr);

		// TODO: Business logic: check patient constraints before save
		// save to db
		this.patientDAO.update(pat);
	}

	public List<Order> getOrderList(int patientId) {
		return this.orderDAO.getOrderList(patientId);
	}

	public Order getOrder(int orderId) {
		return this.orderDAO.getOrder(orderId);
	}

	public List<Dish> getDishs() {
		return this.dishDAO.getDishs();
	}

	public Dish getDish(int dishId) {
		return this.dishDAO.getDish(dishId);
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
		this.orderDAO.writeOrderDetails(o);
	}

	public void removeDishFromOrder(int orderId, int dishId) {
		Dish d = this.getDish(dishId);
		Order o = this.getOrder(orderId);
		List<Dish> l = o.getDishs();
		l.remove(d);
		o.setDishs(l);
		this.orderDAO.writeOrderDetails(o);
	}

}
