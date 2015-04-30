package it.unibz.internet.dao;

import it.unibz.internet.domain.Restriction;

import java.util.List;

public interface RestrictionDAOInterface {

	public abstract Restriction getRestriction(int id);

	public abstract List<Restriction> getRestrictions();

}