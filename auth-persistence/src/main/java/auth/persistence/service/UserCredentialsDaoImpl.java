package auth.persistence.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import auth.persistence.entities.UserCredentials;

/**
 * 
 * @author Mitroi Stefan-Daniel
 *
 */
public class UserCredentialsDaoImpl implements UserCredentialsDao {
	private DaoManager dm = DaoManager.getInstace();
	private Connection connection;

	public UserCredentialsDaoImpl(Connection connection) {
		this.connection = connection;
	}

	@Override
	public void findUserCredentials(UserCredentials uc) {
		String query = "SELECT username, password FROM usertable WHERE username= '" + uc.getUserName() + "' AND password= '"
				+ uc.getPassword() + "'";

		try {
			Statement stm = connection.createStatement();
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
