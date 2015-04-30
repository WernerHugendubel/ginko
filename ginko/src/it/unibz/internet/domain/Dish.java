package it.unibz.internet.domain;

import java.io.Serializable;


/**
 * Domain Object dish.
 *
 * @author Werner Frei <freiwe@gmail.com>
 */
public class Dish implements Serializable{

	private static final long serialVersionUID = 5597169245834370573L;
	private int dishId;
    private String name;
    private double price;

    /**
     * Constructor
     */
    public Dish() {
    }

    /**
     * Constructor
     * @param dishId the id of the dish
     * @param name name of the dish
     * @param price price of the dish
     */
    public Dish(int dishId, String name, double price) {
        this.dishId = dishId;
        this.name = name;
        this.price = price;
    }

    /**
     * Getter for dishid
     * @return  dishid of the dish
     */
    public int getDishId() {
        return this.dishId;
    }

    
    /**
     * Setter for dishId
     * @param dishId the dishId to set
     */
    public void setDishId(int dishId) {
        this.dishId = dishId;
    }

    /**
     * Getter for property name
     * @return the name of the dish
     */
    public String getName() {
        return this.name;
    }

    /**
     * Setter for property name
     * @param name the name of the dish
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter for property price
     * @return the price of the dish
     */
    public double getPrice() {
        return this.price;
    }

    /**
     * Setter for property price
     * @param price the price of the dish to set
     */
    public void setPrice(double price) {
        this.price = price;
    }
    
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Dish)) {
            return false;
        } else {
            Dish tmpdish = (Dish) o;
            boolean result = this.dishId == tmpdish.dishId;
            result = result && this.name.equals(tmpdish.name);
            result = result && this.price == tmpdish.price;
            return result;
        }
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 23 * hash + this.dishId;
        hash = 23 * hash + (this.name != null ? this.name.hashCode() : 0);
        hash = 23 * hash + (int) (Double.doubleToLongBits(this.price) ^ (Double.doubleToLongBits(this.price) >>> 32));
        return hash;
    }
    
    @Override
    public String toString(){
        return "("+this.dishId+" "+this.getName()+")";
    }
}