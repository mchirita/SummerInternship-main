package auth.persistence.service;

import auth.persistence.entities.UserCredentials;

/**
 * 
 * @author Mitroi Stefan-Daniel
 *
 */
public class UserCredentialsDaoImpl implements UserCredentialsDao {
	private DaoManager dm = DaoManager.getInstace();

	@Override
	public void findUserCredentials(UserCredentials uc) {
		String query = "SELECT username, password FROM usertable WHERE username= '" + uc.getUserName() + "' AND password= '"
				+ uc.getPassword() + "'";
		dm.getConnection();
		dm.executeQuery(query);

	}

}
