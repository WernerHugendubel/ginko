package it.unibz.internet.domain;

import java.util.HashSet;
import java.util.Set;

/**
 * Domain object Restriction.
 *
 * @author Werner Frei <freiwe@gmail.com>
 */
public class Restriction  {

    private int restrictionId;
    private String name;
    private Set<Dish> dishs = new HashSet<Dish>(0);

    public Restriction() {
    }

    public Restriction(int restrictionId, String name) {
        this.restrictionId = restrictionId;
        this.name = name;
    }

    public Restriction(int restrictionId, String name, Set<Dish> dishs) {
        this.restrictionId = restrictionId;
        this.name = name;
        this.dishs = dishs;
    }

    public int getRestrictionId() {
        return this.restrictionId;
    }

    public void setRestrictionId(int restrictionId) {
        this.restrictionId = restrictionId;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Dish> getDishs() {
        return this.dishs;
    }

    public void setDishs(Set<Dish> dishs) {
        this.dishs = dishs;
    }
}