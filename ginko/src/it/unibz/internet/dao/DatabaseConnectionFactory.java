package it.unibz.internet.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Factory for Database connections
 * 
 * @author Werner Frei <freiwe@gmail.com>
 */
public class DatabaseConnectionFactory {

	private static String dbURL = "jdbc:postgresql://localhost/webmeal";
	private static String dbUser = "postgres";
	private static String dbPassword = "postgres";

	public static Connection createConnection() {
		Connection con = null;
		try {
			try {
				Class.forName("org.postgresql.Driver");
			} catch (ClassNotFoundException ex) {
				System.out.println("Error: unable to load driver class!");
				System.exit(1);
			}
			con = DriverManager.getConnection(dbURL, dbUser, dbPassword);
		} catch (SQLException sqe) {
			System.out.println("Error: While Creating connection to database");
			sqe.printStackTrace();
			System.exit(-1);
		}
		return con;
	}

}
