package it.unibz.internet.dao;

import it.unibz.internet.domain.Dish;
import it.unibz.internet.domain.Order;
import it.unibz.internet.domain.Patient;
import it.unibz.internet.domain.Restriction;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Implementation of Dao - direct access to Database, 
 * Connection is retrieved from DatabaseConnectionFactory
 * Not all methods are implemented
 * 
 * @author Werner Frei <freiwe@gmail.com>
 */
public class DaoImpl implements Dao {

	@Override
	public Dish getDish(int dishId) {
		Dish dish = null;
		Connection con = DatabaseConnectionFactory.createConnection();
		PreparedStatement pstmt = null;
		try {
			pstmt = con.prepareStatement("SELECT * FROM dish WHERE dishid=?");
			pstmt.setInt(1, dishId);
			ResultSet rs= pstmt.executeQuery();
			if (rs.next()) {
				dish = new Dish();
				dish.setDishId(rs.getInt(1));
				dish.setName(rs.getString(2));
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
			Logger.getLogger(DaoImpl.class.getName()).log(
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
				Logger.getLogger(DaoImpl.class.getName()).log(
						Level.SEVERE, null, ex);
			}
		}
		return dish;
	}
	

	@Override
	public List<Dish> getDishs() {
		List<Dish> dishList = new ArrayList<>();
		Connection con = DatabaseConnectionFactory.createConnection();
		PreparedStatement pstmt = null;
		try {
			pstmt = con.prepareStatement("SELECT * FROM dish ORDER BY dishid");
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				Dish dish = new Dish();
				dish.setDishId(rs.getInt(1));
				dish.setName(rs.getString(2));
				dishList.add(dish);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
			Logger.getLogger(DaoImpl.class.getName()).log(
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
				Logger.getLogger(DaoImpl.class.getName()).log(
						Level.SEVERE, null, ex);
			}
		}
		return dishList;
	}
	
	@Override
	public Order getOrder(int orderId){
		Order order = null;
		Connection con = DatabaseConnectionFactory.createConnection();
		PreparedStatement pstmt=null;
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
					Dish dish = this.getDish(resultSetODetails.getInt(2));
					dishList.add(dish);
				}
				order.setDishs(dishList);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
			Logger.getLogger(DaoImpl.class.getName()).log(
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
				Logger.getLogger(DaoImpl.class.getName()).log(
						Level.SEVERE, null, ex);
			}
		}
		return order;
	}

	@Override
	public List<Order> getOrderList(int patientId)
	{
		ArrayList<Order> orderList = new ArrayList<>();
		Connection con = DatabaseConnectionFactory.createConnection();
		PreparedStatement pstmt=null;
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
					Dish dish = this.getDish(resultSetODetails.getInt(2));
					dishList.add(dish);
				}
				order.setDishs(dishList);
				orderList.add(order);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
			Logger.getLogger(DaoImpl.class.getName()).log(
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
				Logger.getLogger(DaoImpl.class.getName()).log(
						Level.SEVERE, null, ex);
			}
		}
		return orderList;
	}
	
	@Override
	public boolean updateOrderDetails(Order o){
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
			Logger.getLogger(DaoImpl.class.getName()).log(
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
				Logger.getLogger(DaoImpl.class.getName()).log(
						Level.SEVERE, null, ex);
			}
		}
		return true;
	}

	@Override
	public void addNew(Patient pat) {
		Connection con = DatabaseConnectionFactory.createConnection();
		PreparedStatement pstmt = null;
		try {
			pstmt = con
					.prepareStatement("INSERT INTO patient(name,bednr) VALUES(?,?)");
			pstmt.setString(1, pat.getName());
			pstmt.setInt(2, pat.getBednr());
			pstmt.execute();
			
			//Restrictions abspeichern
			
		} catch (SQLException e) {
			e.printStackTrace();
			Logger.getLogger(DaoImpl.class.getName()).log(
					Level.SEVERE, null, e);
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
				Logger.getLogger(DaoImpl.class.getName()).log(
						Level.SEVERE, null, ex);
			}
		}

	}


	@Override
	public void deletePatientById(int id) {
		Connection con = DatabaseConnectionFactory.createConnection();
		PreparedStatement pstmt = null;
		try {
			pstmt = con
					.prepareStatement("DELETE FROM patient WHERE patientid=?");
			pstmt.setInt(1, id);
			pstmt.execute();
			
			//Delete Restrictions 
			//evtl. orders??? 
			
		} catch (SQLException ex) {
			ex.printStackTrace();
			Logger.getLogger(DaoImpl.class.getName()).log(
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
				Logger.getLogger(DaoImpl.class.getName()).log(
						Level.SEVERE, null, ex);
			}
		}
	}


	@Override
	public void updatePatient(Patient p) {
		Connection con = DatabaseConnectionFactory.createConnection();
		PreparedStatement pstmt = null;
		try {
			pstmt = con
					.prepareStatement("UPDATE patient SET name=?, bednr=? WHERE patientId=?");
			pstmt.setString(1, p.getName());
			pstmt.setInt(2, p.getBednr());
			pstmt.setInt(3, p.getPatientId());
			pstmt.executeUpdate();
			
			//Restrictions updaten
		} catch (SQLException ex) {
			ex.printStackTrace();
			Logger.getLogger(DaoImpl.class.getName()).log(
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
				Logger.getLogger(DaoImpl.class.getName()).log(
						Level.SEVERE, null, ex);
			}
		}
	}


	@Override
	public Patient getPatient(int id) {
		Patient pat = null;
		Connection con = DatabaseConnectionFactory.createConnection();
		PreparedStatement pstmt = null;
		PreparedStatement pstmt2 = null;
		try {
			pstmt = con.prepareStatement("SELECT * FROM patient WHERE patientid=?");
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				pat = new Patient();
				pat.setPatientId(rs.getInt(1));
				pat.setName(rs.getString(2));
				pat.setBednr(rs.getInt(3));
			}
			pstmt2 = con.prepareStatement("SELECT restrictionid FROM patienthasrestriction WHERE patientid=?");
			pstmt2.setInt(1, id);
			rs=pstmt2.executeQuery();
			List<Restriction> restrictionset = new ArrayList<>();
			while(rs.next())
			{
				int restrictionid = rs.getInt(1);
				Restriction rest =this.getRestriction(restrictionid);
			    restrictionset.add(rest);
			}
			pat.setRestrictions(restrictionset);
		} catch (SQLException ex) {
			ex.printStackTrace();
			Logger.getLogger(DaoImpl.class.getName()).log(
					Level.SEVERE, null, ex);
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
				}
				if (pstmt2 != null) {
					pstmt2.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (SQLException ex) {
				ex.printStackTrace();
				Logger.getLogger(DaoImpl.class.getName()).log(
						Level.SEVERE, null, ex);
			}
		}
		return pat;
	}
	


	@Override
	public List<Patient> getPatients() {
		List<Patient> list = new ArrayList<>();
		Connection con = DatabaseConnectionFactory.createConnection();
		PreparedStatement pstmt = null;
		try {
			pstmt = con.prepareStatement("SELECT * FROM patient ORDER BY patientId");
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				Patient pat = new Patient();
				pat.setPatientId(rs.getInt(1));
				pat.setName(rs.getString(2));
				pat.setBednr(rs.getInt(3));
				
				pstmt = con.prepareStatement("SELECT restrictionid FROM patienthasrestriction WHERE patientid=?");
				pstmt.setInt(1, pat.getPatientId());
				ResultSet resultSetRestrictions = pstmt.executeQuery();
				List<Restriction> setRestriction = new ArrayList<>();
				while(resultSetRestrictions.next())
				{
					Restriction restriction = this.getRestriction(resultSetRestrictions.getInt(1));
					setRestriction.add(restriction);
				}
				pat.setRestrictions(setRestriction);
				list.add(pat);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
			Logger.getLogger(DaoImpl.class.getName()).log(
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
				Logger.getLogger(DaoImpl.class.getName()).log(
						Level.SEVERE, null, ex);
			}
		}
		return list;
	}


	@Override
	public Restriction getRestriction(int id) {
		Restriction restr = null;
		Connection con = DatabaseConnectionFactory.createConnection();
		PreparedStatement pstmt = null;
		try {
			pstmt = con.prepareStatement("SELECT * FROM restriction WHERE restrictionId=?");
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				restr = new Restriction();
				restr.setRestrictionId(rs.getInt(1));
				restr.setName(rs.getString(2));
				PreparedStatement pstmt2=con.prepareStatement("SELECT * FROM dishassignedtorestriction WHERE restrictionId=?");
				pstmt2.setInt(1, id);
			    ResultSet rsdishes = pstmt2.executeQuery();
			    List<Dish> dishlist = new ArrayList<>();
			    while(rsdishes.next())
			    {	
			    	Dish d = this.getDish(rsdishes.getInt(2));
			    	dishlist.add(d);
			    }
			    restr.setDishs(dishlist);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
			Logger.getLogger(DaoImpl.class.getName()).log(
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
				Logger.getLogger(DaoImpl.class.getName()).log(
						Level.SEVERE, null, ex);
			}
		}
		return restr;
	}
	


	@Override
	public List<Restriction> getRestrictions() {
		List<Restriction> restrictionList = new ArrayList<>();
		Connection con = DatabaseConnectionFactory.createConnection();
		PreparedStatement pstmt = null;
		try {
			pstmt = con.prepareStatement("SELECT * FROM restriction ORDER BY restrictionid");
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				Restriction restriction = new Restriction();
				restriction.setRestrictionId(rs.getInt(1));
				restriction.setName(rs.getString(2));
				PreparedStatement pstmt2=con.prepareStatement("SELECT * FROM dishassignedtorestriction WHERE restrictionId=?");
				pstmt2.setInt(1, restriction.getRestrictionId());
			    ResultSet rsdishes = pstmt2.executeQuery();
			    List<Dish> dishlist = new ArrayList<>();
			    while(rsdishes.next())
			    {	
			    	Dish d = this.getDish(rs.getInt(2));
			    	dishlist.add(d);
			    }
			    pstmt2.close();
			    rsdishes.close();
			    restriction.setDishs(dishlist);
				restrictionList.add(restriction);
				
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
			Logger.getLogger(DaoImpl.class.getName()).log(
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
				Logger.getLogger(DaoImpl.class.getName()).log(
						Level.SEVERE, null, ex);
			}
		}
		return restrictionList;
	}


	@Override
	public void insertOrder(Order o) {
		// TODO Auto-generated method stub
		throw new RuntimeException("not yet implemented");
	}
}
