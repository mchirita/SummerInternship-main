package org.iqu.auth.token;

import java.util.Date;
import org.iqu.auth.entities.User;


public class TokenGenerator {
	private Date validUntil;
	
	
	public TokenGenerator(Date validUntil){
		this.validUntil = validUntil;
	}
	
	
	public Token generateToken(User user){
		String token = "";
		token=user.getUserName()+user.getPassword();
		return new Token(token, validUntil);
		
	}

	public void setValidUntil(Date validUntil) {
		this.validUntil = validUntil;
	}
	
	
}
