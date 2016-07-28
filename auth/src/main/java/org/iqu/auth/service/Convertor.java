package org.iqu.auth.service;

import org.iqu.auth.entities.ChangePasswordDetailes;
import org.iqu.auth.entities.User;
import org.iqu.auth.entities.UserCredentials;
import org.iqu.auth.exception.RequestBodyException;
import org.iqu.auth.persistence.dto.ChangePasswordDetailesDto;
import org.iqu.auth.persistence.dto.UserCredentialsDto;
import org.iqu.auth.persistence.dto.UserDto;

public class Convertor {

  public UserDto convertToUserDto(User user) throws RequestBodyException {

    if (user == null) {
      throw new RequestBodyException("User is null");
    }

    UserDto userDto = new UserDto(user.getUserName(), user.getPassword(), user.getFirstName(), user.getLastName(),
        user.getEmail(), user.getCountry(), user.getAge());
    return userDto;
  }

  public UserCredentialsDto convertToUserCredentialsDto(UserCredentials userCredentials) throws RequestBodyException {
    if (userCredentials == null) {
      throw new RequestBodyException("UserCredentials is null");
    }
    UserCredentialsDto userCredentialsDto = new UserCredentialsDto(userCredentials.getUserName(),
        userCredentials.getPassword());
    return userCredentialsDto;

  }

  public ChangePasswordDetailesDto convertToChangePasswordDetailesDto(ChangePasswordDetailes changePasswordDetailes) throws RequestBodyException {
    if (changePasswordDetailes == null) {
      throw new RequestBodyException("ChangePasswordDetailes is null");
    }
    ChangePasswordDetailesDto dtoChangePasswordDetailes = new ChangePasswordDetailesDto(
        changePasswordDetailes.getResetToken(), changePasswordDetailes.getNewPassword());
    return dtoChangePasswordDetailes;
  }

}
