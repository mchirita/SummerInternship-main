package auth.persistence.service;

import auth.persistence.entities.User;

/**
 * 
 * @author Mitroi Stefan-Daniel
 *
 */
public class UserDaoImpl implements UserDao {
	private DaoManager dm = DaoManager.getInstace();

	@Override
	public void addUser(User user) {
		String query;
		query = "INSERT INTO usertable " + "VALUES(" + user.getId() + "," + "'" + user.getUserName() + "', '"
				+ user.getFirsName() + "', '" + user.getLastName() + "', '" + user.getPassword() + "', '" + user.getEmail()
				+ "', '" + user.getCountry() + "', " + user.getAge() + ")";
		dm.executeUpdate(query);
	}

}
