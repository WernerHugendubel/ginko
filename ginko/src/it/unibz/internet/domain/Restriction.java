package it.unibz.internet.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * Domain object Restriction.
 *
 * @author Werner Frei <freiwe@gmail.com>
 */
public class Restriction  {

    private int restrictionId;
    private String name;
    private List<Dish> dishs = new ArrayList<>();

    public Restriction() {
    }

    public Restriction(int restrictionId, String name) {
        this.restrictionId = restrictionId;
        this.name = name;
    }

    public Restriction(int restrictionId, String name, List<Dish> dishs) {
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

    public List<Dish> getDishs() {
        return this.dishs;
    }

    public void setDishs(List<Dish> dishs) {
        this.dishs = dishs;
    }
}