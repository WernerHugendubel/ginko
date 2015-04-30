package it.unibz.internet.dao;

import it.unibz.internet.domain.Patient;

import java.util.List;

public interface PatientDAOInterface {

	public abstract void addNew(Patient pat);

	public abstract void delete(int id);

	public abstract void update(Patient p);

	public abstract Patient getPatient(int id);

	public abstract List<Patient> getPatients();

}