package auth.persistence.service;

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

		UserCredentials uc = new UserCredentials("stn", "pass");
		UserCredentialsDaoImpl ucd = new UserCredentialsDaoImpl();
		ucd.findUserCredentials(uc);
	}

}
