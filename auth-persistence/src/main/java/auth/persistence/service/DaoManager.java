package auth.persistence.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;

public class DaoManager {

	private static DaoManager instance = new DaoManager();
	private Connection conn;

	public static DaoManager getInstace() {
		return instance;
	}

	public Connection getConnection() {
		BasicDataSource bds = new BasicDataSource();
		bds.setDriverClassName("com.mysql.jdbc.Driver");
		bds.setUrl("jdbc:mysql://localhost:3306/mydb");
		bds.setUsername("root");
		bds.setPassword("1234");
		try {
			conn = bds.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	public void closeConnection(){
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private DaoManager() {

	}

	public void executeUpdate(String query) {
		Statement stm;
		try {
			stm = conn.createStatement();
			stm.executeUpdate(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void executeQuery(String query) {
		Statement stm;
		try {
			stm = conn.createStatement();
			ResultSet result = stm.executeQuery(query);
			if (!result.isBeforeFirst()) {
				System.out.println("!found");
			} else {
				System.out.println("found");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
/*
 * public void executeUpdate(String query) {
 * 
 * try { Class.forName("com.mysql.jdbc.Driver"); Connection con =
 * DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root",
 * "1234"); Statement stm = con.createStatement(); System.out.println(query);
 * stm.executeUpdate(query);
 * 
 * } catch (ClassNotFoundException e) { e.printStackTrace(); } catch
 * (SQLException e) { e.printStackTrace(); } }
 * 
 * public void executeQuery(String query) {
 * 
 * try { Class.forName("com.mysql.jdbc.Driver"); Connection con =
 * DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root",
 * "1234"); Statement stm = con.createStatement(); System.out.println(query);
 * ResultSet result = stm.executeQuery(query); if (!result.isBeforeFirst()) {
 * System.out.println("!found"); } else { System.out.println("found"); }
 * 
 * } catch (ClassNotFoundException e) { e.printStackTrace(); } catch
 * (SQLException e) { e.printStackTrace(); }
 * 
 * }
 */
