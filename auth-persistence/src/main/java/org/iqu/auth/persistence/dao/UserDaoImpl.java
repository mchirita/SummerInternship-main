package org.iqu.auth.persistence.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.iqu.auth.persistence.dto.ChangePasswordDetailesDto;
import org.iqu.auth.persistence.dto.UserCredentialsDto;
import org.iqu.auth.persistence.dto.UserDto;
import org.iqu.auth.persistence.exception.AuthPersistenceException;
import static org.iqu.auth.persistence.dao.JdbcConstants.*;

/**
 * 
 * @author Mitroi Stefan-Daniel
 *
 */
public class UserDaoImpl implements UserDao {

	private Connection connection;

	public UserDaoImpl(Connection connection) {

		this.connection = connection;
	}

	@Override
	public void addUser(UserDto user) throws AuthPersistenceException {

		String query;

		query = "INSERT INTO " + TABLENAME + " VALUES(?,?,?,?,?,?,?)";
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1, user.getUserName());
			ps.setString(2, user.getFirstName());
			ps.setString(3, user.getLastName());
			ps.setString(4, user.getPassword());
			ps.setString(5, user.getEmail());
			ps.setString(6, user.getCountry());
			ps.setInt(7, user.getAge());
			ps.executeUpdate();
		} catch (SQLException e) {
			if (e.getMessage().endsWith("'email_UNIQUE'")) {
				throw new AuthPersistenceException("Duplicate email");
			} else {
				throw new AuthPersistenceException("Duplicate user name");
			}
		}

	}
	
	@Override
	public void updatePassword(ChangePasswordDetailesDto cpddto,String oldPassword) {
		String query;

		query = "UPDATE " + TABLENAME + " SET password=? WHERE password = ?";
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1, cpddto.getNewPassword());
			ps.setString(1, oldPassword);
			ps.executeUpdate();
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		
	}
	

	
	public String getUser(String email) throws AuthPersistenceException {
		String query = "SELECT username FROM " + TABLENAME + " WHERE email=? ";
		PreparedStatement preparedStatement;
		String response = "";
		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, email);
			ResultSet result = preparedStatement.executeQuery();
			result.next();

			response = result.getString(1);

		} catch (SQLException e) {
			throw new AuthPersistenceException("Email not found.");
		}

		return response;
	}

	@Override
	public boolean checkForEmail(UserDto user) {
		boolean response = false;

		String query = "SELECT email FROM " + TABLENAME + " WHERE email=? ";

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, user.getEmail());
			ResultSet result = preparedStatement.executeQuery();
			if (result.isBeforeFirst()) {
				response = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return response;
	}
	@Override
	public boolean findUserCredentials(UserCredentialsDto userCredentials) {
		boolean response=false;
		
		String query = "SELECT username, password FROM "+TABLENAME+" WHERE username=?  AND password=? ";
	

		try {
			PreparedStatement preparedStatement =
	        connection.prepareStatement(query);
			preparedStatement.setString(1, userCredentials.getUserName());
			preparedStatement.setString(2, userCredentials.getPassword());
			ResultSet result = preparedStatement.executeQuery();
			if (result.isBeforeFirst()) {
				response = true;
			} 
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return response;
	}




}
