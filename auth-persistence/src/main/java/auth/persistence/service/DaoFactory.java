package auth.persistence.service;

/**
 * 
 * @author Mitroi Stefan-Daniel
 *
 */
public class DaoFactory {
	private static UserDao user = new UserDaoImpl();
	private static UserCredentialsDao userCredentials = new UserCredentialsDaoImpl();

	public static UserDao getUserDao() {

		return user;
	}

	public static UserCredentialsDao getUserCredentials() {

		return userCredentials;
	}

}
