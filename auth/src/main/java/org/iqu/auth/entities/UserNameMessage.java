package org.iqu.auth.entities;

/**
 * 
 * @author Mitroi Stefan-Daniel
 *
 */
public class UserNameMessage {

	private String userName;

	public UserNameMessage() {

	}

	public UserNameMessage(String userName) {

		this.userName = userName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

}
