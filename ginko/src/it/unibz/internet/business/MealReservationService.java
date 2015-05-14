package it.unibz.internet.business;

import it.unibz.internet.dao.Dao;
import it.unibz.internet.dao.DaoImpl;
import it.unibz.internet.domain.Dish;
import it.unibz.internet.domain.DishRating;
import it.unibz.internet.domain.Order;
import it.unibz.internet.domain.Patient;
import it.unibz.internet.domain.Restriction;

import java.util.ArrayList;
import java.util.List;

/**
 * Business logic for Meal Reservation
 * @author Werner Frei <freiwe@gmail.com>
 *
 */
public class MealReservationService {

	Dao dao;

	/**
	 * Constructor
	 */
	public MealReservationService() {
		// TODO: retrieve DAO implementation through factory class
		dao = new DaoImpl();
	}

	
	/**
	 * Returns a list of patients
	 * @return list of patients
	 */
	public List<Patient> getPatients() {
		return dao.getPatients();
	}

	/**
	 * Add a new patient 
	 * @param patname name of the patient
	 * @param patientbednr bednr the patient is in 
	 */
	public void addPatient(String patname, int patientbednr) {
		Patient pat = new Patient();
		pat.setName(patname);
		pat.setBednr(patientbednr);

		// TODO: Business logic: check patient constraints before save
		// save to db
		this.dao.addNew(pat);
	}

	/**
	 * Get a patient by their id
	 * @param patientId the id of the patient
	 * @return the patient
	 */
	public Patient getPatient(int patientId) {
		return this.dao.getPatient(patientId);
	}

	/**
	 * Update a patient with given parameters
	 * @param patientid id of the patient
	 * @param patname name of the patient
	 * @param patientbednr bednr the patient is in 
	 */
	public void updatePatient(int patientid, String patname, int patientbednr) {
		Patient pat = this.dao.getPatient(patientid);
		pat.setName(patname);
		pat.setBednr(patientbednr);

		// TODO: Business logic: check patient constraints before save
		// save to db
		this.dao.updatePatient(pat);
	}

	/**
	 * Get a list of orders for a single patient 
	 * @param patientId the id of the patient
	 * @return list of orders
	 */
	public List<Order> getOrderList(int patientId) {
		return this.dao.getOrderList(patientId);
	}

	/**
	 * Retrieve an order by id
	 * @param orderId the id of the order to retrieve
	 * @return the order with id orderId
	 */
	public Order getOrder(int orderId) {
		return this.dao.getOrder(orderId);
	}

	/**
	 * List all dishes available
	 * @return a list of all available dishes
	 */
	public List<Dish> getDishs() {
		//TODO: order by rating 
		return this.dao.getDishs();
	}

	/**
	 * Get dish List by rating: first already selected meals ordered by avg rating, then the not yet selected dishes
	 * 
	 * @return lisf of ordered dishes
	 */
	public List<Dish> getDishsRated(){
		//TODO: order by rating 
		//get List of all in the past selected dishes with average rating
		//get list of all dishes
		List<Dish> alldishes = this.dao.getDishs();
		ArrayList<Dish> ordereddishes = new ArrayList<>();
		List<DishRating> rateddishes = this.dao.getDishWithAvgRating();
		for(DishRating dr:rateddishes){
			ordereddishes.add(dr.getDish());
			alldishes.remove(dr.getDish());
		}
		//add the dishes by 
		ordereddishes.addAll(alldishes);
		
		return ordereddishes;		
	}
	/**
	 * Find a dish by id
	 * @param dishId the id of the dish to search
	 * @return the dish 
	 */
	public Dish getDish(int dishId) {
		return this.dao.getDish(dishId);
	}

	/**
	 * Add a dish to an order 
	 * @param orderId id of the order where we insert dish
	 * @param dishId the id of the dish to insert
	 * @throws Exception if dish is already present in order or if rating present
	 */
	public void addDishToOrder(int orderId, int dishId) throws Exception {
		Dish d = this.getDish(dishId);
		DishRating dr = new DishRating(d,0);
		Order o = this.getOrder(orderId);
		Patient p = this.getPatient(o.getPatientId());

		//Check if ratings are already present if yes throw exception
		if (o.hasRatings())
			throw new Exception("Dish cannot be added or removed, rating already present");

		//Check if dish falls in restriction
		List<Restriction> restrictions = p.getRestrictions();
		for (Restriction r : restrictions) {
			if (r.getDishs().contains(d)){
				throw new Exception("Dish not allowed");
			}
		}

		//Check if dish is already present
		if(o.getSelectedDishs().contains(d))
			throw new Exception("Dish already selected");
		
		//all ok, add to list of dishes of the order
		List<DishRating> l = o.getDishRatings();
		l.add(dr); 
		o.setDishRatings(l);
		// Write order details to DB
		this.dao.updateOrderDetails(o);
	}

	/**
	 * Removes a dish from an order
	 * @param orderId id of the order
	 * @param dishId id of the dish to remove
	 * @throws Exception 
	 */
	public void removeDishFromOrder(int orderId, int dishId) throws Exception {
		Dish d = this.getDish(dishId);
		DishRating dishRating = new DishRating(d, 0);
		
		Order o = this.getOrder(orderId);
		if (o.hasRatings())
			throw new Exception("Dish cannot be removed, rating already present");
				
		//ok, remove dish
		List<DishRating> l = o.getDishRatings();

		l.remove(dishRating);
		o.setDishRatings(l);
		this.dao.updateOrderDetails(o);
	}
	
	
	/**
	 * Sets the rating of a dish in a specified order
	 * @param orderId the orderid
	 * @param dishId the dishid 
	 * @param rating rating of the dish 0 not rated > 1 rating
	 */
	public void setDishRating(int orderId, int dishId, int rating){
		Order o=this.getOrder(orderId);
		List<DishRating>drl= o.getDishRatings();
		for(DishRating dr: drl){
			if (dr.getDish().getDishId()==dishId)
				dr.setRating(rating);
		}
		
		this.dao.updateOrderDetails(o);
	}

}
