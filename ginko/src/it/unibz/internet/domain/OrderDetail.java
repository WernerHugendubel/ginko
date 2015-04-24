package it.unibz.internet.domain;

import java.util.HashSet;
import java.util.Set;

/**
 * Domain object Mealorder. A single mealorder is identified by a orderId and
 * has as attributes the patient who is referred to, the employee who inserted
 * the order, the deliveryNum identifies the delivery the order is part from
 *
 * @author Werner Frei <freiwe@gmail.com>
 */
public class OrderDetail {

    private int orderId;
    private Set<Dish> dishs = new HashSet<Dish>(0);

    public OrderDetail() {
    }

    public OrderDetail(int orderId, Patient patient, int deliveryNumber) {
        this.orderId = orderId;
    }

    public OrderDetail(int orderId, Patient patient, int deliveryNumber, Set<Dish> dishs) {
        this.orderId = orderId;
        this.dishs = dishs;
    }

    public int getOrderId() {
        return this.orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public Set<Dish> getDishs() {
        return this.dishs;
    }

    public void setDishs(Set<Dish> dishs) {
        this.dishs = dishs;
    }
}