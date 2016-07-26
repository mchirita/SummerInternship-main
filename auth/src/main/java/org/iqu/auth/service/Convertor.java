package org.iqu.auth.service;

import org.iqu.auth.entities.ChangePasswordDetailes;
import org.iqu.auth.entities.User;
import org.iqu.auth.entities.UserCredentials;
import org.iqu.auth.persistence.dto.ChangePasswordDetailesDto;
import org.iqu.auth.persistence.dto.UserCredentialsDto;
import org.iqu.auth.persistence.dto.UserDto;

public class Convertor {

	public User convertToUserEntitie(UserDto userDto) {
		return new User(userDto.getUserName(), userDto.getPassword(), userDto.getFirstName(), userDto.getLastName(),
				userDto.getEmail(), userDto.getCountry(), userDto.getAge());
	}

	public UserDto convertToUserDto(User user) {

		UserDto userDto = new UserDto(user.getUserName(), user.getPassword(), user.getFirstName(), user.getLastName(),
				user.getEmail(), user.getCountry(), user.getAge());
		return userDto;
	}

	public UserCredentials convertToUserCredentialsEntitie(UserCredentialsDto userCredentialsDto) {
		return new UserCredentials(userCredentialsDto.getUserName(), userCredentialsDto.getPassword());
	}

	public UserCredentialsDto convertToUserCredentialsDto(UserCredentials userCredentials) {
		UserCredentialsDto userCredentialsDto = new UserCredentialsDto(userCredentials.getUserName(),
				userCredentials.getPassword());
		return userCredentialsDto;

	}

	public ChangePasswordDetailes convertToChangePasswordDetailesEntitie(
			ChangePasswordDetailesDto changePasswordDetailesDto) {
		return new ChangePasswordDetailes(changePasswordDetailesDto.getResetToken(),
				changePasswordDetailesDto.getNewPassword());
	}

	public ChangePasswordDetailesDto convertToChangePasswordDetailesDto(
			ChangePasswordDetailes changePasswordDetailes) {
		ChangePasswordDetailesDto dtoChangePasswordDetailes = new ChangePasswordDetailesDto(
				changePasswordDetailes.getResetToken(), changePasswordDetailes.getNewPassword());
		return dtoChangePasswordDetailes;
	}

}
