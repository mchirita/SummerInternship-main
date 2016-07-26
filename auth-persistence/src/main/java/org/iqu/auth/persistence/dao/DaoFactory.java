package org.iqu.auth.persistence.dao;

import java.sql.Connection;

/**
 * 
 * @author Mitroi Stefan-Daniel
 *
 */
public class DaoFactory {

	private static DaoFactory instance = new DaoFactory();
	private static Connection connection;
	private static UserDaoImpl user;


	public static DaoFactory getInstance() {

		return instance;
	}

	public UserDaoImpl getUserDao() {

		if (user == null) {
			user = new UserDaoImpl(connection);
			return user;
		} else {
			return user;
		}
	}

	private DaoFactory() {
		connection = DaoManager.getInstace().getConnection();
	}

}
