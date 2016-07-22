package auth.persistence.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import auth.persistence.entities.User;

/**
 * 
 * @author Mitroi Stefan-Daniel
 *
 */
public class UserDaoImpl implements UserDao {
	private DaoManager dm = DaoManager.getInstace();
	private Connection connection;

	public UserDaoImpl(Connection connection) {
		this.connection = connection;
	}
	
	@Override
	public void addUser(User user) {
		String query;
		query = "INSERT INTO usertable " + "VALUES(" + user.getId() + "," + "'" + user.getUserName() + "', '"
				+ user.getFirsName() + "', '" + user.getLastName() + "', '" + user.getPassword() + "', '" + user.getEmail()
				+ "', '" + user.getCountry() + "', " + user.getAge() + ")";
			try {
				Statement stm = connection.createStatement();
				stm.executeUpdate(query);
			} catch (SQLException e) {
	
				e.printStackTrace();
			}
	
	}

}
