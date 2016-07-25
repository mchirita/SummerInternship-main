package org.iqu.auth.token;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.iqu.auth.entities.TokenInfo;
import org.iqu.auth.entities.User;

/**
 * 
 * Manage token operation such as: add, remove, update, get and contain.
 * 
 * @author Mitroi Stefan-Daniel
 * 
 * 
 */
public class TokenManager {

	private static TokenManager instance = new TokenManager();
	private Map<String, TokenInfo> tokenMap;
	private Map<String, TokenInfo> userMap;
	private Map<String, TokenInfo> resetTokenMap;
	private TokenGenerator tokenGenerator;

	private TokenManager() {
		tokenMap = new ConcurrentHashMap<String, TokenInfo>();
		userMap = new ConcurrentHashMap<String, TokenInfo>();
		resetTokenMap = new ConcurrentHashMap<String, TokenInfo>();
		tokenGenerator = new TokenGenerator();
	}

	public static TokenManager getInstance() {
		return instance;
	}

	public String generateToken(String userName) {
		LocalDateTime tokenValidityPeriod = LocalDateTime.now().plusDays(1);
		String token = tokenGenerator.generateToken(userName);
		TokenInfo tokenInfo = new TokenInfo(userName, token, tokenValidityPeriod);
		tokenMap.put(token, tokenInfo);
		userMap.put(userName, tokenInfo);
		return token;
	}

	public boolean containUser(String userName) {
		return userMap.containsKey(userName);
	}

	/**
	 * Check if token is valid.
	 * 
	 * @param token
	 * @return true if token is valid and flase otherwise.
	 */
	public boolean tokenValidator(String token) {
		boolean isValid = false;
		if (tokenMap.get(token).getvalidUntil().isAfter(LocalDateTime.now())) {
			isValid = true;
		}
		return isValid;
	}

	/**
	 * Check if user corresponding token is valid.
	 * 
	 * @param user
	 * @return true if token is valid and flase otherwise.
	 */
	public boolean tokenValidatorForUser(String userName) {
		boolean isValid = false;
		if (userMap.get(userName).getvalidUntil().isAfter(LocalDateTime.now())) {
			isValid = true;
		}
		return isValid;
	}

	public String getTokenForUser(String userName) {
		return userMap.get(userName).getToken();
	}

	public String getToken(String token) {
		TokenInfo returnToken;
		returnToken = tokenMap.get(token);
		if (returnToken != null) {
			return returnToken.getToken();
		} else {
			return "";
		}
	}

	public String getUser(String token) {
		return tokenMap.get(token).getUserName();
	}

	public void removeToken(String token) {
		tokenMap.remove(token);
	}

	public TokenInfo generateResetToken(String userName, String generateToken) {
		LocalDateTime reserTokenVAlidityPeriod = LocalDateTime.now().plusHours(1);
		TokenInfo token = new TokenInfo(userName, generateToken, reserTokenVAlidityPeriod);
		resetTokenMap.put(generateToken, token);
		return token;
	}

	public boolean containsResetToken(String userName) {

		return resetTokenMap.containsValue(userName);
	}

	public boolean resetTokenValidator(String token) {
		boolean isValid = false;
		if (resetTokenMap.get(token).getvalidUntil().isAfter(LocalDateTime.now())) {
			isValid = true;
		}
		return isValid;
	}
	
	public String getUserFromResetToken(String token){
		return resetTokenMap.get(token).getUserName();
	}

	// TO DO : implement resetTokenVAlidator() for resetTokenUserMap
}
