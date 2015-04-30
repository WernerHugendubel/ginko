package it.unibz.internet.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Domain object Order 
 *
 * @author Werner Frei <freiwe@gmail.com>
 */
public class Order implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2163679588426113942L;

	private int orderId;
	private Date orderDate;
    private int patientId;
    private List<Dish> dishs = new ArrayList<Dish>();
    
    /**
     * Parameterless constructor
     */
    public Order() {
    }

    /**
     * Constructor
     * @param orderId the id of the order
     */
    public Order(int orderId) {
        this.orderId = orderId;
    }

    /**
     * Constructor
     * @param orderId id of the order
     * @param orderDate date of the order
     * @param patientId the id of the patient
     * @param dishs the ordered dishes
     */
    public Order(int orderId, Date orderDate, int patientId, List<Dish> dishs) {
        this.orderId = orderId;
        this.orderDate = orderDate;
        this.dishs = dishs;
    }

    /**
     * Getter for property orderId
     * @return the orderId
     */
    public int getOrderId() {
        return this.orderId;
    }

    /**
     * Setter for property orderId
     * @param orderId the orderId to set
     */
    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }
    
    /** Getter for property orderDate
     * @return the orderDate of order
     */
    public Date getOrderDate() {
		return orderDate;
	}

	/**
	 * Setter for property orderDate
	 * @param orderDate the orderDate to set
	 */
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	/**
	 * Getter for property patientId
	 * @return the patientId of the order
	 */
	public int getPatientId() {
		return patientId;
	}

	/**
	 * Setter for property patientId
	 * @param patientId to set
	 */
	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}

    /**
     * Returns the list of dishes an order consists of
     * @return the list of dishes for an order
     */
    public List<Dish> getDishs() {
        return this.dishs;
    }

    /**
     * Sets the list of ordered dishes 
     * @param dishs the dishes to set
     */
    public void setDishs(List<Dish> dishs) {
        this.dishs = dishs;
    }
}