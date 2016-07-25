package org.iqu.auth.service;

import org.iqu.auth.entities.ChangePasswordDetailes;
import org.iqu.auth.entities.User;
import org.iqu.auth.entities.UserCredentials;
import org.iqu.auth.persistence.dto.ChangePasswordDetailesDto;
import org.iqu.auth.persistence.dto.UserCredentialsDto;
import org.iqu.auth.persistence.dto.UserDto;

public class Convertor {

	public User convertUserDtoToUserEntitie(UserDto dtoUser) {
		return new User(dtoUser.getUserName(), dtoUser.getPassword(), dtoUser.getFirstName(), dtoUser.getLastName(),
				dtoUser.getEmail(), dtoUser.getCountry(), dtoUser.getAge());
	}

	public UserDto convertUserEntitieToUserDto(User user) {

		UserDto dtoUser = new UserDto(user.getUserName(), user.getPassword(), user.getFirstName(), user.getLastName(),
				user.getEmail(), user.getCountry(), user.getAge());
		return dtoUser;
	}

	public UserCredentials convertUserCredentialsDtoToUserCredentialsEntitie(UserCredentialsDto dtoUserCredentials) {
		return new UserCredentials(dtoUserCredentials.getUserName(), dtoUserCredentials.getPassword());
	}

	public UserCredentialsDto convertUserCredentialsEntitieToUserCredentialsDto(UserCredentials userCredentials) {
		UserCredentialsDto dtoUserCredentials = new UserCredentialsDto(userCredentials.getUserName(),
				userCredentials.getPassword());
		return dtoUserCredentials;

	}

	public ChangePasswordDetailes convertChangePasswordDetailesDtoToChangePasswordDetailesEntitie(
			ChangePasswordDetailesDto dtoChangePasswordDetailes) {
		return new ChangePasswordDetailes(dtoChangePasswordDetailes.getResetToken(),
				dtoChangePasswordDetailes.getNewPassword());
	}

	public ChangePasswordDetailesDto convertChangePasswordDetailesEntitieToChangePasswordDetailesDto(
			ChangePasswordDetailes changePasswordDetailes) {
		ChangePasswordDetailesDto dtoChangePasswordDetailes = new ChangePasswordDetailesDto(
				changePasswordDetailes.getResetToken(), changePasswordDetailes.getNewPassword());
		return dtoChangePasswordDetailes;
	}

}
