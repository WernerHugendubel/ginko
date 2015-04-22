package it.unibz.internet.domain;

import java.util.HashSet;
import java.util.Set;

/**
 * Domain object Ingredient.
 *
 * @author Werner Frei <freiwe@gmail.com>
 */
public class Ingredient {

	private int ingredientId;
    private String name;
    private Set<Dish> dishs = new HashSet<Dish>(0);

    public Ingredient() {
    }

    public Ingredient(int ingredientId) {
        this.ingredientId = ingredientId;
    }

    public Ingredient(int ingredientId, String name, Set<Dish> dishs) {
        this.ingredientId = ingredientId;
        this.name = name;
        this.dishs = dishs;
    }

    public int getIngredientId() {
        return this.ingredientId;
    }

    public void setIngredientId(int ingredientId) {
        this.ingredientId = ingredientId;
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