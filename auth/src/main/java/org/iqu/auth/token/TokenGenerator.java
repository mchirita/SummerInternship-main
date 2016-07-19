package org.iqu.auth.token;

import java.util.Date;
import java.util.UUID;

import org.iqu.auth.entities.Token;
import org.iqu.auth.entities.User;

/**
 * 
 * @author Mitroi Stefan-Daiel
 * 
 * Class that generate token for user
 *
 */
public class TokenGenerator {
	private Date validUntil;

	public TokenGenerator(Date validUntil) {
		this.validUntil = validUntil;
	}

	public Token generateToken(User user) {
		String token = "";
		UUID uuid = UUID.randomUUID();
		token = user.getUserName() + uuid.toString();
		return new Token(token, validUntil);
	}

	public void setValidUntil(Date validUntil) {
		this.validUntil = validUntil;
	}

}
