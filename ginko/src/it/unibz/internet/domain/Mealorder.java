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
public class Mealorder {

    private int orderId;
    private Patient patient;
    private Employee employee;
    private int deliveryNumber;
    private Set<Dish> dishs = new HashSet<Dish>(0);

    public Mealorder() {
    }

    public Mealorder(int orderId, Patient patient, Employee employee, int deliveryNumber) {
        this.orderId = orderId;
        this.patient = patient;
        this.employee = employee;
        this.deliveryNumber = deliveryNumber;
    }

    public Mealorder(int orderId, Patient patient, Employee employee, int deliveryNumber, Set<Dish> dishs) {
        this.orderId = orderId;
        this.patient = patient;
        this.employee = employee;
        this.deliveryNumber = deliveryNumber;
        this.dishs = dishs;
    }

    public int getOrderId() {
        return this.orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public Patient getPatient() {
        return this.patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Employee getEmployee() {
        return this.employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public int getDeliveryNumber() {
        return this.deliveryNumber;
    }

    public void setDeliveryNumber(int deliveryNumber) {
        this.deliveryNumber = deliveryNumber;
    }

    public Set<Dish> getDishs() {
        return this.dishs;
    }

    public void setDishs(Set<Dish> dishs) {
        this.dishs = dishs;
    }
}