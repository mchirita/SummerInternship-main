package auth.persistence.service;

import java.sql.Connection;

import auth.persistence.entities.User;
import auth.persistence.entities.UserCredentials;

public class Test {

	public static void main(String[] args) {

		DaoManager d = DaoManager.getInstace();
		// UserDaoImpl u = new UserDaoImpl();
		// User user = new User(8,"stn", "mitroi", "stefan","pass", "msd", "ro",
		// 20);
		//
		// String ceva= u.addUser(user);
		// d.executeUpdate(ceva);

		Connection c = d.getConnection();
		UserDaoImpl u = new UserDaoImpl(c);
		User user = new User(9, "stn1", "mitroi1", "stefan", "pass", "msd", "ro", 20);
		u.addUser(user);
		d.closeConnection();
		// UserCredentials uc = new UserCredentials("stn", "pass");
		// UserCredentialsDaoImpl ucd = new UserCredentialsDaoImpl(c);
		// ucd.findUserCredentials(uc);
	}

}
