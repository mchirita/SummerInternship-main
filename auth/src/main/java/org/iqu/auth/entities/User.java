package org.iqu.auth.entities;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;

/**
 * User - Class that represents a user.
 * 
 * @author iQuest
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
			@JsonProperty("email") String email, @JsonProperty("country") String country,
			@JsonProperty("age") int age) {

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

}
