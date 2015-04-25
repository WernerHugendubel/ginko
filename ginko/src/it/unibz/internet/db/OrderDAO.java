package it.unibz.internet.db;

import it.unibz.internet.domain.Dish;
import it.unibz.internet.domain.Order;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class OrderDAO {

	public Order getOrder(int orderId){
		Order order = null;
		Connection con = DatabaseConnectionFactory.createConnection();
		PreparedStatement pstmt=null;
		DishDAO dishDAO = new DishDAO();
		try {
			pstmt = con.prepareStatement("SELECT * FROM orders WHERE orderId=?");
			pstmt.setInt(1, orderId);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				order= new Order();
				order.setOrderId(rs.getInt(1));
				order.setOrderDate(rs.getDate(2));
				order.setPatientId(rs.getInt(3));
				
				PreparedStatement pstmt2 = con.prepareStatement("SELECT * FROM orderdetails WHERE orderid=?");
				pstmt2.setInt(1, order.getOrderId());
				ResultSet resultSetODetails = pstmt2.executeQuery();
				List<Dish> dishList = new ArrayList<>();
				while(resultSetODetails.next())
				{
					Dish dish = dishDAO.getDish(resultSetODetails.getInt(2));
					dishList.add(dish);
				}
				order.setDishs(dishList);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
			Logger.getLogger(OrderDAO.class.getName()).log(
					Level.SEVERE, null, ex);
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (SQLException ex) {
				ex.printStackTrace();
				Logger.getLogger(OrderDAO.class.getName()).log(
						Level.SEVERE, null, ex);
			}
		}
		return order;
	}
	public List<Order> getOrderList(int patientId)
	{
		ArrayList<Order> orderList = new ArrayList<>();
		Connection con = DatabaseConnectionFactory.createConnection();
		PreparedStatement pstmt=null;
		DishDAO dishDAO = new DishDAO();
		try {
			pstmt = con.prepareStatement("SELECT * FROM orders WHERE patientId=?");
			pstmt.setInt(1, patientId);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				Order order = new Order();
				order.setOrderId(rs.getInt(1));
				order.setOrderDate(rs.getDate(2));
				order.setPatientId(rs.getInt(3));
				
				PreparedStatement pstmt2 = con.prepareStatement("SELECT * FROM orderdetails WHERE orderid=?");
				pstmt2.setInt(1, order.getOrderId());
				ResultSet resultSetODetails = pstmt2.executeQuery();
				List<Dish> dishList = new ArrayList<>();
				while(resultSetODetails.next())
				{
					Dish dish = dishDAO.getDish(resultSetODetails.getInt(2));
					dishList.add(dish);
				}
				order.setDishs(dishList);
				orderList.add(order);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
			Logger.getLogger(OrderDAO.class.getName()).log(
					Level.SEVERE, null, ex);
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (SQLException ex) {
				ex.printStackTrace();
				Logger.getLogger(OrderDAO.class.getName()).log(
						Level.SEVERE, null, ex);
			}
		}
		return orderList;
	}
	
	public boolean writeOrderDetails(Order o){
		Connection con = DatabaseConnectionFactory.createConnection();
		PreparedStatement pstmt=null;
		try {
			pstmt = con.prepareStatement("DELETE FROM orderdetails WHERE orderId=?");
			pstmt.setInt(1, o.getOrderId());
			pstmt.execute();
			for(int i=0;i<o.getDishs().size();i++){
				Dish dish = o.getDishs().get(i);
				pstmt = con.prepareStatement("INSERT INTO orderdetails (orderId, dishId) VALUES (?,?)");
				pstmt.setInt(1, o.getOrderId());
				pstmt.setInt(2, dish.getDishId());
				pstmt.execute();
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
			Logger.getLogger(OrderDAO.class.getName()).log(
					Level.SEVERE, null, ex);
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (SQLException ex) {
				ex.printStackTrace();
				Logger.getLogger(OrderDAO.class.getName()).log(
						Level.SEVERE, null, ex);
			}
		}
		return true;
	}
}
