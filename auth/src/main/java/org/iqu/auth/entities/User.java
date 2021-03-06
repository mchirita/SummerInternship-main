package org.iqu.auth.entities;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;

/**
 * User - Class that represents a user.
 * 
 * @author Alex Dragomir
 *
 */
public class User {

  private String userName;
  private String password;
  private String firstName;
  private String lastName;
  private String email;
  private String country;
  private int age;

  public User() {
    super();
  }

  @JsonCreator
  public User(@JsonProperty("userName") String userName, @JsonProperty("password") String password,
      @JsonProperty("firstName") String firstName, @JsonProperty("lastName") String lastName,
      @JsonProperty("email") String email, @JsonProperty("country") String country, @JsonProperty("age") int age) {

    this.userName = userName;
    this.password = password;
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
    this.country = country;
    this.age = age;
  }

  public String getUserName() {
    return userName;
  }

  @JsonSetter("userName")
  public void setUserName(String userName) {
    this.userName = userName;
  }

  public String getPassword() {
    return password;
  }

  @JsonSetter("password")
  public void setPassword(String password) {
    this.password = password;
  }

  public String getFirstName() {
    return firstName;
  }

  @JsonSetter("firstName")
  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  @JsonSetter("lastName")
  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getEmail() {
    return email;
  }

  @JsonSetter("email")
  public void setEmail(String email) {
    this.email = email;
  }

  public String getCountry() {
    return country;
  }

  @JsonSetter("country")
  public void setCountry(String country) {
    this.country = country;
  }

  public int getAge() {
    return age;
  }

  @JsonSetter("age")
  public void setAge(int age) {
    this.age = age;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + age;
    result = prime * result + ((country == null) ? 0 : country.hashCode());
    result = prime * result + ((email == null) ? 0 : email.hashCode());
    result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
    result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
    result = prime * result + ((password == null) ? 0 : password.hashCode());
    result = prime * result + ((userName == null) ? 0 : userName.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    User other = (User) obj;
    if (age != other.age)
      return false;
    if (country == null) {
      if (other.country != null)
        return false;
    } else if (!country.equals(other.country))
      return false;
    if (email == null) {
      if (other.email != null)
        return false;
    } else if (!email.equals(other.email))
      return false;
    if (firstName == null) {
      if (other.firstName != null)
        return false;
    } else if (!firstName.equals(other.firstName))
      return false;
    if (lastName == null) {
      if (other.lastName != null)
        return false;
    } else if (!lastName.equals(other.lastName))
      return false;
    if (password == null) {
      if (other.password != null)
        return false;
    } else if (!password.equals(other.password))
      return false;
    if (userName == null) {
      if (other.userName != null)
        return false;
    } else if (!userName.equals(other.userName))
      return false;
    return true;
  }

}
