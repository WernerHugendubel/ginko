package it.unibz.internet.db;

import it.unibz.internet.domain.Restriction;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RestrictionDAO {

	public Restriction getRestriction(int id) {
		Restriction restr = null;
		Connection con = DatabaseConnectionFactory.createConnection();
		Statement stmt = null;
		try {
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM restriction WHERE restrictionId=" + id);
			if (rs.next()) {
				restr = new Restriction();
				restr.setRestrictionId(rs.getInt(1));
				restr.setName(rs.getString(2));
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
			Logger.getLogger(RestrictionDAO.class.getName()).log(
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
				Logger.getLogger(RestrictionDAO.class.getName()).log(
						Level.SEVERE, null, ex);
			}
		}
		return restr;
	}
	

	public List<Restriction> getRestrictions() {
		List<Restriction> restrictionList = new ArrayList<>();
		Connection con = DatabaseConnectionFactory.createConnection();
		Statement stmt = null;
		try {
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM restriction ORDER BY restrictionid");
			while (rs.next()) {
				Restriction restriction = new Restriction();
				restriction.setRestrictionId(rs.getInt(1));
				restriction.setName(rs.getString(2));
				restrictionList.add(restriction);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
			Logger.getLogger(RestrictionDAO.class.getName()).log(
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
				Logger.getLogger(RestrictionDAO.class.getName()).log(
						Level.SEVERE, null, ex);
			}
		}
		return restrictionList;
	}
}
