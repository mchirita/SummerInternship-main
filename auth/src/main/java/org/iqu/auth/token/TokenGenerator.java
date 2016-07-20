package org.iqu.auth.token;

import java.util.UUID;
import org.iqu.auth.entities.User;

/**
 * 
 * @author Mitroi Stefan-Daiel
 * 
 *         Class that generate token for user
 *
 */
public class TokenGenerator {

	public String generateToken(String userName) {
		String token = "";
		UUID uuid = UUID.randomUUID();
		token = userName + uuid.toString();
		return token;
	}
}
