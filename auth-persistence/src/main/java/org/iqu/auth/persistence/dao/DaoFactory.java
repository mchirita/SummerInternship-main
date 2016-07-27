package org.iqu.auth.persistence.dao;

import java.sql.Connection;

import org.iqu.auth.persistence.exception.DataBaseConnectionException;

/**
 * Create Dao objects.
 * 
 * @author Mitroi Stefan-Daniel
 *
 */
public class DaoFactory {

	private static DaoFactory instance;;
	private static Connection connection;
	private static UserDaoImpl user;

	public static DaoFactory getInstance() throws DataBaseConnectionException  {
		if (instance == null) {
			instance = new DaoFactory();
			return instance;
		} else {
			return instance;
		}
	}

	public UserDaoImpl getUserDao() {

		if (user == null) {
			user = new UserDaoImpl(connection);
			return user;
		} else {
			return user;
		}
	}

	private DaoFactory() throws DataBaseConnectionException  {
		connection = DaoManager.getInstace().getConnection();
	}

}
