package org.iqu.auth.entities;

/**
 * 
 * @author Mitroi Stefan-Daniel
 *
 */
public class TokenMessage {
	
	private String token;
	
	public TokenMessage(){
		
	}

	public TokenMessage(String token) {

		this.token = token;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
	
	
}
