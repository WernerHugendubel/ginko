package it.unibz.internet.dao.implementation;

import it.unibz.internet.dao.DatabaseConnectionFactory;
import it.unibz.internet.dao.DishDAOInterface;
import it.unibz.internet.dao.RestrictionDAOInterface;
import it.unibz.internet.domain.Dish;
import it.unibz.internet.domain.Restriction;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RestrictionDAO implements RestrictionDAOInterface {

	/* (non-Javadoc)
	 * @see it.unibz.internet.db.RestrictionDAOInterface#getRestriction(int)
	 */
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
			    	DishDAOInterface dishDao = new DishDAO();
			    	Dish d = dishDao.getDish(rsdishes.getInt(2));
			    	dishlist.add(d);
			    }
			    restr.setDishs(dishlist);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
			Logger.getLogger(RestrictionDAO.class.getName()).log(
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
				Logger.getLogger(RestrictionDAO.class.getName()).log(
						Level.SEVERE, null, ex);
			}
		}
		return restr;
	}
	

	/* (non-Javadoc)
	 * @see it.unibz.internet.db.RestrictionDAOInterface#getRestrictions()
	 */
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
			    	DishDAOInterface dishDao = new DishDAO();
			    	Dish d = dishDao.getDish(rs.getInt(2));
			    	dishlist.add(d);
			    }
			    pstmt2.close();
			    rsdishes.close();
			    restriction.setDishs(dishlist);
				restrictionList.add(restriction);
				
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
			Logger.getLogger(RestrictionDAO.class.getName()).log(
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
				Logger.getLogger(RestrictionDAO.class.getName()).log(
						Level.SEVERE, null, ex);
			}
		}
		return restrictionList;
	}
}
