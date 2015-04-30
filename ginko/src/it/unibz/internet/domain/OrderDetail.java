package it.unibz.internet.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Domain object OrderDetail.
 *
 * @author Werner Frei <freiwe@gmail.com>
 */
public class OrderDetail implements Serializable{

	private static final long serialVersionUID = -4062255370202018034L;
	private int orderId;
    private List<Dish> dishs = new ArrayList<Dish>();
	private Patient patient;

    
    /**
     * Constructor
     */
    public OrderDetail() {
    }

    /**
     * Constructor
     * @param orderId the id of the order
     * @param patient the patient for the order
     */
    public OrderDetail(int orderId, Patient patient) {
        this.orderId = orderId;
        this.patient = patient;
    }

    /**
     * Constructor
     * @param orderId the id of the order
     * @param patient patient for the order
     * @param dishs list of ordered dishes
     */
    public OrderDetail(int orderId, Patient patient, List<Dish> dishs) {
        this.orderId = orderId;
        this.patient=patient;
        this.dishs = dishs;
    }

    /**
     * Getter for property orderId
     * @return orderId of the order
     */
    public int getOrderId() {
        return this.orderId;
    }

    /**
     * Setter for property orderId
     * @param orderId to set
     */
    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    /**
     * Returns a list of dishes of the order
     * @return list of ordered dishes
     */
    public List<Dish> getDishs() {
        return this.dishs;
    }

    /**
     * Sets the list of ordered dishes
     * @param dishs the list of ordered dishes
     */
    public void setDishs(List<Dish> dishs) {
        this.dishs = dishs;
    }
}