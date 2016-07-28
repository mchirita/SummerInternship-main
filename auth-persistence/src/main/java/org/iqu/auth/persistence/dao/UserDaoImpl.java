package org.iqu.auth.persistence.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;
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

  private static final Logger LOGGER = Logger.getLogger(DaoManager.class);
  private Connection connection;

  public UserDaoImpl(Connection connection) {

    this.connection = connection;
  }

  /**
   * Insert users in database.
   * 
   */
  @Override
  public void insertUser(UserDto user) throws AuthPersistenceException {

    StringBuilder query = new StringBuilder();
    query.append("INSERT INTO ").append(TABLENAME).append(" VALUES(?,?,?,?,?,?,?)");

    try {
      PreparedStatement ps = connection.prepareStatement(query.toString());
      ps.setString(1, user.getUserName());
      ps.setString(2, user.getFirstName());
      ps.setString(3, user.getLastName());
      ps.setString(4, user.getPassword());
      ps.setString(5, user.getEmail());
      ps.setString(6, user.getCountry());
      ps.setInt(7, user.getAge());
      ps.executeUpdate();
    } catch (SQLException e) {
      throw new AuthPersistenceException("Duplicate user name or email");
    }

  }

  /**
   * Update password in database
   * 
   * @throws AuthPersistenceException
   */
  @Override
  public void updatePassword(ChangePasswordDetailesDto changePasswordDetailes, String userName)
      throws AuthPersistenceException {

    StringBuilder query = new StringBuilder();
    query.append("UPDATE ").append(TABLENAME).append(" SET password=? WHERE   username = ?");

    try {
      PreparedStatement preparedStatement = connection.prepareStatement(query.toString());
      preparedStatement.setString(1, changePasswordDetailes.getNewPassword());
      preparedStatement.setString(2, userName);
      preparedStatement.executeUpdate();
    } catch (SQLException e) {
      LOGGER.error("Update password problem", e);
      throw new AuthPersistenceException("Update password problem");
    }
  }

  /**
   * Search for the user with the specified email.
   * 
   * @param email
   * @return user name corresponding with the the specified email.
   */
  @Override
  public String findUser(String email) throws AuthPersistenceException {

    StringBuilder query = new StringBuilder();
    query.append("SELECT username FROM ").append(TABLENAME).append(" WHERE email=?");
    PreparedStatement preparedStatement;
    String response = "";

    try {
      preparedStatement = connection.prepareStatement(query.toString());
      preparedStatement.setString(1, email);
      ResultSet result = preparedStatement.executeQuery();
      result.next();
      response = result.getString(1);

    } catch (SQLException e) {
      LOGGER.error("Email not found.", e);
      throw new AuthPersistenceException("Email not found.");
    }
    return response;
  }

  /**
   * ckeck for user credentials in database
   * 
   */
  @Override
  public boolean findUserCredentials(UserCredentialsDto userCredentials) throws AuthPersistenceException {

    boolean response = false;
    StringBuilder query = new StringBuilder();
    query.append("SELECT username, password FROM ").append(TABLENAME).append(" WHERE username=?  AND password=?");

    try {
      PreparedStatement preparedStatement = connection.prepareStatement(query.toString());
      preparedStatement.setString(1, userCredentials.getUserName());
      preparedStatement.setString(2, userCredentials.getPassword());
      ResultSet result = preparedStatement.executeQuery();
      if (result.isBeforeFirst()) {
        response = true;
      }
    } catch (SQLException e) {
      LOGGER.error("User credentials not found.", e);
      throw new AuthPersistenceException("User credentials not found.");
    }
    return response;
  }

}
