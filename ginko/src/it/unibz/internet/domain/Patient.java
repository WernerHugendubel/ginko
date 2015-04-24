package it.unibz.internet.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Domain object Patient.
 *
 * @author Werner Frei <freiwe@gmail.com>
 */
public class Patient implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 4133642468888988950L;
	private int patientId;
    private String name;
    private int bednr;
    private Set<Restriction> restrictions = new HashSet<Restriction>(0);
    private Set<Order> orders = new HashSet<Order>(0);
    
     public Set<Order> getOrders() {
		return orders;
	}

	public void setOrders(Set<Order> orders) {
		this.orders = orders;
	}

	public Patient() {
    }

    public Patient(int patientId, String name, int bednr) {
        this.patientId = patientId;
        this.name = name;
        this.bednr = bednr;
    }

    public Patient(int patientId, String name, int bednr, Set<Restriction> restrictions, Set<Order> orders) {
        this.patientId = patientId;
        this.name = name;
        this.bednr = bednr;
        this.restrictions = restrictions;
        this.orders=orders;
    }

    public int getPatientId() {
        return this.patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBednr() {
        return this.bednr;
    }

    public void setBednr(int bednr) {
        this.bednr = bednr;
    }

    public Set<Restriction> getRestrictions() {
        return this.restrictions;
    }

    public void setRestrictions(Set<Restriction> restrictions) {
        this.restrictions = restrictions;
    }
}