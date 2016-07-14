package org.iqu.auth.entities;

import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlAccessType;
/**
 * 
 * @author Beniamin Savu
 * 
 * Entity for user credentials
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
public class UserCredentials {
	
	private String userName;
	private String password;
	
	public UserCredentials(){
		
	}
	
	public UserCredentials(String username, String password) {
		this.userName = username;
		this.password = password;
	}

	public String getUsername() {
		return userName;
	}

	public void setUsername(String username) {
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
