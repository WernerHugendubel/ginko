package it.unibz.internet.dao;

import it.unibz.internet.domain.Dish;
import it.unibz.internet.domain.DishRating;
import it.unibz.internet.domain.Order;
import it.unibz.internet.domain.Patient;
import it.unibz.internet.domain.Restriction;

import java.util.List;

/**
 * Interface for Data access Objects
 * @author Werner Frei <freiwe@gmail.com>
 *
 */
public interface Dao {

    /**
     * Retrieves a dish by the index
     *
     * @param dishId the index of the dish
     * @return the dish identified by id
     */
    public Dish getDish(int dishId);

    /**
     * Retrieves a List of all dishes in the Database
     *
     * @return the List of all dishes
     */
	public abstract List<Dish> getDishs();

    /**
     * Retrieves a Order
     *
     * @param orderId the id of the Order to search
     * @return the order identified by orderId
     */
	public abstract Order getOrder(int orderId);

	/**
	 * @param patientId the id of the patient
	 * @return list of orders for patient with id patientId
	 */
	public abstract List<Order> getOrderList(int patientId);

	/**
	 * Inserts a new order in the storage
	 * @param o the new order to insert
	 */
	public abstract void insertOrder(Order o);
	
	/** 
	 * Updates the details (ordered dishes) for order 
	 * @param o the order to process
	 * @return true if ok, false otherwise
	 */
	public abstract boolean updateOrderDetails(Order o);

    /**
     * Insert a new patient in the DB
     * @param patient the patient to insert
     */
	public abstract void addNew(Patient patient);

	
	/**
	 * Delete a patient from the storage
	 * @param patientId the id for the patient to be deleted
	 */
	public abstract void deletePatientById(int patientId);

	/**
	 * Updates information for patient 
	 * @param patient the patient to be updated
	 */
	public abstract void updatePatient(Patient patient);

    /**
     * Retrieves a patient by ID
     *
     * @param patientId the id to search
     * @return the Patient identified by id
     */
	public abstract Patient getPatient(int patientId);

	/**
     * Retrieves a List of all patients in the Database
     *
     * @return the list of all patients
     */
	public abstract List<Patient> getPatients();

	/**
	 * Retrieves a restriction by given id
	 * @param restrictionId the id of the restriction
	 * @return the restriction
	 */
	public abstract Restriction getRestriction(int restrictionId);

	/**
	 * Get a list of all restrictions
	 * @return a list of all restrictions
	 */
	public abstract List<Restriction> getRestrictions();

	/**
	 * @return a list of all dishes with their average rating
	 */
	public List<DishRating> getDishWithAvgRating();

}