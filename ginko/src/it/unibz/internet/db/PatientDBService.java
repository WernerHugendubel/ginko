package it.unibz.internet.db;

import it.unibz.internet.domain.Order;
import it.unibz.internet.domain.Patient;
import it.unibz.internet.domain.Restriction;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PatientDBService {

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
			Logger.getLogger(PatientDBService.class.getName()).log(
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
				Logger.getLogger(PatientDBService.class.getName()).log(
						Level.SEVERE, null, ex);
			}
		}

	}

	public void delete(int id) {
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
			Logger.getLogger(PatientDBService.class.getName()).log(
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
				Logger.getLogger(PatientDBService.class.getName()).log(
						Level.SEVERE, null, ex);
			}
		}
	}

	public void update(Patient p) {
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
			Logger.getLogger(PatientDBService.class.getName()).log(
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
				Logger.getLogger(PatientDBService.class.getName()).log(
						Level.SEVERE, null, ex);
			}
		}
	}

	public Patient getPatient(int id) {
		Patient pat = null;
		Connection con = DatabaseConnectionFactory.createConnection();
		Statement stmt = null;
		try {
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM patient WHERE patientId=" + id);
			if (rs.next()) {
				pat = new Patient();
				pat.setPatientId(rs.getInt(1));
				pat.setName(rs.getString(2));
				pat.setBednr(rs.getInt(3));
			}
			PreparedStatement pstmt = con.prepareStatement("SELECT * FROM restrictions WHERE patientId=?");
			pstmt.setInt(1, id);
			rs=pstmt.executeQuery();
			Set<Restriction> restrictionset = new HashSet<>(0);
			while(rs.next())
			{
				Restriction rest = new Restriction();
				rest.setRestrictionId(rs.getInt(1));
				rest.setName(rs.getString(2));
			    restrictionset.add(rest);
			}
			pat.setRestrictions(restrictionset);
			
			
		} catch (SQLException ex) {
			ex.printStackTrace();
			Logger.getLogger(PatientDBService.class.getName()).log(
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
				Logger.getLogger(PatientDBService.class.getName()).log(
						Level.SEVERE, null, ex);
			}
		}
		return pat;
	}
	

	public List<Patient> getPatients() {
		List<Patient> list = new ArrayList<>();
		Connection con = DatabaseConnectionFactory.createConnection();
		Statement stmt = null;
		try {
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM patient ORDER BY patientId");
			while (rs.next()) {
				Patient pat = new Patient();
				pat.setPatientId(rs.getInt(1));
				pat.setName(rs.getString(2));
				pat.setBednr(rs.getInt(3));
				list.add(pat);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
			Logger.getLogger(PatientDBService.class.getName()).log(
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
				Logger.getLogger(PatientDBService.class.getName()).log(
						Level.SEVERE, null, ex);
			}
		}
		return list;
	}
}
