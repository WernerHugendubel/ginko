package it.unibz.internet.domain;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Domain object Delivery 
 *
 * @author Werner Frei <freiwe@gmail.com>
 */
public class Order {

	private int orderId;
    private Date orderdate;
    private Set<Dish> dishs = new HashSet<Dish>(0);
    
    public Order() {
    }

    public Order(int deliveryId) {
        this.orderId = deliveryId;
    }

    public Order(int orderId, Date datedelivery, Set<Dish> dishs) {
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

    public Date getDatedelivery() {
        return this.orderdate;
    }

    public void setDatedelivery(Date datedelivery) {
        this.orderdate = datedelivery;
    }

    public Set<Dish> getDishs() {
        return this.dishs;
    }

    public void setDishs(Set<Dish> dishs) {
        this.dishs = dishs;
    }
}