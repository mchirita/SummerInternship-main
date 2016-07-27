package org.iqu.auth.persistence.dao;

import static org.iqu.auth.persistence.dao.JdbcConstants.*;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbcp.BasicDataSource;

/**
 * Manages database connection.
 * 
 * @author Mitroi Stefan-Daniel
 *
 */
public class DaoManager {

	private static DaoManager instance = new DaoManager();
	private Connection connection;

	public static DaoManager getInstace() {
		return instance;
	}

	public Connection getConnection() {

		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName(DRIVER);
		dataSource.setUrl(URL);
		dataSource.setUsername(USERNAME);
		dataSource.setPassword(PASSWORD);
		try {
			connection = dataSource.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}

	public void closeConnection() {
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private DaoManager() {

	}
}
