package org.iqu.auth.persistence.dao;

import org.iqu.auth.persistence.dto.ChangePasswordDetailesDto;
import org.iqu.auth.persistence.dto.UserCredentialsDto;
import org.iqu.auth.persistence.dto.UserDto;
import org.iqu.auth.persistence.exception.AuthPersistenceException;

/**
 * 
 * @author Mitroi Stefan-Daniel
 *
 */
public interface UserDao {

	public void insertUser(UserDto user) throws AuthPersistenceException;

	public String findUser(String email) throws AuthPersistenceException;

	public boolean findUserCredentials(UserCredentialsDto uc);

	public void updatePassword(ChangePasswordDetailesDto cpddto, String userName)throws AuthPersistenceException;

}
