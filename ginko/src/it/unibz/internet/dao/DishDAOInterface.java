package it.unibz.internet.dao;

import it.unibz.internet.domain.Dish;

import java.util.List;

public interface DishDAOInterface {

	public abstract Dish getDish(int id);

	public abstract List<Dish> getDishs();

}