package it.unibz.internet.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Domain object Patient.
 *
 * @author Werner Frei <freiwe@gmail.com>
 */
public class Patient implements Serializable {

	private static final long serialVersionUID = 4133642468888988950L;
	private int patientId;
    private String name;
    private int bednr;
    private List<Restriction> restrictions = new ArrayList<Restriction>();
    private Set<Order> orders = new HashSet<Order>(0);
    

	/**
	 * @return the orders
	 */
	public Set<Order> getOrders() {
		return orders;
	}

	/**
	 * @param orders the orders to set
	 */
	public void setOrders(Set<Order> orders) {
		this.orders = orders;
	}

	/**
	 * Constructor
	 */
	public Patient() {
    }

    /**
     * Constructor
     * @param patientId id of the patient
     * @param name of the patient
     * @param bednr the patient is in 
     */
    public Patient(int patientId, String name, int bednr) {
        this.patientId = patientId;
        this.name = name;
        this.bednr = bednr;
    }

    /**
     * Constructor
     * @param patientId id of the patient
     * @param name name of the patient
     * @param bednr the patient is in 
     * @param restrictions list of the restrictions of the patient
     * @param orders list of the orders of the patient
     */
    public Patient(int patientId, String name, int bednr, List<Restriction> restrictions, Set<Order> orders) {
        this.patientId = patientId;
        this.name = name;
        this.bednr = bednr;
        this.restrictions = restrictions;
        this.orders=orders;
    }

	/**
	 * @return the patientId
	 */
	public int getPatientId() {
		return patientId;
	}

	/**
	 * @param patientId the patientId to set
	 */
	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the bednr
	 */
	public int getBednr() {
		return bednr;
	}

	/**
	 * @param bednr the bednr to set
	 */
	public void setBednr(int bednr) {
		this.bednr = bednr;
	}

	/**
	 * @return the restrictions
	 */
	public List<Restriction> getRestrictions() {
		return restrictions;
	}

	/**
	 * @param restrictions the restrictions to set
	 */
	public void setRestrictions(List<Restriction> restrictions) {
		this.restrictions = restrictions;
	}


}