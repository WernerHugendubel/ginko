package it.unibz.internet.db;

import it.unibz.internet.domain.Patient;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PatientDBService {

	public void addNew(Patient pat) {
		Connection con = DatabaseConnectionFactory.createConnection();
		PreparedStatement pstmt = null;
		try {
			pstmt = con
					.prepareStatement("INSERT INTO patient(patientid,name,bednr) VALUES(?,?,?)");
			pstmt.setInt(1, pat.getPatientId());
			pstmt.setString(2, pat.getName());
			pstmt.setInt(3, pat.getBednr());
			pstmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
			Logger.getLogger(PatientDBService.class.getName()).log(Level.SEVERE,
					null, e);
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
		} catch (SQLException ex) {
			ex.printStackTrace();
			Logger.getLogger(PatientDBService.class.getName()).log(Level.SEVERE,
					null, ex);
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
	
	//
	// public void update(Employee e) {
	// Connection con = null;
	// PreparedStatement pstmt = null;
	// try {
	// Class.forName(JDBC_DRIVER);
	// con = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
	// pstmt =
	// con.prepareStatement("UPDATE emp SET empName=?, phone=?, email=?, salary=?, desig=? WHERE empId=?");
	// pstmt.setString(1, e.getName());
	// pstmt.setString(2, e.getPhone());
	// pstmt.setString(3, e.getEmail());
	// pstmt.setFloat(4, e.getSalary());
	// pstmt.setString(5, e.getDesignation());
	// pstmt.setInt(6, e.getEmpId());
	// pstmt.executeUpdate();
	// } catch (SQLException | ClassNotFoundException ex) {
	//
	// } finally {
	// try {
	// if (pstmt != null) {
	// pstmt.close();
	// }
	// if (con != null) {
	// con.close();
	// }
	// } catch (SQLException ex) {
	// Logger.getLogger(EmployeeBean.class.getName()).log(Level.SEVERE, null,
	// ex);
	// }
	// }
	// }
	//
	// public Employee getEmployee(int id) {
	// Employee emp = null;
	// Connection con = null;
	// Statement stmt = null;
	// try {
	// Class.forName(JDBC_DRIVER);
	// con = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
	// stmt = con.createStatement();
	// ResultSet rs = stmt.executeQuery("SELECT * FROM emp WHERE empId=" + id);
	// if (rs.next()) {
	// emp = new Employee();
	// emp.setEmpId(rs.getInt(1));
	// emp.setName(rs.getString(2));
	// emp.setPhone(rs.getString(3));
	// emp.setEmail(rs.getString(4));
	// emp.setSalary(rs.getFloat(5));
	// emp.setDesignation(rs.getString(6));
	// }
	// } catch (SQLException | ClassNotFoundException ex) {
	//
	// } finally {
	// try {
	// if (stmt != null) {
	// stmt.close();
	// }
	// if (con != null) {
	// con.close();
	// }
	// } catch (SQLException ex) {
	// Logger.getLogger(EmployeeBean.class.getName()).log(Level.SEVERE, null,
	// ex);
	// }
	// }
	// return emp;
	// }
	//
	// public List<Employee> getEmployees() {
	// List<Employee> list = new ArrayList<>();
	// Connection con = null;
	// Statement stmt = null;
	// try {
	// Class.forName(JDBC_DRIVER);
	// con = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
	// stmt = con.createStatement();
	// ResultSet rs = stmt.executeQuery("SELECT * FROM emp ORDER BY empId");
	// while (rs.next()) {
	// Employee emp = new Employee();
	// emp.setEmpId(rs.getInt(1));
	// emp.setName(rs.getString(2));
	// emp.setPhone(rs.getString(3));
	// emp.setEmail(rs.getString(4));
	// emp.setSalary(rs.getFloat(5));
	// emp.setDesignation(rs.getString(6));
	// list.add(emp);
	// }
	// } catch (SQLException | ClassNotFoundException ex) {
	//
	// } finally {
	// try {
	// if (stmt != null) {
	// stmt.close();
	// }
	// if (con != null) {
	// con.close();
	// }
	// } catch (SQLException ex) {
	//
	// }
	// }
	// return list;
	// }

}
