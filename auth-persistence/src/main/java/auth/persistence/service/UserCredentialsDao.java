package auth.persistence.service;

/**
 * 
 * @author Mitroi Stefan-Daniel
 *
 */
import auth.persistence.entities.UserCredentials;

public interface UserCredentialsDao {

	public void findUserCredentials(UserCredentials uc);

}
