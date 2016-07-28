package org.iqu.auth.persistence.dto;

/**
 * 
 * @author Mitroi Stefan-Daniel
 *
 */
public class UserCredentialsDto {

  private String userName;
  private String password;

  public UserCredentialsDto(UserCredentialsDto userCredentials) {
    this.userName = userCredentials.getUserName();
    this.password = userCredentials.getPassword();
  }

  public UserCredentialsDto(String userName, String password) {
    this.userName = userName;
    this.password = password;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

}
