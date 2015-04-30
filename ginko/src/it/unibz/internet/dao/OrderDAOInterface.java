package it.unibz.internet.dao;

import it.unibz.internet.domain.Order;

import java.util.List;

public interface OrderDAOInterface {

	public abstract Order getOrder(int orderId);

	public abstract List<Order> getOrderList(int patientId);

	public abstract boolean writeOrderDetails(Order o);

}