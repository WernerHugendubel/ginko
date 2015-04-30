package it.unibz.internet.dao.implementation;

import it.unibz.internet.dao.DatabaseConnectionFactory;
import it.unibz.internet.dao.DishDAOInterface;
import it.unibz.internet.domain.Dish;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DishDAO implements DishDAOInterface {

	/* (non-Javadoc)
	 * @see it.unibz.internet.db.DishDAOInterface#getDish(int)
	 */
	@Override
	public Dish getDish(int id) {
		Dish dish = null;
		Connection con = DatabaseConnectionFactory.createConnection();
		PreparedStatement pstmt = null;
		try {
			pstmt = con.prepareStatement("SELECT * FROM dish WHERE dishid=?");
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
				if (pstmt != null) {
					pstmt.close();
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
	

	/* (non-Javadoc)
	 * @see it.unibz.internet.db.DishDAOInterface#getDishs()
	 */
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
			Logger.getLogger(DishDAO.class.getName()).log(
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
				Logger.getLogger(DishDAO.class.getName()).log(
						Level.SEVERE, null, ex);
			}
		}
		return dishList;
	}
}
