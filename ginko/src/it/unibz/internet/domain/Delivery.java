package it.unibz.internet.domain;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Domain object Delivery 
 *
 * @author Werner Frei <freiwe@gmail.com>
 */
public class Delivery {

	private int deliveryId;
    private Boolean dispatched;
    private Date datedelivery;
    private Set<Dish> dishs = new HashSet<Dish>(0);

    public Delivery() {
    }

    public Delivery(int deliveryId) {
        this.deliveryId = deliveryId;
    }

    public Delivery(int deliveryId, Boolean dispatched, Date datedelivery, Set<Dish> dishs) {
        this.deliveryId = deliveryId;
        this.dispatched = dispatched;
        this.datedelivery = datedelivery;
        this.dishs = dishs;
    }

    public int getDeliveryId() {
        return this.deliveryId;
    }

    public void setDeliveryId(int deliveryId) {
        this.deliveryId = deliveryId;
    }

    public Boolean getDispatched() {
        return this.dispatched;
    }

    public void setDispatched(Boolean dispatched) {
        this.dispatched = dispatched;
    }

    public Date getDatedelivery() {
        return this.datedelivery;
    }

    public void setDatedelivery(Date datedelivery) {
        this.datedelivery = datedelivery;
    }

    public Set<Dish> getDishs() {
        return this.dishs;
    }

    public void setDishs(Set<Dish> dishs) {
        this.dishs = dishs;
    }
}