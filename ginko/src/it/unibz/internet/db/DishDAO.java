package it.unibz.internet.db;

import it.unibz.internet.domain.Dish;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DishDAO {

	public Dish getDish(int id) {
		Dish dish = null;
		Connection con = DatabaseConnectionFactory.createConnection();
		Statement stmt = null;
		try {
			stmt = con.createStatement();
			PreparedStatement pstmt = con.prepareStatement("SELECT * FROM dish WHERE dishid=?");
			pstmt.setInt(1, id);
			ResultSet rs= pstmt.executeQuery();
			if (rs.next()) {
				dish = new Dish();
				dish.setDishId(rs.getInt(1));
				dish.setName(rs.getString(2));
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
			Logger.getLogger(DishDAO.class.getName()).log(
					Level.SEVERE, null, ex);
		} finally {
			try {
				if (stmt != null) {
					stmt.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (SQLException ex) {
				ex.printStackTrace();
				Logger.getLogger(DishDAO.class.getName()).log(
						Level.SEVERE, null, ex);
			}
		}
		return dish;
	}
	

	public List<Dish> getDishs() {
		List<Dish> dishList = new ArrayList<>();
		Connection con = DatabaseConnectionFactory.createConnection();
		Statement stmt = null;
		try {
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM dish ORDER BY dishid");
			while (rs.next()) {
				Dish dish = new Dish();
				dish.setDishId(rs.getInt(1));
				dish.setName(rs.getString(2));
				dishList.add(dish);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
			Logger.getLogger(DishDAO.class.getName()).log(
					Level.SEVERE, null, ex);
		} finally {
			try {
				if (stmt != null) {
					stmt.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (SQLException ex) {
				ex.printStackTrace();
				Logger.getLogger(DishDAO.class.getName()).log(
						Level.SEVERE, null, ex);
			}
		}
		return dishList;
	}
}
