package it.unibz.internet.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * Domain object OrderDetail.
 *
 * @author Werner Frei <freiwe@gmail.com>
 */
public class OrderDetail {

    private int orderId;
    private List<Dish> dishs = new ArrayList<Dish>();

    public OrderDetail() {
    }

    public OrderDetail(int orderId, Patient patient, int deliveryNumber) {
        this.orderId = orderId;
    }

    public OrderDetail(int orderId, Patient patient, int deliveryNumber, List<Dish> dishs) {
        this.orderId = orderId;
        this.dishs = dishs;
    }

    public int getOrderId() {
        return this.orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public List<Dish> getDishs() {
        return this.dishs;
    }

    public void setDishs(List<Dish> dishs) {
        this.dishs = dishs;
    }
}