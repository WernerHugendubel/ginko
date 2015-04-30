package it.unibz.internet.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Domain object Restriction.
 *
 * @author Werner Frei <freiwe@gmail.com>
 */
public class Restriction implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 6313989383632493757L;
	private int restrictionId;
    private String name;
    private List<Dish> dishs = new ArrayList<>();

    /**
     * Constructor
     */
    public Restriction() {
    }

    /**
     * Constructor
     * @param restrictionId id of the restriction
     * @param name name of the restriction
     */
    public Restriction(int restrictionId, String name) {
        this.restrictionId = restrictionId;
        this.name = name;
    }

    /**
     * Constructor
     * @param restrictionId id of the restriction
     * @param name name of the restriction
     * @param dishs list of dishes falling in restriction
     */
    public Restriction(int restrictionId, String name, List<Dish> dishs) {
        this.restrictionId = restrictionId;
        this.name = name;
        this.dishs = dishs;
    }

	/**
	 * @return the restrictionId
	 */
	public int getRestrictionId() {
		return restrictionId;
	}

	/**
	 * @param restrictionId the restrictionId to set
	 */
	public void setRestrictionId(int restrictionId) {
		this.restrictionId = restrictionId;
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
	 * @return the dishs
	 */
	public List<Dish> getDishs() {
		return dishs;
	}

	/**
	 * @param dishs the dishs to set
	 */
	public void setDishs(List<Dish> dishs) {
		this.dishs = dishs;
	}


}