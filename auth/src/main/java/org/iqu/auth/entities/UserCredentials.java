package org.iqu.auth.entities;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 
 * @author Beniamin Savu
 * 
 * Entity for user credentials
 *
 */
public class UserCredentials {
	
	private String userName;
	private String password;
	
	public UserCredentials(){
		
	}
	
	@JsonCreator
	public UserCredentials(@JsonProperty("userName") String username, @JsonProperty("password") String password) {
		this.userName = username;
		this.password = password;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String username) {
		this.userName = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "UserCredentials [username=" + userName + ", password=" + password + "]";
	}
	
	
}
