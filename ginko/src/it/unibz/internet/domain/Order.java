package it.unibz.internet.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Domain object Order 
 *
 * @author Werner Frei <freiwe@gmail.com>
 */
public class Order {

	private int orderId;

	private Date orderdate;
    private int patientId;
    private List<Dish> dishs = new ArrayList<Dish>();
    
    public Order() {
    }

    public Order(int deliveryId) {
        this.orderId = deliveryId;
    }

    public Order(int orderId, Date datedelivery, List<Dish> dishs) {
        this.orderId = orderId;
        this.orderdate = datedelivery;
        this.dishs = dishs;
    }

    public int getOrderId() {
        return this.orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }
    public Date getOrderdate() {
		return orderdate;
	}

	public void setOrderdate(Date orderdate) {
		this.orderdate = orderdate;
	}

	public int getPatientId() {
		return patientId;
	}

	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}

    public List<Dish> getDishs() {
        return this.dishs;
    }

    public void setDishs(List<Dish> dishs) {
        this.dishs = dishs;
    }
}